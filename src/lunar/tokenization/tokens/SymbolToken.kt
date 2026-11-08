package lunar.tokenization.tokens

/**
 * # [SymbolToken]
 *
 * <Missing Documentation implementation>
 *
 * @since 1.0
 * @constructor Constructor for creating an instance of the Text Symbol; stores where it starts and where it ends.
 * @param type [kotlin.Int]: To obtain the associated type of the Symbol.
 * @param start [kotlin.Int]: To obtain the initial position where the data/text begins.
 * @param end [kotlin.Int]: To obtain the final position where the data/text ends.
 * @author DeavidIG
 * @author DeanielIG
 * @author Claude (Translator)
 */
data class SymbolToken(
	override val type: Int,
	val start: Int = -1,
	val end: Int = start + 1
) : Token {
	override fun toString(): String {
		return "SymbolToken(type=$type, start=$start, end=$end) { \"${when (type) {
			TokenType.EqualSymbolOperatorToken -> "="
			TokenType.AndSymbolOperatorToken -> "&"
			TokenType.VerticalLineSymbolOperatorToken -> "|"
			TokenType.NotSymbolOperatorToken -> "!"
			TokenType.QuestionSymbolOperatorToken -> "?"
			TokenType.LessThanSymbolOperatorToken -> "<"
			TokenType.GreaterThanSymbolOperatorToken -> ">"
			
			TokenType.PlusSymbolArithmeticalOperatorToken -> "+"
			TokenType.MinusSymbolArithmeticalOperatorToken -> "-"
			TokenType.StarSymbolArithmeticalOperatorToken -> "*"
			TokenType.SlashSymbolArithmeticalOperatorToken -> "/"
			TokenType.ModuleSymbolArithmeticalOperatorToken -> "%"

			TokenType.SemicolonSymbolDelimiterOperatorToken -> ";"
			TokenType.ColonSymbolDelimiterOperatorToken -> ":"
			TokenType.CommaSymbolDelimiterOperatorToken -> ","
			TokenType.DotSymbolDelimiterOperatorToken -> "."

			TokenType.ParenthesisLeftSymbolDelimiterSeparatorOperatorToken -> "("
			TokenType.ParenthesisRightSymbolDelimiterSeparatorOperatorToken -> ")"
			TokenType.CurlyLeftSymbolDelimiterSeparatorOperatorToken -> "{"
			TokenType.CurlyRightSymbolDelimiterSeparatorOperatorToken -> "}"
			TokenType.SquareLeftSymbolDelimiterSeparatorOperatorToken -> "["
			TokenType.SquareRightSymbolDelimiterSeparatorOperatorToken -> "]"

			TokenType.StartOfFileToken -> "Start Of Input File"
			TokenType.EndOfFileToken -> "End Of Input File"
			else -> "Symbol"
		}}\" }"
	}
}