package lunar.tokenization.chararrays

import lunar.utils.Spannable

/**
 * # [get]
 *
 * <Missing Documentation implementation>
 *
 * @author DeavidIG, DeanielIG
 * @since 1.2
 */
operator fun Spannable.get(
	range: IntRange
): String = String(this.text, range.first, range.last - range.first)