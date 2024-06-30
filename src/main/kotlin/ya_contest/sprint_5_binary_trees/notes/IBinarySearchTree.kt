package ya_contest.sprint_5_binary_trees.notes

import ya_contest.sprint_5_binary_trees.notes.avl.AvlNode

interface IBinarySearchTree<T: Comparable<T>> {

    fun find(key: T): AvlNode?

    fun add(root: AvlNode?, key: T): AvlNode?

    fun remove(root: AvlNode?, key: T):  AvlNode?
}