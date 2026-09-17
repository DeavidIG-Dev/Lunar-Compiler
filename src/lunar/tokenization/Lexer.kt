package lunar.tokenization

import lunar.tokenization.tokens.NamedToken
import lunar.tokenization.tokens.PreToken
import lunar.tokenization.tokens.Token
import lunar.tokenization.tokens.SymbolToken

/**
 * # [Lexer]
 *
 * La clase [Lexer] (Próximamente "LunarLexer"), es la encargada de poder procesar datos cruda a datos usable.
 *
 * La clase está marcada como `abstract` para dar comiendo a la documentacion y explicacion de la propia clase y sus metodos.
 *
 * @since 1.0
 *
 * @author DeavidIG, DeanielIG
 */
abstract class Lexer {
	/**
	 * # [token]
	 *
	 * La variable [token] es para obtener el token que fue procesado por el propio [Lexer].
	 * Además, solo se puede obtener desde afuera o internamente de la clase [Lexer], cualquiera que quiera cambiar su estado queda
	 * estrictamente bloqueado por seguridad.
	 *
	 * Ejemplo de su uso.
	 * ```Kotlin
	 * val IdentifierToken: NammedToken = lexerInstance.token as NammedToken;
	 * ```
	 *
	 * No solo está estrictamente para obtener datos, sino, para el formato **crudo**, ejemplo.
	 * ```Kotlin
	 * if ((lexerInstance.token is? NammedToken).type == TokenType.IdentifierToken ?: false) {
	 * 	println("¡Es un identificador!")
	 * }
	 * ```
	 *
	 * Lo que si no se pueda hacer, es tartar de cambiar su estado desde afuera. Ya que su estado `set` (o `setter`) está marcado como `private`.
	 * Por lo cual, lo siguiente no se puede "validar".
	 * ```Kotlin
	 * // Usando la clase NammedToken.
	 * lexerInstance.token = NammedToken(/* type= */ TokenType.IdentifierToken, /* start= */ 0, /* end= */ 5);
	 *
	 * // Usando la clase UnnammedToken.
	 * lexerInstance.token = UnnammedToken(/* type= */ TokenType.SemicoloDelimiterToken);
	 * ```
	 *
	 * @return [Token]
	 * @since 1.0
	 * @author DeavidIG, DeanielIG
	 */
	/* abstract */ var token: Token = PreToken.StartOfFileToken // -> = UnnamedToken(-1)
		private set

	/**
	 * # [getSymbolToken]
	 *
	 * <Missing Documentation implementation>
	 *
	 * @return [SymbolToken]
	 * @since 1.0
	 * @author DeavidIG, DeanielIG
	 */
	/* private */ abstract fun getSymbolToken(): SymbolToken // -> Token

	/**
	 * # [getIdentifierToken]
	 *
	 * <Missing Documentation implementation>
	 *
	 * @return [NamedToken]
	 * @since 1.0
	 * @author DeavidIG, DeanielIG
	 */
	/* private */ abstract fun getIdentifierToken(): NamedToken // -> Token

	/**
	 * # [getNumericsToken]
	 *
	 * <Missing Documentation implementation>
	 *
	 * @return [NamedToken]
	 * @since 1.0
	 * @author DeavidIG, DeanielIG
	 */
	/* private */ abstract fun getNumericsToken(): NamedToken // -> Token

	/**
	 * # [setNextToken]
	 *
	 * <Missing Documentation implementation>
	 *
	 * @return [Unit]
	 * @since 1.0
	 * @author DeavidIG, DeanielIG
	 */
	abstract fun setNextToken()
}