package practice.ya_contest.sprint_5_binary_trees

import java.io.BufferedWriter
import java.io.IOException
import java.io.OutputStreamWriter

/**
 * Условие:
 * Напишите функцию, которая будет выводить по неубыванию все ключи от L до R включительно в заданном бинарном дереве поиска.
 * Ключи в дереве могут повторяться. Решение должно иметь сложность O (h + k), где h –— глубина дерева, k — число элементов в ответе.
 * В данной задаче если в узле содержится ключ x, то другие ключи, равные x, могут быть как в правом, так и в левом поддереве данного узла. (Дерево строил стажёр, так что ничего страшного).
 *
 * Формат ввода:
 * На вход функции подаётся корень дерева и искомый ключ. Число вершин в дереве не превосходит 10^5.
 * Ключи – натуральные числа, не превосходящие 10^9. Гарантируется, что L ≤ R.
 * В итоговом решении не надо определять свою структуру / свой класс, описывающий вершину дерева.
 *
 * Формат вывода:
 * Функция должна напечатать по неубыванию все ключи от L до R по одному в строке.
 * */

@Throws(IOException::class)
fun printRange(root: TreeNode?, L: Int, R: Int, writer: BufferedWriter) {
    if (root == null) return

    if (L <= root.value) {
        printRange(root.left, L, R, writer)
    }

    if (root.value in L..R) {
        writer.write(root.value.toString())
        writer.newLine()
    }

    if (R >= root.value) {
        printRange(root.right, L, R, writer)
    }
}
