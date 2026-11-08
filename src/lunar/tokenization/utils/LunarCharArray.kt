package lunar.tokenization.utils

import lunar.utils.Spannable

/**
 * # [state]
 *
 * <Missing Implementation>
 *
 * @author DeavidIG, DeanielIG
 * @since 1.2
 */
fun Spannable.state(start: Int, input: CharArray): Boolean {
	if (start < 0 || start > size - input.size) return false

	for ((position, element) in input.withIndex()) {
		if (this[position + start] != element) return false
	}
	return true
}