package practice.ya_contest.sprint_5_binary_trees

/***
 *
 * Условие:
 * Гоша понял, что такое дерево поиска, и захотел написать функцию, которая определяет, является ли заданное дерево деревом поиска.
 * Значения в левом поддереве должны быть строго меньше, в правом —- строго больше значения в узле.
 * Помогите Гоше с реализацией этого алгоритма.
 *
 * Формат ввода:
 * На вход функции подается корень бинарного дерева.
 *
 * Формат вывода:
 * Функция должна вернуть True, если дерево является деревом поиска, иначе - False.
 *
 */

fun validateBst(head: TreeNode?): Boolean {
    return isBST(head, null, null)
}

private fun isBST(head: TreeNode?, lowerBound: Int?, upperBound: Int?): Boolean {
    if (head == null) return true

    if ((lowerBound != null && head.value <= lowerBound) || (upperBound != null && head.value >= upperBound)) {
        return false;
    }

    return (isBST(head.left, lowerBound, head.value) && isBST(head.right, head.value, upperBound))
}

