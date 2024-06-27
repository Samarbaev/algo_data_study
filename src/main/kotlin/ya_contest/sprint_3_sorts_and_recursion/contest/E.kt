package ya_contest.sprint_3_sorts_and_recursion.contest


/***
 * Условие:
 * Тимофей решил купить несколько домов на знаменитом среди разработчиков Алгосском архипелаге.
 * Он нашёл n объявлений о продаже, где указана стоимость каждого дома в алгосских франках.
 * А у Тимофея есть k франков. Помогите ему определить, какое наибольшее количество домов на Алгосах он сможет приобрести за эти деньги.
 *
 * Формат ввода:
 * В первой строке через пробел записаны натуральные числа n и k.
 * n — количество домов, которые рассматривает Тимофей, оно не превосходит 100000;
 * k — общий бюджет, не превосходит 100000;
 * В следующей строке через пробел записано n стоимостей домов. Каждое из чисел не превосходит 100000. Все стоимости — натуральные числа.
 *
 * Формат вывода:
 * Выведите одно число —– наибольшее количество домов, которое может купить Тимофей.
 *
 * Testcase
 * Ввод
 * 3 300
 * 999 999 999
 * Вывод
 * 0
 */

fun main() {
    val countHouses = readln().split(" ").map { it.toInt() }
    val prices = readln().split(" ").map { it.toInt() }
    println(buyMaxHouse(countHouses[1], prices))
}

fun buyMaxHouse(money: Int, pricesHouse: List<Int>): Int {
    val sortedPrices = pricesHouse.sorted()
    var mutableMoney = money
    var countBoughtHouse = 0

    for(price in sortedPrices) {
        if(price <= mutableMoney) {
            mutableMoney -= price
            ++countBoughtHouse
        }
    }
    return countBoughtHouse
}