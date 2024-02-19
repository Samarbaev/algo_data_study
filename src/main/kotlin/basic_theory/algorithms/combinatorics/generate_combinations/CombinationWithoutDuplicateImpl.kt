package basic_theory.algorithms.combinatorics.generate_combinations

/**
 * Итеративная реализация генерации всех сочетаний из n по k
 *
 * */
class CombinationWithoutDuplicateImpl : Combination {

    /***
     * 1) Создаем первое сочетание без повторений  i = 0 until k => firstCombination[i] = i + 1
     * 2) Внутри бесконечного цикла делаем следующее:
     * 2.1) Вызываем функцию val cur = nextCombine(firstCombination, n, k)
     * 2.2) Если cur == null => выходим из цикла, все сочетания сгенерированы
     * 2.3) Если cur != null => добавляем сгенерированное сочетание в ответ ans.add(cur.toMutableList())
     */
    override fun generateCombine(n: Int, k: Int): List<List<Int>> {
        val ans: MutableList<MutableList<Int>> = mutableListOf()
        val firstCombination = MutableList(size = k) { 0 }
        for (i in 0 until k) {
            firstCombination[i] = i + 1
        }
        val first = firstCombination.toList()
        ans.add(first.toMutableList())

        while (true) {
            val cur = nextCombine(firstCombination, n, k)
            if (cur.isNullOrEmpty()) {
                break
            } else {
                ans.add(cur.toMutableList())
            }
        }

        return ans
    }

    /**
     * 1) Идем в цикле с конца текущего сочетания от k-1 до 0
     * 2) Внутри цикла проверяем условие curCombination[i] < n - k + i + 1,
     *     n - k + i + 1 - это значение, которое представляет верхнюю границу допустимого диапазона для текущей позиции i в сочетании
     * 2.1) Если условие не выполняется, это значит, что текущей элемент больше допустимого, переходим к следующему i-ому элементу
     * 2.2) Если условие выполняется, то увеличиваем текущей элемент в сочетании на 1 - ++curCombination[i]
     * 2.2.1) И далее в цикле от j = i + 1 until k, следующему элементу после текущего i устанавливаем значением предыдущего увеличенного на 1
     *        curCombination[j] = curCombination[j - 1] + 1
     * 2.2.2) возвращает curCombination
     *
     * Пример работы
     * Пусть есть сочетание [1 2 3 4], n = 5, k = 4
     *
     * Итерация №1
     * 1) i = k - 1 = 4 - 1 = 3
     * 2) curCombination[3] < 5 - 4 + 3 + 1 => 4 < 5 => true
     * 3) ++curCombination[3] => [1 2 3 5]
     * 4) j = 4..4 => false
     * 5) return [1 2 3 5]
     *
     * Итерация №2
     * 1) i = k - 1 = 4 - 1 = 3
     * 2) curCombination[3] < 5 - 4 + 3 + 1 => 5 < 5 => false
     * 3) i = 2
     * 4) curCombination[2] < 5 - 4 + 2 + 1 => 3 < 5 => true
     * 5) ++curCombination[2] => [1 2 4 5]
     * 6) j = 3 .. 4
     * 6.1) curCombination[3] = curCombination[3 - 1] + 1 = curCombination[2] + 1 = 4 + 1 = 5
     * 7) return [1 2 4 5]
     *
     * Итерация №3
     * 1) i = k - 1 = 4 - 1 = 3
     * 2) curCombination[3] = 5 - 4 + 3 + 1 => 5 < 5 => false
     * 3) i = 2
     * 4) curCombination[2] = 5 - 4 + 2 + 1 => 4 < 4 => false
     * 5) i = 1
     * 6) curCombination[1] = 5 - 4 + 1 + 1 => 2 < 3 => true
     * 7) ++curCombination[1] => [1 3 4 5]
     * 8) j = 2 .. 4
     * 8.1) j = 2, curCombination[2] = curCombination[2 - 1] + 1 = 4
     * 8.1) j = 3, curCombination[3] = curCombination[3 - 1] + 1 =  5
     * 9) return [1 3 4 5]
     *
     * Итерация №4
     * 1) i = k - 1 = 4 - 1 = 3
     * 2) curCombination[3] = 5 - 4 + 3 + 1 => 5 < 5 => false
     * 3) i = 2, curCombination[2] = 5 - 4 + 2 + 1 => 4 < 4 => false
     * 4) i = 1, curCombination[1] = 5 - 4 + 1 + 1 => 3 < 3 => false
     * 5) i = 0, curCombination[0] = 5 - 4 + 0 + 1 => 1 < 2 => true
     * 6) ++curCombination[0] = [2 3 4 5]
     * 7) j = 1..4
     * 7.1) j = 1 , curCombination[1] = curCombination[1-1] + 1 = 2 + 1 = 3
     * 7.1) j = 2 , curCombination[2] = curCombination[2-1] + 1 = 3 + 1 = 4
     * 7.2) j = 3 , curCombination[3] = curCombination[3-1] + 1 = 4 + 1 = 5
     * 8) return [2 3 4 5]
     *
     * Итерация №5
     * return null
     *
     * */
    override fun nextCombine(curCombination: MutableList<Int>, n: Int, k: Int): List<Int>? {
        for (i in k - 1 downTo  0) {
            if (curCombination[i] < n - k + i + 1) {
                ++curCombination[i]
                for (j in i + 1 until k) {
                    curCombination[j] = curCombination[j - 1] + 1
                }
                return curCombination
            }
        }
        return null
    }
}