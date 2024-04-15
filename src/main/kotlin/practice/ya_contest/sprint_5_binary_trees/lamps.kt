package practice.ya_contest.sprint_5_binary_trees

/***
 * Условие:
 * Гоша повесил на стену гирлянду в виде бинарного дерева, в узлах которого находятся лампочки.
 * У каждой лампочки есть своя яркость. Уровень яркости лампочки соответствует числу, расположенному в узле дерева.
 * Помогите Гоше найти самую яркую лампочку в гирлянде, то есть такую, у которой яркость наибольшая.
 *
 * Формат ввода:
 * На вход подается корень бинарного дерева
 *
 * Формат вывода:
 * Функция должна вернуть максимальное значение яркости в узле дерева.
 *
 */

private fun treeSolution(head: TreeNode?): Int {
    if (head == null) return 0

    val leftMax = treeSolution(head.left)
    val rightMax = treeSolution(head.right)

    return maxOf(head.value, leftMax, rightMax)
}
