package ya_contest.sprint_5_binary_trees.notes.avl

data class AvlNode(var value: Int) {
    var height: Int = 0
    var left: AvlNode? = null
    var right: AvlNode? = null
}