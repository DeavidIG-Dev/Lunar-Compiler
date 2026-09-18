import lunar.tokenization.LunarLexer
import lunar.tokenization.tokens.NumericToken
import lunar.tokenization.tokens.TextToken

/**
 * # [main]
 *
 * <Missing Documentation Implementation>
 *
 * @return [Unit]
 * @author DeavidIG, DeanielIG
 * @since 1.2
 */
fun main() {
	UtilTest.test("obtener el identificar del propio Lexer") {
		val input = "UnIdentificadorEncontrado".toCharArray()
		val lexer = LunarLexer(input)

		lexer.setNextToken()
		val token = lexer.token as TextToken

		"Token Procesado: " + token + ", Texto: " + String(input, token.start, token.end - token.start)
	}

	UtilTest.test("obtener un numero del propio Lexer") {
		val input = "15784".toCharArray()
		val lexer = LunarLexer(input)

		lexer.setNextToken()
		val token = lexer.token as NumericToken

		"Token Procesado: " + token + ", Numero: " + String(input, token.start, token.end - token.start)
	}
}

