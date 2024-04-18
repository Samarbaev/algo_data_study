package theory.data_structures.trees.bst

interface IBinarySearchTree<T: Comparable<T>> {

    fun find(item: T): T?

    fun add(item: T)

    fun remove(item: T)
}