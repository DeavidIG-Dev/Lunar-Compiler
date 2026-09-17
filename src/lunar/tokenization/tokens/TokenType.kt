package lunar.tokenization.tokens

object TokenType {
	/**
	 * # [StartOfFileToken]
	 *
	 * La variable [StartOfFileToken] es para especificar cuando el Lexer está iniciando un Archivo de texto.
	 *
	 * @return [Int] = 0
	 */
	const val StartOfFileToken: Int = 0

	/**
	 * # [EndOfFileToken]
	 *
	 * La variable [EndOfFileToken] es para especificar cuando el Lexer término de lexeficar el Archivo de texto.
	 *
	 * @return [Int] = 1
	 */
	const val EndOfFileToken: Int = 1

	/**
	 * # [IdentifierToken]
	 *
	 * La variable [IdentifierToken] es para especificar cuando se encontró un nombre que no es una Palabra clave del propio Lenguaje de Programación, ejemplo.
	 * ```Text
	 * Hello -> NammedToken(/* type= */ TokenType.IdentifierToken, /* start= */ 0, /* end= */ 5)
	 * ```
	 *
	 * @return [Int] = 2
	 */
	const val IdentifierToken: Int = 2

	/**
	 * # [NumberLiteralTypeToken]
	 *
	 * La variable [NumberLiteralTypeToken] es para especificar cuando se encontró un número y que no es una Palabra clave del propio Lenguaje de Programación, ejemplo.
	 * ```Text
	 * 78540 -> NumericToken(/* type= */ TokenType.NumberLiteralTypeToken, /* start= */ 0, /* end= */ 5)
	 * ```
	 *
	 * @return [Int] = 2
	 */
	const val NumberLiteralTypeToken = 10
}