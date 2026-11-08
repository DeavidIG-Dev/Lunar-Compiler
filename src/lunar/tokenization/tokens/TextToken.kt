package lunar.tokenization.tokens

/**
 * # [TextToken]
 *
 * <Missing Documentation implementation>
 *
 * @since 1.0
 * @see [Semantic]
 * @see [Parser]
 * @see [AbstractSyntaxTree]
 * @constructor Constructor for creating an instance of the Text Symbol; stores where it starts and where it ends.
 * @param type [kotlin.Int] = [TokenType.IdentifierToken]: To obtain the associated type of the Symbol.
 * @param start [kotlin.Int]: To obtain the initial position where the data/text begins.
 * @param end [kotlin.Int]: To obtain the final position where the data/text ends.
 * @author DeavidIG
 * @author DeanielIG
 */
data class TextToken(
	override val type: Int = TokenType.IdentifierToken,
	val start: Int,
	val end: Int
) : Token {
	override fun toString(): String {
		return "TextToken(type=$type, start=$start, end=$end) { \"Identifier\" }"
	}
}