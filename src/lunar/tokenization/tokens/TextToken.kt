package lunar.tokenization.tokens

/**
 * # [TextToken]
 *
 * La clase [TextToken] es la encargada de transformar el Texto crudo a datos usable para él [Parser], puede guardar el tipo asociado, posición inimical, como la posición final.
 *
 * A diferencia del [SymbolToken], se guarda las posiciones iniciales y finales, para poder saber qu contiene el propio dato dentro del archivo.
 * Ejemplo:
 * ```Text
 * SoyUnTexto -> NamedToken(/* type= */ TokenType.IdentifierToken, /* start= */ 0, /* end= */ 10)
 * ^^^^^^^^^^
 * 0        10
 * ```
 * En el ´SoyUnTexto´ se necesita saber esos datos, para poder guardar datos importantes y si no se guardaba no se podria saber lo que contiene el propio ´SoyUnTexto´, ya que puede ser un ´NoSoyUnTexto´ o cualquier dato
 * solo se tendría el dato de [TokenType.IdentifierToken] sin saber quien es.
 *
 * @since 1.0
 * @see [Semantic]
 * @see [Parser]
 * @see [AbstractSyntaxTree]
 * @constructor Constructor para crear uns Instancia del Símbolo del Texto, guarda de donde comienza o donde terminar.
 * @param type [kotlin.Int] = [TokenType.IdentifierToken]: Para obtener el tipo asociado del Símbolo.
 * @param start [kotlin.Int]: Para obtener la posición inial de donde comienza el dato/texto.
 * @param end [kotlin.Int]: Para obtener la posición final de donde termina el dato/texto.
 * @author DeavidIG, DeanielIG
 */
data class TextToken(override val type: Int = TokenType.IdentifierToken, val start: Int, val end: Int) : Token
