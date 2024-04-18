package theory.data_structures.trees.bst.avl

data class AvlNode(
    var height: Int,
    var left: AvlNode?,
    var right: AvlNode?,
    val value: Int
)