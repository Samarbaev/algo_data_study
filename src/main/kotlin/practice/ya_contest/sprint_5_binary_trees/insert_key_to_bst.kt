package practice.ya_contest.sprint_5_binary_trees

/***
 * Условие:
 * Дано BST. Надо вставить узел с заданным ключом. Ключи в дереве могут повторяться.
 * На вход функции подаётся корень корректного бинарного дерева поиска и ключ, который надо вставить в дерево.
 * Осуществите вставку этого ключа. Если ключ уже есть в дереве, то его дубликаты уходят в правого сына.
 * Таким образом вид дерева после вставки определяется однозначно. Функция должна вернуть корень дерева после вставки вершины.
 * Ваше решение должно работать за O(h), где h – высота дерева.
 *
 * Формат ввода:
 * Ключи дерева – натуральные числа, не превосходящие 10^9. Число вершин в дереве не превосходит 10^5.
 *
 */

fun insert(root: TreeNode?, key: Int): TreeNode {

    if (root == null) return TreeNode(null, null, key)

    if (key < root.value) {
        root.left = insert(root.left, key)
    } else if (key >= root.value) {
        root.right = insert(root.right, key)
    }
    return root
}