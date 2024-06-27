package ya_contest.sprint_5_binary_trees.notes.avl

import practice.ya_contest.sprint_5_binary_trees.notes.IBinarySearchTree

class AvlTree(
    private var root: AvlNode? = null
) : IBinarySearchTree<Int> {

    companion object {
        private const val HEIGHT_TREE_IS_EMPTY = -1
        private const val DEFAULT_VALUE_HEIGHT_FOR_CURRENT_NODE = 1

        private const val BALANCE_FACTOR_IS_NIL = 0
        private const val MAX_ALLOWED_BALANCE_FACTOR = 1
        private const val MIN_ALLOWED_BALANCE_FACTOR = -1
    }

    override fun find(key: Int): AvlNode? {
        if (root == null) return null
        var current = root

        while (current != null) {
            if (current.value == key) {
                break
            }
            current = if (key < current.value) current.left else current.right
        }
        return current
    }

    override fun add(root: AvlNode?, key: Int): AvlNode? {
        var currentNode = root
        if (currentNode == null) currentNode = AvlNode(key)
        if (key < currentNode.value) {
            currentNode.left = add(currentNode, key)
        } else if (key > currentNode.value) {
            currentNode.right = add(currentNode, key)
        } else {
            throw Exception("duplicate key!");
        }
        return rebalance(currentNode)
    }

    override fun remove(root: AvlNode?, key: Int): AvlNode? {
        var node = root
        if (node == null) {
            return node
        } else if (node.value > key) {
            node.left = remove(node.left, key)
        } else if (node.value < key) {
            node.right = remove(node.right, key)
        } else {
            if (node.left == null || node.right == null) {
                node = if (node.left == null) node.right else node.left
            } else {
                val mostLeftChild = minNode(node.right)
                mostLeftChild?.value?.let { node?.value = it }
                node.right = remove(node.right, node.value)
            }
        }
        if (node != null) {
            node = rebalance(node)
        }
        return node
    }

    private fun minNode(node: AvlNode?): AvlNode? {
        var current = node
        while (current != null) {
            current = current.left
        }
        return current
    }

    fun getRoot() = root

    private fun height(node: AvlNode?): Int {
        return node?.height ?: HEIGHT_TREE_IS_EMPTY
    }

    private fun balanceFactor(node: AvlNode?): Int {
        return if (node == null) BALANCE_FACTOR_IS_NIL else (height(node.right) - height(node.right))
    }

    private fun updateHeight(node: AvlNode?) {
        DEFAULT_VALUE_HEIGHT_FOR_CURRENT_NODE + maxOf(height(node?.left), height(node?.right))
    }

    private fun rotateRight(y: AvlNode?): AvlNode? {
        val x: AvlNode? = y?.left
        val z: AvlNode? = x?.right
        x?.right = y
        y?.left = z
        updateHeight(y)
        updateHeight(x)
        return x
    }

    private fun rotateLeft(y: AvlNode?): AvlNode? {
        val x: AvlNode? = y?.right
        val z: AvlNode? = x?.left
        x?.left = y
        y?.right = z
        updateHeight(y)
        updateHeight(x)
        return x
    }

    private fun rebalance(node: AvlNode?): AvlNode? {
        var currentAvlNode: AvlNode? = node
        updateHeight(currentAvlNode)
        val balanceFactor: Int = balanceFactor(currentAvlNode)

        if (balanceFactor > MAX_ALLOWED_BALANCE_FACTOR) {
            if (height(currentAvlNode?.right?.right) > height(currentAvlNode?.right?.left)) {
                currentAvlNode = rotateLeft(currentAvlNode)
            } else {
                currentAvlNode?.right = rotateRight(currentAvlNode?.right)
                currentAvlNode = rotateLeft(currentAvlNode)
            }
        } else if (balanceFactor < MIN_ALLOWED_BALANCE_FACTOR) {
            if (height(currentAvlNode?.left?.left) > height(currentAvlNode?.left?.right)) {
                currentAvlNode = rotateRight(currentAvlNode)
            } else {
                currentAvlNode?.left = rotateLeft(currentAvlNode?.left)
                currentAvlNode = rotateRight(currentAvlNode)
            }
        }
        return currentAvlNode
    }

}