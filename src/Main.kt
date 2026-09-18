import lunar.tokenization.LunarLexer
import lunar.tokenization.tokens.TokenType

fun main() {
	val lexer = LunarLexer("digit continue is 87".toCharArray())
	println("First Token: " + lexer.token)
	lexer.setNextToken()

	while (lexer.token.type != TokenType.EndOfFileToken) {
		println("Token: " + lexer.token)
		lexer.setNextToken()
	}

	println("Last Token: " + lexer.token)

}