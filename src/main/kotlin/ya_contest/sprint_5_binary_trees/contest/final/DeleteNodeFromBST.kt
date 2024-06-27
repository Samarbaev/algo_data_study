package ya_contest.sprint_5_binary_trees.contest.final

import practice.ya_contest.sprint_5_binary_trees.contest.TreeNode

class DeleteNodeFromBST {

    fun remove(root: TreeNode?, key: Int): TreeNode? {
        if (root == null) return null

        when {
            key < root.value -> root.left = remove(root.left, key)
            key > root.value -> root.right = remove(root.right, key)
            else -> {
                // Node with two children
                if (root.left != null && root.right != null) {
                    val minNode = minimum(root.right!!)
                    root.value = minNode.value
                    root.right = remove(root.right, minNode.value)
                } else {
                    // Node with one or no child
                    return if (root.left == null) {
                        root.right
                    } else if (root.right == null) {
                        root.left
                    } else {
                        // This case should never be reached
                        throw IllegalStateException("Unexpected state")
                    }
                }
            }
        }
        return root
    }

    fun minimum(treeNode: TreeNode): TreeNode {
        var current = treeNode
        while (current.left != null) {
            current = current.left!!
        }
        return current
    }


}