import lunar.tokenization.tokens.TextToken

/**
 * # [UtilTest]
 *
 * La clase [UtilTest], es la encargada de poder hacer pruebas al propio compilador, en lugares específicos.
 *
 * ## Ejemplo
 * ```Kotlin
 * fun main() {
 * 	UtilTest.test("Verificar la clase Lexer") {
 * 		val lexer = LunarLexer("UnIdentificadorEncontrado".toCharArray())
 * 		lexer.setNextToken()
 * 		"Token Procesado: " + lexer.token
 * 	}
 * }
 * ```
 * Como se muestra en el ejemplo, se usa la clase [UtilTest] para poder probar ciertas partes de la clase, para poder verificar si hay errores o no hay errores.
 *
 * ## Implementacion
 * La clase [UtilTest] tiene dos salidas, el de que todo salio bien o el que hay un error.
 *
 * <Missing Documentation Implementation>
 *
 * @author DeavidIG, DeanielIG
 * @since 1.2
 */
object UtilTest {
	/**
	 * # [test]
	 *
	 * <Missing Documentation Implementation>
	 *
	 * @return [Unit]
	 * @param name [String]: parámetro para especificar el nombre de la prueba se va a realizar
	 * @param block [Function]: parámetro para especificar el nombre de la prueba se va a realizar
	 * @author DeavidIG, DeanielIG
	 * @since 1.0
	 */
	fun test(name: String, block: () -> String) {
		try {
			println("✓ $name - ${block()}")
		} catch (e: Exception) {
			println("✗ $name")
		}
	}
}