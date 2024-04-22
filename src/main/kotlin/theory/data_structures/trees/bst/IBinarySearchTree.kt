package theory.data_structures.trees.bst

import theory.data_structures.trees.bst.avl.AvlNode

interface IBinarySearchTree<T: Comparable<T>> {

    fun find(key: T): AvlNode?

    fun add(root: AvlNode?, key: T): AvlNode?

    fun remove(root: AvlNode?, key: T):  AvlNode?
}