package lunar.tokenization.tokens

object PreToken {
	/**
	 * # [StartOfFileToken]
	 *
	 * La variable [StartOfFileToken], es un pre-construido para evitar la sobrecarga o sobre esfuerzo del CPU para reprocesar el mismo dato.
	 * Es decir, reutilizar una sola instancia general.
	 *
	 * @return [SymbolToken]
	 */
	val StartOfFileToken = SymbolToken(TokenType.StartOfFileToken /* -> 0 */)

	/**
	 * # [EndOfFileToken]
	 *
	 * La variable [EndOfFileToken], es un pre-construido para evitar la sobrecarga o sobre esfuerzo del CPU para reprocesar el mismo dato.
	 * Es decir, reutilizar una sola instancia general.
	 *
	 * @return [SymbolToken]
	 */
	val EndOfFileToken = SymbolToken(TokenType.EndOfFileToken /* -> 1 */)
}