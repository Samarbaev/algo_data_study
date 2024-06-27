package ya_contest.sprint_3_sorts_and_recursion.notes.sorts.heap_sort.merge_sort


fun mergeSort(array: List<Int>): List<Int> {

    if (array.size <= 1) {
        return array
    }
    val middle = array.size / 2

    val left = array.subList(0, middle)
    val right = array.subList(middle, array.size)

    return merge(mergeSort(left), mergeSort(right))
}

fun merge(leftArray: List<Int>, rightArray: List<Int>): List<Int> {
    var indexLeft = 0; var indexRight = 0
    val resultArray = mutableListOf<Int>()

    while (indexLeft < leftArray.size && indexRight < rightArray.size) {
        if (leftArray[indexLeft] <= rightArray[indexRight]) {
            resultArray.add(leftArray[indexLeft])
            indexLeft++
        } else {
            resultArray.add(rightArray[indexRight])
            indexRight++
        }
    }

    while (indexLeft < leftArray.size) {
        resultArray.add(leftArray[indexLeft])
        indexLeft++
    }

    while (indexRight < rightArray.size) {
        resultArray.add(rightArray[indexRight])
        indexRight++
    }

    return resultArray
}