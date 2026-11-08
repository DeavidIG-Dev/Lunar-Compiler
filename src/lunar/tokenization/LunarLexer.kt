package lunar.tokenization // Traduciendo la clase usando Claude & Google Translate. (Algunas secciones fueron traducidas)

import lunar.tokenization.chararrays.PreCharArray
import lunar.tokenization.tokens.NumericToken
import lunar.tokenization.tokens.TextToken
import lunar.tokenization.tokens.PreToken
import lunar.tokenization.tokens.Token
import lunar.tokenization.tokens.SymbolToken
import lunar.tokenization.utils.LexerError
import lunar.tokenization.chararrays.get
import lunar.tokenization.tokens.IgnoreToken
import lunar.tokenization.tokens.TokenType
import lunar.tokenization.utils.state
import lunar.utils.Spannable

/**
 * # [LunarLexer]
 *
 * <Missing Documentation implementation>
 *
 * @param input [kotlin.CharArray]: Variable especializada para guarda los datos que recibió del Archivo
 * @param name [kotlin.String] = "GenArchText.lnr": Nombre del Archivo que se está leyendo
 * @constructor Construye una Instancia del Propio Lexer y poder procesar los datos crudos
 * @author DeavidIG, DeanielIG
 * @since 1.0
 */
public class LunarLexer(input: CharArray, private val name: String = "GenArchText.lnr") {
	/**
	 * # [input]
	 *
	 * <Missing Documentation implementation>
	 *
	 * @return [Spannable]
	 * @author DeavidIG, DeanielIG
	 * @since 1.5
	 */
	public /* abstract */ val input: Spannable = Spannable(input)

	/**
	 * # [token]
	 *
	 * <Missing Documentation implementation>
	 *
	 * @return [Token]
	 * @author DeavidIG, DeanielIG
	 * @since 1.0
	 */
	public /* abstract */ var token: Token = PreToken.StartOfFileToken // -> = SymbolToken(-1)
		private set

	/**
	 * # [position]
	 *
	 * <Missing Documentation implementation>
	 *
	 * @return [Int]
	 * @author DeavidIG, DeanielIG
	 * @since 1.1
	 */
	private /* abstract */ var position: Int = 0

	/**
	 * # [line]
	 *
	 * <Missing Documentation implementation>
	 *
	 * @return [Int]
	 * @author DeavidIG, DeanielIG
	 * @since 1.1
	 */
	private /* abstract */ var line: Int = 1

	/**
	 * # [prePosition]
	 *
	 * <Missing Documentation implementation>
	 *
	 * @return [Int]
	 * @author DeavidIG, DeanielIG
	 * @since 1.0
	 */
	private /* abstract */ var prePosition: Int = 0

	/**
	 * # [isSymbolText]
	 *
	 * <Missing Documentation implementation>
	 *
	 * @return [Boolean]
	 * @author DeavidIG, DeanielIG
	 * @since 1.3
	 */
	private /* abstract */ inline val isSymbolText: Boolean
		get() = isSymbolText(index = 0)

	/**
	 * # [isSymbolText]
	 *
	 * <Missing Documentation implementation>
	 *
	 * @return [Boolean]
	 * @author DeavidIG, DeanielIG
	 * @since 1.5
	 */
	private /* abstarct */ inline fun isSymbolText(index: Int) = when (this.input[this.position + index]) {
		'=', '&', '|', '!', '?', '<', '>', '+', '-', '*', '/', '%', ':', '.' -> true
		else -> false
	}

	/**
	 * # [isIdentifierText]
	 *
	 * <Missing Documentation implementation>
	 *
	 * @return [Boolean]
	 * @author DeavidIG, DeanielIG
	 * @since 1.3
	 */
	private /* abstract */ inline val isIdentifierText: Boolean
		get() = (this.input[this.position] in 'a'..'z') /* -> (input[position] >= 'a' && 'z' >= input[position]) */ || (this.input[this.position] in 'A'..'Z') /* -> (input[position] >= 'A' && 'Z' >= input[position]) */

	/**
	 * # [isDigitText]
	 *
	 * <Missing Documentation implementation>
	 *
	 * @return [Boolean]
	 * @author DeavidIG, DeanielIG
	 * @since 1.3
	 */
	private /* abstract */ inline val isDigitText: Boolean
		get() = this.input[this.position] in '0'..'9' /* -> input[position] >= '0' && '9' >= input[position] */

	/**
	 * # [getSymbolToken]
	 *
	 * <Missing Documentation implementation>
	 *
	 * @return [SymbolToken]
	 * @author DeavidIG, DeanielIG
	 * @since 1.0
	 */
	private fun getSymbolToken(oldPosition: Int): SymbolToken /* -> Token */ {
		fun selectorOperator(type: Int): SymbolToken {
			if (this.position < this.input.size && this.isSymbolText) {
				do this.position++ while (this.position < this.input.size && this.isSymbolText)

				return SymbolToken(type = TokenType.SymbolsOperatorToken, start = oldPosition, end = this.position)
			}

			return SymbolToken(type = type, start = ++this.position)
		}

		return when (this.input[this.position]) {
			'=' -> selectorOperator(type = TokenType.EqualSymbolOperatorToken)
			'&' -> selectorOperator(type = TokenType.AndSymbolOperatorToken)
			'|' -> selectorOperator(type = TokenType.VerticalLineSymbolOperatorToken)
			'!' -> selectorOperator(type = TokenType.NotSymbolOperatorToken)
			'?' -> selectorOperator(type = TokenType.QuestionSymbolOperatorToken)
			'<' -> selectorOperator(type = TokenType.LessThanSymbolOperatorToken)
			'>' -> selectorOperator(type = TokenType.GreaterThanSymbolOperatorToken)

			'+' -> selectorOperator(type = TokenType.PlusSymbolArithmeticalOperatorToken)
			'-' -> selectorOperator(type = TokenType.MinusSymbolArithmeticalOperatorToken)
			'*' -> selectorOperator(type = TokenType.StarSymbolArithmeticalOperatorToken)
			'/' -> selectorOperator(type = TokenType.SlashSymbolArithmeticalOperatorToken)
			'%' -> selectorOperator(type = TokenType.ModuleSymbolArithmeticalOperatorToken)

			';' -> SymbolToken(type = TokenType.SemicolonSymbolDelimiterOperatorToken, start = oldPosition, ++this.position)
			':' -> selectorOperator(type = TokenType.ColonSymbolDelimiterOperatorToken)
			',' -> SymbolToken(type = TokenType.CommaSymbolDelimiterOperatorToken, start = oldPosition, ++this.position)
			'.' -> selectorOperator(type = TokenType.DotSymbolDelimiterOperatorToken)

			'(' -> SymbolToken(type = TokenType.ParenthesisLeftSymbolDelimiterSeparatorOperatorToken, start = oldPosition, ++this.position)
			')' -> SymbolToken(type = TokenType.ParenthesisRightSymbolDelimiterSeparatorOperatorToken, start = oldPosition, ++this.position)
			'{' -> SymbolToken(type = TokenType.CurlyLeftSymbolDelimiterSeparatorOperatorToken, start = oldPosition, ++this.position)
			'}' -> SymbolToken(type = TokenType.CurlyRightSymbolDelimiterSeparatorOperatorToken, start = oldPosition, ++this.position)
			'[' -> SymbolToken(type = TokenType.SquareLeftSymbolDelimiterSeparatorOperatorToken, start = oldPosition, ++this.position)
			']' -> SymbolToken(type = TokenType.SquareRightSymbolDelimiterSeparatorOperatorToken, start = oldPosition, ++this.position)

			else -> LexerError.setErrorLexer(
				type = LexerError.LexerTypeError.CharacterNotMatcher,
				line = line,
				positions = (this.position - this.prePosition)..(this.position + 1 - this.prePosition),
				text = LexerError.LexerTextError.`The symbol found (${Template}) is not valid for the Lexer - Error`(
					this.input,
					this.position
				),
				code = this.input[this.prePosition..this.position + 1],
				fileName = name
			)
		}
	}

	/**
	 * # [getIdentifierOrKeywordToken]
	 *
	 * <Missing Documentation Implementation>
	 *
	 * @return [TextToken]
	 * @param oldPosition [kotlin.Int]: parámetro encargar de guardar la posición de donde se inicio
	 * @author DeavidIG, DeanielIG
	 * @since 1.0
	 */
	private fun getIdentifierOrKeywordToken(oldPosition: Int): TextToken /* -> Token */ {
		while (this.position < this.input.size && (this.isIdentifierText || this.isDigitText || this.input[this.position] == '_' || this.input[this.position] == '$')) {
			this.position++
		}
		return when (this.position - oldPosition) {
			2 -> when { // in, of, as, is, if, do & by
				this.input.state(start = oldPosition, input = PreCharArray.InCharArray) -> TextToken(type = TokenType.InKeywordToken, start = oldPosition, end = this.position)
				this.input.state(start = oldPosition, input = PreCharArray.OfCharArray) -> TextToken(type = TokenType.OfKeywordToken, start = oldPosition, end = this.position)
				this.input.state(start = oldPosition, input = PreCharArray.AsCharArray) -> TextToken(type = TokenType.AsKeywordToken, start = oldPosition, end = this.position)
				this.input.state(start = oldPosition, input = PreCharArray.IsCharArray) -> TextToken(type = TokenType.IsKeywordToken, start = oldPosition, end = this.position)
				this.input.state(start = oldPosition, input = PreCharArray.IfCharArray) -> TextToken(type = TokenType.IfKeywordToken, start = oldPosition, end = this.position)
				this.input.state(start = oldPosition, input = PreCharArray.ByCharArray) -> TextToken(type = TokenType.ByKeywordToken, start = oldPosition, end = this.position)
				this.input.state(start = oldPosition, input = PreCharArray.DoCharArray) -> TextToken(type = TokenType.DoKeywordToken, start = oldPosition, end = this.position)

				else -> TextToken(/* type = TokenType.IdentifierToken , */ start = oldPosition, end = this.position)
			}
			3 -> when { // let, set, get, new & end
				this.input.state(start = oldPosition, input = PreCharArray.LetCharArray) -> TextToken(type = TokenType.LetKeywordToken, oldPosition, this.position)
				this.input.state(start = oldPosition, input = PreCharArray.SetCharArray) -> TextToken(type = TokenType.SetKeywordToken, start = oldPosition, end = this.position)
				this.input.state(start = oldPosition, input = PreCharArray.GetCharArray) -> TextToken(type = TokenType.GetKeywordToken, start = oldPosition, end = this.position)
				this.input.state(start = oldPosition, input = PreCharArray.NewCharArray) -> TextToken(type = TokenType.NewKeywordToken, start = oldPosition, end = this.position)
				this.input.state(start = oldPosition, input = PreCharArray.EndCharArray) -> TextToken(type = TokenType.EndKeywordToken, start = oldPosition, end = this.position)

				else -> TextToken(/* type = TokenType.IdentifierToken , */ start = oldPosition, end = this.position)
			}
			4 -> when { // from, open, class, data, with, type, this, self, base, goto, then & else
				this.input.state(start = oldPosition, input = PreCharArray.FromCharArray) -> TextToken(type = TokenType.FromKeywordToken, start = oldPosition, end = this.position)
				this.input.state(start = oldPosition, input = PreCharArray.OpenCharArray) -> TextToken(type = TokenType.OpenKeywordToken, start = oldPosition, end = this.position)
				this.input.state(start = oldPosition, input = PreCharArray.ClassCharArray) -> TextToken(type = TokenType.ClassKeywordToken, start = oldPosition, end = this.position)
				this.input.state(start = oldPosition, input = PreCharArray.DataCharArray) -> TextToken(type = TokenType.DataKeywordToken, start = oldPosition, end = this.position)
				this.input.state(start = oldPosition, input = PreCharArray.WithCharArray) -> TextToken(type = TokenType.WithKeywordToken, start = oldPosition, end = this.position)
				this.input.state(start = oldPosition, input = PreCharArray.TypeCharArray) -> TextToken(type = TokenType.TypeKeywordToken, start = oldPosition, end = this.position)
				this.input.state(start = oldPosition, input = PreCharArray.ThisCharArray) -> TextToken(type = TokenType.ThisKeywordToken, start = oldPosition, end = this.position)
				this.input.state(start = oldPosition, input = PreCharArray.SelfCharArray) -> TextToken(type = TokenType.SelfKeywordToken, start = oldPosition, end = this.position)
				this.input.state(start = oldPosition, input = PreCharArray.BaseCharArray) -> TextToken(type = TokenType.BaseKeywordToken, start = oldPosition, end = this.position)
				this.input.state(start = oldPosition, input = PreCharArray.GotoCharArray) -> TextToken(type = TokenType.GotoKeywordToken, start = oldPosition, end = this.position)
				this.input.state(start = oldPosition, input = PreCharArray.ThenCharArray) -> TextToken(type = TokenType.ThenKeywordToken, start = oldPosition, end = this.position)
				this.input.state(start = oldPosition, input = PreCharArray.ElseCharArray) -> TextToken(type = TokenType.ElseKeywordToken, start = oldPosition, end = this.position)

				else -> TextToken(/* type = TokenType.IdentifierToken , */ start = oldPosition, end = this.position)
			}
			5 -> when { // while, break, inner, exner, final, close, value, where, withs, local, infix, super
				this.input.state(start = oldPosition, input = PreCharArray.WhileCharArray) -> TextToken(type = TokenType.WhileKeywordToken, start = oldPosition, end = this.position)
				this.input.state(start = oldPosition, input = PreCharArray.BreakCharArray) -> TextToken(type = TokenType.BreakKeywordToken, start = oldPosition, end = this.position)
				this.input.state(start = oldPosition, input = PreCharArray.InnerCharArray) -> TextToken(type = TokenType.InnerKeywordToken, start = oldPosition, end = this.position)
				this.input.state(start = oldPosition, input = PreCharArray.ExnerCharArray) -> TextToken(type = TokenType.ExnerKeywordToken, start = oldPosition, end = this.position)
				this.input.state(start = oldPosition, input = PreCharArray.FinalCharArray) -> TextToken(type = TokenType.FinalKeywordToken, start = oldPosition, end = this.position)
				this.input.state(start = oldPosition, input = PreCharArray.CloseCharArray) -> TextToken(type = TokenType.CloseKeywordToken, start = oldPosition, end = this.position)
				this.input.state(start = oldPosition, input = PreCharArray.ValueCharArray) -> TextToken(type = TokenType.ValueKeywordToken, start = oldPosition, end = this.position)
				this.input.state(start = oldPosition, input = PreCharArray.WhereCharArray) -> TextToken(type = TokenType.WhereKeywordToken, start = oldPosition, end = this.position)
				this.input.state(start = oldPosition, input = PreCharArray.WithsCharArray) -> TextToken(type = TokenType.WithsKeywordToken, start = oldPosition, end = this.position)
				this.input.state(start = oldPosition, input = PreCharArray.LocalCharArray) -> TextToken(type = TokenType.LocalKeywordToken, start = oldPosition, end = this.position)
				this.input.state(start = oldPosition, input = PreCharArray.InfixCharArray) -> TextToken(type = TokenType.InfixKeywordToken, start = oldPosition, end = this.position)
				this.input.state(start = oldPosition, input = PreCharArray.SuperCharArray) -> TextToken(type = TokenType.SuperKeywordToken, start = oldPosition, end = this.position)

				else -> TextToken(/* type = TokenType.IdentifierToken , */ start = oldPosition, end = this.position)
			}
			6 -> when { // module, import, public, sealed, friend, record, object, extend, permit,  global, suffix, prefix, native, inline & return
				this.input.state(start = oldPosition, input = PreCharArray.ModuleCharArray) -> TextToken(type = TokenType.ModuleKeywordToken, start = oldPosition, end = this.position)
				this.input.state(start = oldPosition, input = PreCharArray.ImportCharArray) -> TextToken(type = TokenType.ImportKeywordToken, start = oldPosition, end = this.position)
				this.input.state(start = oldPosition, input = PreCharArray.PublicCharArray) -> TextToken(type = TokenType.PublicKeywordToken, start = oldPosition, end = this.position)
				this.input.state(start = oldPosition, input = PreCharArray.SealedCharArray) -> TextToken(type = TokenType.SealedKeywordToken, start = oldPosition, end = this.position)
				this.input.state(start = oldPosition, input = PreCharArray.FriendCharArray) -> TextToken(type = TokenType.FriendKeywordToken, start = oldPosition, end = this.position)
				this.input.state(start = oldPosition, input = PreCharArray.RecordCharArray) -> TextToken(type = TokenType.RecordKeywordToken, start = oldPosition, end = this.position)
				this.input.state(start = oldPosition, input = PreCharArray.ObjectCharArray) -> TextToken(type = TokenType.ObjectKeywordToken, start = oldPosition, end = this.position)
				this.input.state(start = oldPosition, input = PreCharArray.ExtendCharArray) -> TextToken(type = TokenType.ExtendKeywordToken, start = oldPosition, end = this.position)
				this.input.state(start = oldPosition, input = PreCharArray.PermitCharArray) -> TextToken(type = TokenType.PermitKeywordToken, start = oldPosition, end = this.position)
				this.input.state(start = oldPosition, input = PreCharArray.GlobalCharArray) -> TextToken(type = TokenType.GlobalKeywordToken, start = oldPosition, end = this.position)
				this.input.state(start = oldPosition, input = PreCharArray.SuffixCharArray) -> TextToken(type = TokenType.SuffixKeywordToken, start = oldPosition, end = this.position)
				this.input.state(start = oldPosition, input = PreCharArray.PrefixCharArray) -> TextToken(type = TokenType.PrefixKeywordToken, start = oldPosition, end = this.position)
				this.input.state(start = oldPosition, input = PreCharArray.NativeCharArray) -> TextToken(type = TokenType.NativeKeywordToken, start = oldPosition, end = this.position)
				this.input.state(start = oldPosition, input = PreCharArray.InlineCharArray) -> TextToken(type = TokenType.InlineKeywordToken, start = oldPosition, end = this.position)
				this.input.state(start = oldPosition, input = PreCharArray.ReturnCharArray) -> TextToken(type = TokenType.ReturnKeywordToken, start = oldPosition, end = this.position)

				else -> TextToken(/* type = TokenType.IdentifierToken , */ start = oldPosition, end = this.position)
			}
			7 -> when { // package, private, extends, permits, friends & control
				this.input.state(start = oldPosition, input = PreCharArray.PackageCharArray) -> TextToken(type = TokenType.PackageKeywordToken, start = oldPosition, end = this.position)
				this.input.state(start = oldPosition, input = PreCharArray.PrivateCharArray) -> TextToken(type = TokenType.PrivateKeywordToken, start = oldPosition, end = this.position)
				this.input.state(start = oldPosition, input = PreCharArray.ExtendsCharArray) -> TextToken(type = TokenType.ExtendsKeywordToken, start = oldPosition, end = this.position)
				this.input.state(start = oldPosition, input = PreCharArray.PermitsCharArray) -> TextToken(type = TokenType.PermitsKeywordToken, start = oldPosition, end = this.position)
				this.input.state(start = oldPosition, input = PreCharArray.FriendCharArray) -> TextToken(type = TokenType.FriendKeywordToken, start = oldPosition, end = this.position)
				this.input.state(start = oldPosition, input = PreCharArray.ControlCharArray) -> TextToken(type = TokenType.ControlKeywordToken, start = oldPosition, end = this.position)

				else -> TextToken(/* type = TokenType.IdentifierToken , */ start = oldPosition, end = this.position)
			}
			8 -> when { // external, internal, abstract, delegate, override, operator, function, readonly, constant & continue
				this.input.state(start = oldPosition, input = PreCharArray.ExternalCharArray) -> TextToken(type = TokenType.ExternalKeywordToken, start = oldPosition, end = this.position)
				this.input.state(start = oldPosition, input = PreCharArray.InternalCharArray) -> TextToken(type = TokenType.InternalKeywordToken, start = oldPosition, end = this.position)
				this.input.state(start = oldPosition, input = PreCharArray.AbstractCharArray) -> TextToken(type = TokenType.AbstractKeywordToken, start = oldPosition, end = this.position)
				this.input.state(start = oldPosition, input = PreCharArray.DelegateCharArray) -> TextToken(type = TokenType.DelegateKeywordToken, start = oldPosition, end = this.position)
				this.input.state(start = oldPosition, input = PreCharArray.OverrideCharArray) -> TextToken(type = TokenType.OverrideKeywordToken, start = oldPosition, end = this.position)
				this.input.state(start = oldPosition, input = PreCharArray.OperatorCharArray) -> TextToken(type = TokenType.OperatorKeywordToken, start = oldPosition, end = this.position)
				this.input.state(start = oldPosition, input = PreCharArray.FunctionCharArray) -> TextToken(type = TokenType.FunctionKeywordToken, start = oldPosition, end = this.position)
				this.input.state(start = oldPosition, input = PreCharArray.ReadonlyCharArray) -> TextToken(type = TokenType.ReadonlyKeywordToken, start = oldPosition, end = this.position)
				this.input.state(start = oldPosition, input = PreCharArray.ConstantCharArray) -> TextToken(type = TokenType.ConstantKeywordToken, start = oldPosition, end = this.position)
				this.input.state(start = oldPosition, input = PreCharArray.ContinueCharArray) -> TextToken(type = TokenType.ContinueKeywordToken, start = oldPosition, end = this.position)

				else -> TextToken(/* type = TokenType.IdentifierToken , */ start = oldPosition, end = this.position)
			}
			9 -> when { // protected, companion, structure, enumerate, attribute, interface, implement & writeonly
				this.input.state(start = oldPosition, input = PreCharArray.ProtectedCharArray) -> TextToken(type = TokenType.ProtectedKeywordToken, start = oldPosition, end = this.position)
				this.input.state(start = oldPosition, input = PreCharArray.CompanionCharArray) -> TextToken(type = TokenType.CompanionKeywordToken, start = oldPosition, end = this.position)
				this.input.state(start = oldPosition, input = PreCharArray.StructureCharArray) -> TextToken(type = TokenType.StructureKeywordToken, start = oldPosition, end = this.position)
				this.input.state(start = oldPosition, input = PreCharArray.EnumerateCharArray) -> TextToken(type = TokenType.EnumerateKeywordToken, start = oldPosition, end = this.position)
				this.input.state(start = oldPosition, input = PreCharArray.AttributeCharArray) -> TextToken(type = TokenType.AttributeKeywordToken, start = oldPosition, end = this.position)
				this.input.state(start = oldPosition, input = PreCharArray.InterfaceCharArray) -> TextToken(type = TokenType.InterfaceKeywordToken, start = oldPosition, end = this.position)
				this.input.state(start = oldPosition, input = PreCharArray.ImplementCharArray) -> TextToken(type = TokenType.ImplementKeywordToken, start = oldPosition, end = this.position)
				this.input.state(start = oldPosition, input = PreCharArray.WriteonlyCharArray) -> TextToken(type = TokenType.WriteonlyKeywordToken, start = oldPosition, end = this.position)

				else -> TextToken(/* type = TokenType.IdentifierToken , */ start = oldPosition, end = this.position)
			}
			10 -> when { // annotation, implements & companions
				this.input.state(start = oldPosition, input = PreCharArray.AnnotationCharArray) -> TextToken(type = TokenType.AnnotationKeywordToken, start = oldPosition, end = this.position)
				this.input.state(start = oldPosition, input = PreCharArray.ImplementsCharArray) -> TextToken(type = TokenType.ImplementsKeywordToken, start = oldPosition, end = this.position)
				this.input.state(start = oldPosition, input = PreCharArray.CompanionsCharArray) -> TextToken(type = TokenType.CompanionsKeywordToken, start = oldPosition, end = this.position)

				else -> TextToken(/* type = TokenType.IdentifierToken , */ start = oldPosition, end = this.position)
			}
			11 -> when { // constructor
				this.input.state(start = oldPosition, input = PreCharArray.ConstructorCharArray) -> TextToken(type = TokenType.ConstructorKeywordToken, start = oldPosition, end = this.position)

				else -> TextToken(/* type = TokenType.IdentifierToken , */ start = oldPosition, end = this.position)
			}

			else -> TextToken(/* type = TokenType.IdentifierToken , */ start = oldPosition, end = this.position)
		}
		// return TextToken(/* type = TokenType.IdentifierToken , */ start = oldPosition, end = position)
	}

	/**
	 * # [getNumericsToken]
	 *
	 * <Missing Documentation Implementation>
	 *
	 * @return [NumericToken]
	 * @param oldPosition [kotlin.Int]: parámetro encargar de guardar la posición de donde se inicio
	 * @author DeavidIG, DeanielIG
	 * @since 1.0
	 */
	private fun getNumericsToken(oldPosition: Int): NumericToken /* -> Token */ {
		var isDoubleUnderline = false

		// Sección de los Enteros
		while (this.position < this.input.size && (this.isDigitText || this.input[this.position] == '_') && !isDoubleUnderline) { // recorder dígitos hasta encontrar el límite o ya no hat dígitos
			isDoubleUnderline = this.input[this.position - 1] == '_' && this.input[this.position] == '_'
			this.position++
		}

		if (isDoubleUnderline) {
			LexerError.setErrorLexer(
				type = LexerError.LexerTypeError.CharacterDuplicateFound,
				line = line,
				positions = (oldPosition - this.prePosition..this.position - this.prePosition),
				text = LexerError.LexerTextError.`The Digits You Are Entering Contain A Double Underline - Error`,
				code = this.input[this.prePosition..position],
				fileName = name
			)
		} else if (this.input[this.position - 1] == '_' && (this.position >= this.input.size || this.input[this.position] == '.')) {
			LexerError.setErrorLexer(
				type = LexerError.LexerTypeError.CharacterNotMatcher,
				line = line,
				positions = (oldPosition - this.prePosition..this.position + 1 - this.prePosition),
				text = LexerError.LexerTextError.`There Is No Digit After The Underscore, But A Period Is Being Entered In Place Of The Digit - Error`,
				code = this.input[this.prePosition..this.position + 1],
				fileName = name
			)
		} else if (this.input[this.position - 1] == '_' && (this.position >= this.input.size || !this.isDigitText)) {
			LexerError.setErrorLexer(
				type = LexerError.LexerTypeError.CharacterNotMatcher,
				line = line,
				positions = (oldPosition - this.prePosition..this.position - this.prePosition),
				text = LexerError.LexerTextError.`There Are No Digits After The Underscore - Error`,
				code = this.input[this.prePosition..position],
				fileName = name
			)
		}

		// Sección de los Decimales
		if (this.position < this.input.size && this.input[this.position] == '.') { // Validador para saber si va a ser punto decimal y si está dentro de los límites
			this.position++

			if (this.position < this.input.size && this.input[this.position] == '_') {
				LexerError.setErrorLexer(
					type = LexerError.LexerTypeError.CharacterNotMatcher,
					line = line,
					positions = (oldPosition - this.prePosition - 1..this.position - this.prePosition),
					text = LexerError.LexerTextError.`There Is A Hyphen Below, After The Decimal Point - Error`,
					code = this.input[this.prePosition..this.position + 1],
					fileName = name
				)
			} else if (!(this.position < this.input.size && this.isDigitText)) { // Verificamos si no hay digito, para retornar error y si no está dentro de los límites
				this.position--
				return NumericToken(/* type = TokenType.NumberLiteralTypeToken , */ start = oldPosition, end = position)
			}
			this.position++

			isDoubleUnderline = false

			while (this.position < this.input.size && (this.isDigitText || this.input[this.position] == '_') && !isDoubleUnderline) { // recorder dígitos hasta encontrar el límite o ya no hat dígitos
				isDoubleUnderline = this.input[this.position - 1] == '_' && this.input[this.position] == '_'
				this.position++
			}

			if (isDoubleUnderline) {
				LexerError.setErrorLexer(
					type = LexerError.LexerTypeError.CharacterDuplicateFound,
					line = line,
					positions = oldPosition..this.position,
					text = LexerError.LexerTextError.`The Digits You Are Entering Contain A Double Underline - Error`,
					code = this.input[this.prePosition..this.position],
					fileName = name
				)
			} else if (this.input[this.position - 1] == '_' && (this.position >= this.input.size || !this.isDigitText)) {
				LexerError.setErrorLexer(
					type = LexerError.LexerTypeError.CharacterNotMatcher,
					line = line,
					positions = oldPosition..this.position,
					text = LexerError.LexerTextError.`There Are No Digits After The Underscore - Error`,
					code = this.input[this.prePosition..this.position],
					fileName = name
				)
			}

			// Sección del resultado
			return if (position < this.input.size) when (this.input[position]) {
				'f', 'F' -> NumericToken(/* type = TokenType.FloatLiteralTypeToken , */ start = oldPosition, end = ++position)
				'd', 'D' -> NumericToken(/* type = TokenType.DoubleLiteralTypeToken , */ start = oldPosition, end = ++position)
				else -> NumericToken(/* type = TokenType.NumberLiteralTypeToken , */ start = oldPosition, end = position)
			}
			else NumericToken(/* type = TokenType.NumberLiteralTypeToken , */ start = oldPosition, end = position)
		}

		// Sección del resultado
		return if (position < input.size) when (input[position]) {
				'b', 'B' -> NumericToken(/* type = TokenType.ByteLiteralTypeToken , */ start = oldPosition, end = ++position)
				's', 'S' -> NumericToken(/* type = TokenType.ShortLiteralTypeToken , */ start = oldPosition, end = ++position)
				'i', 'I' -> NumericToken(/* type = TokenType.IntegerLiteralTypeToken , */ start = oldPosition, end = ++position)
				'l', 'L' -> NumericToken(/* type = TokenType.LongLiteralTypeToken , */ start = oldPosition, end = ++position)
				'f', 'F' -> NumericToken(/* type = TokenType.FloatLiteralTypeToken , */ start = oldPosition, end = ++position)
				'd', 'D' -> NumericToken(/* type = TokenType.DoubleLiteralTypeToken , */ start = oldPosition, end = ++position)
				else -> NumericToken(/* type = TokenType.NumberLiteralTypeToken , */ start = oldPosition, end = position)
			}
			else NumericToken(/* type = TokenType.NumberLiteralTypeToken ,*/ start = oldPosition, end = position)
	}

	/**
	 * # [setNextToken]
	 *
	 * <Missing Documentation implementation>
	 *
	 * @return [Unit]
	 * @author DeavidIG, DeanielIG
	 * @since 1.0
	 * @see PreToken
	 * @see Parser
	 * @see getNumericsToken
	 * @see getIdentifierOrKeywordToken
	 * @see getSymbolToken
	 */
	public fun setNextToken(): Unit /* -> Void */ {
		if (this.position >= this.input.size) { // Validador para saber si se terminó el archivo
			this.token = PreToken.EndOfFileToken
			return // Ya no hay archivo que procesar
		}

		val oldPosition = this.position // Guardar Position de Inicio

		while (this.position < this.input.size && (this.input[this.position] == '\n' || this.input[this.position] == '\r')) {
			if (/* (REMOVED: The reason is that double-increment in Window) input[position] == '\r' || */ this.input[this.position] == '\n') {
				this.line++
				this.prePosition = this.position
			}
			this.position++
		}

		if (this.position < this.input.size && (this.input[this.position] == ' ' || this.input[this.position] == '\t')) { // Validador para saber si tiene un espacio
			this.position++
			while (this.position < this.input.size && (this.input[this.position] == ' ' || this.input[this.position] == '\t')) {
				this.position++
			}

			this.token = IgnoreToken(type = TokenType.WhitespaceToken)
			return // espacios que fue transformado
		}

		if (this.isIdentifierText) { // Validar si el carácter actual pertenece a una Letra
			this.position++
			this.token = getIdentifierOrKeywordToken(oldPosition)
			return // texto que fue transformado
		} // Por si no es un Letra

		if (this.isDigitText) { // Validar si el carácter actual pertenece a un Dígito
			this.position++
			this.token = getNumericsToken(oldPosition)
			return // texto que fue transformado
		} // Por si no es un Dígito

		this.token = getSymbolToken(this.position)
		// (REMOVED: Consume an extra character) this.position++
	}
}