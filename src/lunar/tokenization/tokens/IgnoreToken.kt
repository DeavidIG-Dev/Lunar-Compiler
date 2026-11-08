package lunar.tokenization.tokens

/**
 * # [IgnoreToken]
 *
 * <Missing Documentation implementation>
 *
 * @since 1.0
 * @constructor Constructor for creating an instance of the Text Symbol; stores where it starts and where it ends.
 * @param type [kotlin.Int]: To obtain the associated type of the Symbol.
 * @author DeavidIG
 * @author DeanielIG
 * @author Claude (Translator)
 */
data class IgnoreToken(
	override val type: Int
) : Token {
	override fun toString(): String {
		return "IgnoreToken(type=$type) { \"Whitespace\" }"
	}
}