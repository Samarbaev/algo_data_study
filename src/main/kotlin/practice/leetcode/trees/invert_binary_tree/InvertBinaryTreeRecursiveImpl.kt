package practice.leetcode.trees.invert_binary_tree

import practice.leetcode.trees.TreeNode

// Algorithm:
// Обратное дерево для пустого дерева также является пустым деревом.
// Обратное дерево для дерева с корнем r, и поддеревьями right и left - это дерево с корнем r, у которого правое поддерево является обратным для left, а левое поддерево - обратным для right.

// Time complexity and space complexity:
// Поскольку каждый узел в дереве посещается только один раз, временная сложность составляет O(n), где n - количество узлов в дереве.
// Мы не можем достичь лучшего результата, так как минимум нужно посетить каждый узел, чтобы инвертировать его.
// Из-за рекурсии в худшем случае на стеке будет занято O(h) вызовов функций, где h - высота дерева.
// Поскольку h ∈ O(n), пространственная сложность составляет O(n).

class InvertBinaryTreeRecursiveImpl : InvertBinaryTree {
    override fun invertTree(root: TreeNode?): TreeNode? {
        if (root == null) return null

        val leftNode = root.right
        root.right = root.left
        root.left = leftNode
        invertTree(root.left)
        invertTree(root.right)
        return root
    }
}