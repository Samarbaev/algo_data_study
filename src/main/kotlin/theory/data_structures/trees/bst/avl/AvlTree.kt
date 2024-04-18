package theory.data_structures.trees.bst.avl

import theory.data_structures.trees.bst.IBinarySearchTree

class AvlTree : IBinarySearchTree<Int> {

    override fun find(item: Int): Int? {
        TODO("Not yet implemented")
    }

    override fun add(item: Int) {
        TODO("Not yet implemented")
    }

    override fun remove(item: Int) {
        TODO("Not yet implemented")
    }

    private fun height(node: AvlNode?): Int {
        return node?.height ?: -1
    }

    private fun balanceFactor(node: AvlNode?): Int {
        return if (node == null) 0 else (height(node.right) - height(node.right))
    }

    private fun updateHeight(node: AvlNode?) {
        1 + maxOf(height(node?.left), height(node?.right))
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

    private fun rebalance(z: AvlNode?): AvlNode? {
        var varZ: AvlNode? = z
        updateHeight(varZ)
        val balance: Int = balanceFactor(varZ)
        if (balance > 1) {
            if (height(varZ?.right?.right) > height(varZ?.right?.left)) {
                varZ = rotateLeft(varZ)
            } else {
                varZ?.right = rotateRight(varZ?.right)
                varZ = rotateLeft(varZ)
            }
        } else if (balance < -1) {
            if (height(varZ?.left?.left) > height(varZ?.left?.right)) {
                varZ = rotateRight(varZ)
            } else {
                varZ?.left = rotateLeft(varZ?.left)
                varZ = rotateRight(varZ)
            }
        }
        return varZ
    }

}