package lunar.tokenization.utils

import lunar.tokenization.tokens.TextToken
import kotlin.system.exitProcess

/**
 * # [LexerError]
 *
 * <Missing Documentation Implementation>
 *
 * @author DeavidIG, DeanielIG
 * @since 1.0
 */
object LexerError {
	/**
	 * # [LexerTypeError]
	 *
	 * <Missing Documentation Implementation>
	 *
	 * @param message [kotlin.String]: parámetro encargar para decir el nombre del error
	 * @author DeavidIG, DeanielIG
	 * @since 1.2
	 */
	enum class LexerTypeError(val message: String) {
		/**
		 * # [CharacterNotMatcher]
		 *
		 * <Missing Documentation Implementation>
		 *
		 * @param message [kotlin.String]: parámetro encargar para decir el nombre del error
		 * @author DeavidIG, DeanielIG
		 * @since 1.2
		 */
		CharacterNotMatcher(message = "Character Not Matcher"),
		/**
		 * # [CharacterNotFound]
		 *
		 * <Missing Documentation Implementation>
		 *
		 * @param message [kotlin.String]: parámetro encargar para decir el nombre del error
		 * @author DeavidIG, DeanielIG
		 * @since 1.2
		 */
		CharacterNotFound(message = "Character Not Found");
	}

	/**
	 * # [setErrorLexer]
	 *
	 * <Missing Documentation Implementation>
	 *
	 * @return [Nothing]
	 * @param type [lunar.tokenization.utils.LexerError.LexerTypeError]: parámetro encargar para especificar el tipo error
	 * @param position [kotlin.Int]: parámetro encargar para especificar en que lugar se encuentra el error
	 * @param text [kotlin.String]: parámetro encargar para especificar un mensaje de error que lo provoca
	 * @author DeavidIG, DeanielIG
	 * @since 1.2
	 */
	fun setErrorLexer(type: LexerTypeError, position: Int, text: String): Nothing {
		print("[Lunar.Lexer - 1.0 alpha] ${type.message} (Syntax Error): {position: $position} $text")
		exitProcess(-1)
	}
}