package leetcode.trees.invert_binary_tree

import leetcode.trees.TreeNode
import java.util.LinkedList
import java.util.Queue

// Algorithm:
// Идея заключается в том, что нам нужно поменять местами левый и правый потомок всех узлов в дереве.
// Для этого мы создаем очередь, чтобы хранить узлы, у которых еще не были поменяны местами левый и правый потомок.
// Изначально в очереди находится только корень.
// Пока очередь не пуста, мы извлекаем следующий узел из очереди, меняем его потомки местами и добавляем потомков в очередь.
// Пустые узлы не добавляются в очередь.
// В конечном итоге очередь станет пустой, все потомки поменяются местами, и мы возвращаем исходный корень.
//
// Time complexity and Space complexity
// Поскольку каждый узел в дереве посещается / добавляется в очередь только один раз, время выполнения составляет O(n), где n - количество узлов в дереве.
// Пространственная сложность составляет O(n), так как в худшем случае очередь будет содержать все узлы на одном уровне двоичного дерева.
// Для полного бинарного дерева на уровне листьев находится ⌈n/2⌉=O(n) листьев.


class InvertBinaryTreeIterativeImpl : InvertBinaryTree {
    override fun invertTree(root: TreeNode?): TreeNode? {
        if (root == null) return null
        val queue: Queue<TreeNode?> = LinkedList()
        queue.add(root)
        while (queue.isNotEmpty()) {
            val currentParent = queue.poll()
            val tmp = currentParent?.left
            currentParent?.left = currentParent?.right
            currentParent?.right = tmp
            if (currentParent?.left != null) queue.add(currentParent.left);
            if (currentParent?.right != null) queue.add(currentParent.right);
        }
        return root
    }
}