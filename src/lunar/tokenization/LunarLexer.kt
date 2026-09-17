package lunar.tokenization

import lunar.tokenization.tokens.NumericToken
import lunar.tokenization.tokens.TextToken
import lunar.tokenization.tokens.PreToken
import lunar.tokenization.tokens.Token
import lunar.tokenization.tokens.SymbolToken

/**
 * # [LunarLexer]
 *
 * La clase [LunarLexer], es la encargada de poder procesar datos cruda a datos usable.
 *
 * La clase está marcada como `abstract` para dar comiendo a la documentacion y explicacion de la propia clase y sus metodos.
 *
 * @param kotlin.CharArray input: Variable especializada para guarda los datos que recibió del Archivo
 * @constructor Construye una Instancia del Propio Lexer y poder procesar los datos crudos
 * @author DeavidIG, DeanielIG
 * @since 1.0
 */
abstract class LunarLexer(private val input: CharArray) {
	/**
	 * # [token]
	 *
	 * La variable [token] es para obtener el token que fue procesado por el propio [LunarLexer].
	 * Además, solo se puede obtener desde afuera o internamente de la clase [LunarLexer], cualquiera que quiera cambiar su estado queda
	 * estrictamente bloqueado por seguridad.
	 *
	 * Ejemplo de su uso.
	 * ```Kotlin
	 * val IdentifierToken: TextToken = lexerInstance.token as TextToken;
	 * ```
	 *
	 * No solo está estrictamente para obtener datos, sino, para el formato **crudo**, ejemplo.
	 * ```Kotlin
	 * if (lexerInstance.token is TextToken && lexerInstance.token.type == TokenType.IdentifierToken) {
	 * 	println("¡Es un identificador!")
	 * }
	 * ```
	 *
	 * Lo que si no se pueda hacer, es tartar de cambiar su estado desde afuera. Ya que su estado `set` (o `setter`) está marcado como `private`.
	 * Por lo cual, lo siguiente no se puede "validar".
	 * ```Kotlin
	 * // Usando la clase TextToken.
	 * lexerInstance.token = TextToken(/* type= */ TokenType.IdentifierToken, /* start= */ 0, /* end= */ 5);
	 *
	 * // Usando la clase NumericToken.
	 * lexerInstance.token = NumericToken(/* type= */ TokenType.NumberLiteralTypeToken, /* start= */ 0, /* end= */ 3);
	 *
	 * // Usando la clase SymbolToken.
	 * lexerInstance.token = SymbolToken(/* type= */ TokenType.SemicoloDelimiterToken);
	 * ```
	 *
	 * @return [Token]
	 * @author DeavidIG, DeanielIG
	 * @since 1.0
	 */
	/* abstract */ var token: Token = PreToken.StartOfFileToken // -> = UnnamedToken(-1)
		private set

	/**
	 * # [position]
	 * La variable [position] es un cursor interno del propio [LunarLexer] para poder saber en qué parte de carácter se está viendo y se va a evaluar. Además,
	 * no se puede obtener desde afuera por razones de seguridad para evitar sobre escribimiento incorrecto que puede corromper luego los datos que se está procesando.
	 *
	 * Ejemplo de uso.
	 * ```Kotlin
	 * if (input[position] == ' ') {
	 * 	println("¡Es un espacio!")
	 * 	position++
	 * }
	 * ```
	 * Lo que si no se puede hacer es tratar ver su estado desde afuera. Ya que su `get` (o `getter`) está marcado como `private`. Por lo cual, lo siguiente no se puede "aceptar":
	 * ```Kotlin
	 * 	if (lexerInstance.position == 2) {
	 * 		println("¡Esta en la posicion 2!")
	 * 		position++
	 * 	}
	 * ```
	 * O incluso mismo tartar de cambiar su estado desde afuera. Ya que su `set` (o `setter`) esta marcado igualmente como `private`, ya que son por motivos de seguridad y estabilidad. Por lo cual, lo siguiente no se puede "aceptar":
	 * ```Kotlin
	 * 	lexerInstance.position = 85 // Cambiar su posicion al 85
	 * 	println("¡Cambie la posicion a 85 del 'lexerInstance.position': ${lexerInstance.position!)
	 * ```
	 *
	 * @return [Int]
	 * @author DeavidIG, DeanielIG
	 * @since 1.1
	 */
	private /* abstract */ var position: Int = 0

	/**
	 * # [getSymbolToken]
	 *
	 * <Missing Documentation implementation>
	 *
	 * @return [SymbolToken]
	 * @author DeavidIG, DeanielIG
	 * @since 1.0
	 */
	/* private */ abstract fun getSymbolToken(): SymbolToken // -> Token

	/**
	 * # [getIdentifierToken]
	 *
	 * <Missing Documentation Implementation>
	 *
	 * @return [TextToken]
	 * @param kotlin.Int oldPosition: parámetro encargar de guardar la posición de donde se inicio
	 * @author DeavidIG, DeanielIG
	 * @since 1.0
	 */
	/* private */ abstract fun getIdentifierToken(oldPosition: Int): TextToken // -> Token

	/**
	 * # [getNumericsToken]
	 *
	 * <Missing Documentation Implementation>
	 *
	 * @return [TextToken]
	 * @param kotlin.Int oldPosition: parámetro encargar de guardar la posición de donde se inicio
	 * @author DeavidIG, DeanielIG
	 * @since 1.0
	 */
	/* private */ abstract fun getNumericsToken(oldPosition: Int): NumericToken // -> Token

	/**
	 * # [setNextToken]
	 *
	 * La función [setNextToken] es la encargada de poder procesar los textos a crudos a datos, para que él [Parser] pueda usar.
	 * Asi mismo, es el encargado de optimizar y hacer eficiente los datos que recibió por parte del Archivo.
	 *
	 * ## Algoritmos
	 * Los algoritmos que se usa es de forma Secuencial (O(n)) para procesar los datos para predecir y determinar los datos que él [LunarLexer] recibió.
	 * No se usa otro tipo de Algoritmo no porque sae difícil de implementar, sino, porque puede retornar datos corruptos o frágiles a por consecuencia puede romper el propio Compilador.
	 *
	 * ## Implementación
	 * Al implementar Secuancial (O(N)), puede hacer que los caracteres que leer puede ser más facil de entender. Sin tratar de estar determinando o prediciendo cada "instruccion".
	 * Aunque a veces no se hace el Algoritmo Secuancial (O(N)), ya que va a ver casos que puede ser del propio Constant Time O(1). Pero se usa el Secuancial, ya que está mayormente presente.
	 *
	 * @return [Unit]
	 * @author DeavidIG, DeanielIG
	 * @since 1.0
	 */
	fun setNextToken(): Unit /* -> Void */ {
		if (position >= input.size) { // Validador para saber si se terminó el archivo
			token = PreToken.EndOfFileToken
			return // Ya no hay archivo que procesar
		}

		val oldPosition = position // Guardar Position de Inicio

		if ((input[position] >= 'a' && 'z' >= input[position]) || (input[position] >= 'A' && 'Z' >= input[position])) { // Validar si el carácter actual pertenece a una Letra
			position++
			token = getIdentifierToken(oldPosition)
			return // texto que fue transformado
		} // Por si no es un Letra

		if (input[position] >= '0' && '9' >= input[position]) { // Validar si el carácter actual pertenece a un Dígito
			position++
			token = getNumericsToken(oldPosition)
			return // texto que fue transformado
		} // Por si no es un Dígito
	}
}