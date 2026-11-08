package lunar.utils

import lunar.tokenization.tokens.IgnoreToken
import lunar.tokenization.tokens.NumericToken
import lunar.tokenization.tokens.SymbolToken
import lunar.tokenization.tokens.TextToken
import lunar.tokenization.tokens.Token

@JvmInline
public value class Spannable(public val text: CharArray) {
	val size: Int get() = this.text.size

	public operator fun get(index: Int): Char = text[index]

	public fun slide(token: Token): String =
		when (token) {
			is IgnoreToken -> ""
			is NumericToken -> String(chars = text, offset = token.start, length = token.end - token.start)
			is TextToken -> String(chars = text, offset = token.start, length = token.end - token.start)
			is SymbolToken -> String(chars = text, offset = token.start, length = token.end - token.start)
		}
}