package lunar.tokenization.tokens

import lunar.tokenization.LunarLexer

/**
 * # [PreToken]
 *
 * <Missing Documentation implementation>
 *
 * @see Parser
 * @see LunarLexer
 * @see SymbolToken
 *
 */
object PreToken {
	/**
	 * # [StartOfFileToken]
	 *
	 * <Missing Documentation implementation>
	 *
	 * @return [SymbolToken]
	 */
	val StartOfFileToken = SymbolToken(TokenType.StartOfFileToken /* -> 0 */)
	/**
	 * # [EndOfFileToken]
	 *
	 * <Missing Documentation implementation>
	 *
	 * @return [SymbolToken]
	 */
	val EndOfFileToken = SymbolToken(TokenType.EndOfFileToken /* -> 1 */)
}