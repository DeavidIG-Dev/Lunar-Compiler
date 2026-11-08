package lunar.tokenization.utils

import lunar.utils.Spannable
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
	 * # [LexerTextError]
	 *
	 * <Missing Documentation Implementation>
	 *
	 * @author DeavidIG, DeanielIG
	 * @since 1.2
	 */
	object LexerTextError {
		/**
		 * # [`There Is No Digit After The Decimal Point - Error`]
		 *
		 * <Missing Documentation Implementation>
		 *
		 * @author DeavidIG, DeanielIG
		 * @since 1.2
		 */
		const val `There Is No Digit After The Decimal Point - Error` = "There is no digit after the decimal point."

		/**
		 * # [`There Is A Hyphen Below, After The Decimal Point - Error`]
		 *
		 * <Missing Documentation Implementation>
		 *
		 * @author DeavidIG, DeanielIG
		 * @since 1.2
		 */
		const val `There Is A Hyphen Below, After The Decimal Point - Error` = "There is a hyphen below, after the decimal point."

		/**
		 * # [`There Is No Digit After The Underscore, But A Period Is Being Entered In Place Of The Digit - Error`]
		 *
		 * <Missing Documentation Implementation>
		 *
		 * @author DeavidIG, DeanielIG
		 * @since 1.2
		 */
		const val `There Is No Digit After The Underscore, But A Period Is Being Entered In Place Of The Digit - Error` = "There is no digit after the underscore, but a period (.) is being entered in place of the digit."

		/**
		 * # [`There Are No Digits After The Underscore - Error`]
		 *
		 * <Missing Documentation Implementation>
		 *
		 * @author DeavidIG, DeanielIG
		 * @since 1.2
		 */
		const val `There Are No Digits After The Underscore - Error` = "There are no digits after the underscore."

		/**
		 * # [`The Digits You Are Entering Contain A Double Underline - Error`]
		 *
		 * <Missing Documentation Implementation>
		 *
		 * @author DeavidIG, DeanielIG
		 * @since 1.2
		 */
		const val `The Digits You Are Entering Contain A Double Underline - Error` = "The digits you are entering contain a double underline."

		/**
		 * # [`The symbol found (${Template}) is not valid for the Lexer - Error`]
		 *
		 * <Missing Documentation Implementation>
		 *
		 * @author DeavidIG, DeanielIG
		 * @since 1.5
		 */
		fun `The symbol found (${Template}) is not valid for the Lexer - Error`(input: Spannable, position: Int) = "The symbol found (${input[position]}) is not valid for the Lexer.";
	}

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
		 * # [CharacterDuplicateFound]
		 *
		 * <Missing Documentation Implementation>
		 *
		 * @param message [kotlin.String]: parámetro encargar para decir el nombre del error
		 * @author DeavidIG, DeanielIG
		 * @since 1.2
		 */
		CharacterDuplicateFound(message = "Character Duplicate Found");
	}

	/**
	 * # [setErrorLexer]
	 *
	 * <Missing Documentation Implementation>
	 *
	 * @return [Nothing]
	 * @param type [lunar.tokenization.utils.LexerError.LexerTypeError]: parámetro encargar para especificar el tipo error
	 * @param positions [IntRange]: parámetro encargar para especificar en que lugar se encuentra el error
	 * @param text [kotlin.String]: parámetro encargar para especificar un mensaje de error que lo provoca
	 * @author DeavidIG, DeanielIG
	 * @since 1.2
	 */
	fun setErrorLexer(type: LexerTypeError, fileName: String, line: Int = 0, positions: IntRange, text: String, code: String? = null): Nothing {
		System.err.print("[Lunar.Lexer - 1.0 alpha] ${type.message} (Syntax Error): {line: $line, columns: [${positions.first}, ${positions.last - 2}], name: \"$fileName\"} $text")
		if (code != null) {
			System.err.println()
			System.err.println(" ".repeat(line.toString().length) + " | ")
			System.err.println("$line | ${if (code.startsWith("\n")) code.substringAfter('\n') else code}")
			if (positions.last - positions.first != 1) System.err.println(" ".repeat(line.toString().length) + " | " + " ".repeat((if (code.startsWith("\n")) code.length - 1 else code.length) - (positions.last - positions.first)) + "^" + "~".repeat(positions.last - positions.first - 2) + "^")
			else System.err.println(" ".repeat(line.toString().length) + " | " + " ".repeat((if (code.startsWith("\n")) code.length - 1 else code.length) - (positions.last - positions.first)) + "^")
			System.err.println(" ".repeat(line.toString().length) + " | ")
		}
		exitProcess(-1)
	}
}