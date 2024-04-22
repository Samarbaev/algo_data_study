package theory.data_structures.trees.bst.avl

data class AvlNode(var value: Int) {
    var height: Int = 0
    var left: AvlNode? = null
    var right: AvlNode? = null
}