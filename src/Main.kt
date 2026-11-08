import lunar.tokenization.LunarLexer
import lunar.tokenization.tokens.IgnoreToken
import lunar.tokenization.tokens.SymbolToken
import lunar.tokenization.tokens.TokenType

import java.io.FileWriter
import java.io.IOException

fun main() {
	val input = """(a: Integer) ?: (b: Integer):Unit={return if(a==0)b else a;}"""
	val lexer = LunarLexer(input = input.toCharArray())
	println("First Token: " + lexer.token)
	lexer.setNextToken()

	while (lexer.token.type != TokenType.EndOfFileToken) {
		println("Token: ${lexer.token}${if (lexer.token is SymbolToken && (lexer.token as SymbolToken).end - (lexer.token as SymbolToken).start != 1) ", Text: '${
			lexer.input.slide(
				lexer.token
			)
		}'" else if (lexer.token !is IgnoreToken) ", Text: '${
			lexer.input.slide(
				lexer.token
			)
		}'" else ""}")
		lexer.setNextToken()
	}

	println("Last Token: " + lexer.token)
}