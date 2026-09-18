package lunar.tokenization.tokens

/**
 * # [SymbolToken]
 *
 * La clase [SymbolToken] es la encargada de transformar el Texto crudo a datos usable para él [Parser].
 * Solo puede guardar su asociado, no guarda las posiciones porque no lo necesita.
 *
 * @since 1.0
 * @constructor Constructor para crear uns Instancia del Símbolo del Texto, guarda de donde comienza o donde terminar.
 * @param type [kotlin.Int] - Para obtener el tipo asociado del Símbolo.
 * @author DeavidIG, DeanielIG
 */
data class SymbolToken(override val type: Int) : Token
