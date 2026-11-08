package lunar.tokenization.tokens

val TextToken.length: Int get(): Int = this.end - this.start

val SymbolToken.length: Int get(): Int = this.end - this.start

val NumericToken.length: Int get(): Int = this.end - this.start