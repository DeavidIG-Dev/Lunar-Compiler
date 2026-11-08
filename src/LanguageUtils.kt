import java.io.FileWriter
import java.io.IOException

val keywords = """
	module package
	import from of
	public private protected external internal inner exner
	final abstract open close sealed companion friend annotation class data record structure enumerate attribute delegate interface trait object value extend extends implement implements permit permits companions friends where with withs
	local global override suffix prefix operator control infix function native constructor inline
	readonly writeonly type let set get constant as
	this self super base return new
	goto end then
""".trimIndent()

val keywords2 = """
	if else in is
	do while break continue
	by
""".trimIndent()

object LanguageUtils {
	enum class FunctionClass {
		ArrayKeyword,
		CountKeyword,
		LengthClassifiedKeyword,
	}

	fun setArrayKeyword(text: String): List<String> {
		return text
			.split(Regex("\\s+"))
			.sortedBy { it.length }
			.map { "$it = ${it.length}" }
	}

	fun setCountKeyword(text: String, count: Int): List<String> {
		var counts = count;
		return text
			.split(Regex("\\s+"))
			.map { word ->
				"\n\t/**\n" +
						"\t * # [${word.replaceFirstChar { it.uppercase() }}CharArray]\n" +
						"\t *\n" +
						"\t * <Missing Implementation>\n" +
						"\t *\n" +
						"\t * @author DeavidIG, DeanielIG\n" +
						"\t * @since 1.5\n" +
						"\t * @return [Int] = ${counts}\n" +
						"\t */\n" +
						"\tconst val ${word.replaceFirstChar { it.uppercase() }}KeywordToken: Int = ${counts++}"
			}
	}

	fun setLengthKeyword(text: String): List<String> {
		return text
			.split(Regex("\\s+"))
			.map { word ->
				Pair(word.length, word)
			}
			.sortedWith { a, b ->
				if (a.first > b.first) 1
				else if (a.first < b.first) -1
				else 0
			}
			.map { pair ->
				"${pair.second} = ${pair.first}"
			}
	}

	fun createCharArrayInStringTemplate(text: String, count: Int = 100, type: FunctionClass) {
		val arrays =
			when (type) {
				FunctionClass.CountKeyword -> setCountKeyword(text = text, count = count)
				FunctionClass.ArrayKeyword -> setArrayKeyword(text = text)
				FunctionClass.LengthClassifiedKeyword -> setLengthKeyword(text = text)
			}

		try {
			val myWriter = FileWriter("template-file.txt")
			myWriter.write(arrays.joinToString(separator = "\n"))
			myWriter.close()
			println("Successfully wrote to the file.")
		} catch (e: IOException) {
			println("An error occurred.")
			e.printStackTrace()
		}
	}
}