package practice.ya_contest.sprint_3_sorts_and_recursion

/**
 * Условие:
 * К Васе в гости пришли одноклассники. Его мама решила угостить ребят печеньем.
 * Но не всё так просто. Печенья могут быть разного размера. А у каждого ребёнка есть фактор жадности —– минимальный размер печенья, которое он возьмёт. Нужно выяснить, сколько ребят останутся довольными в лучшем случае, когда они действуют оптимально.
 * Каждый ребёнок может взять не больше одного печенья.
 *
 * Формат ввода:
 * В первой строке записано n —– количество детей.
 * Во второй —– n чисел, разделённых пробелом, каждое из которых –— фактор жадности ребёнка. Это натуральные числа, не превосходящие 1000.
 * В следующей строке записано число m –— количество печенек.
 * Далее —– m натуральных чисел, разделённых пробелом —– размеры печенек. Размеры печенек не превосходят 1000.
 * Оба числа n и m не превосходят 10000.
 *
 * Формат вывода:
 * Нужно вывести одно число –— количество детей, которые останутся довольными
 *
 * Testcase:
 * Ввод
 * 2
 * 1 2
 * 3
 * 2 1 3
 * Вывод
 * 2
 *
 * */

fun main() {
    val sizeChildren = readLine()!!.toInt()
    val children = readLine()!!.split(" ").map { it.toInt() }.sortedDescending()
    val sizeCookie = readLine()!!.toInt()
    val cookies = readLine()!!.split(" ").map { it.toInt() }.sortedDescending()


    counterHappyChildren(cookies, children)
}

fun counterHappyChildren(cookies: List<Int>, children: List<Int>) {
    if (cookies == children) {
        return println(children.size)
    }
    var counterHappyChildren = 0
    var currentChild = children.size - 1
    var currentCookie = cookies.size - 1

    while (currentChild >= 0 && currentCookie >= 0) {
        if (children[currentChild] <= cookies[currentCookie]) {
            counterHappyChildren++
            currentChild--
        }
        currentCookie--

    }
    println(counterHappyChildren)
}