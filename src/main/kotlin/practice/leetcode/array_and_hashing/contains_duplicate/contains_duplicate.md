### Condition
Given an integer array nums, return true if any value appears at least twice in the array, and return false if every element is distinct.

### Test cases

| Input                 | Output |
|-----------------------|--------|
| [1,2,3,1]             | true   |
| [1,2,3,4]             | false  |
| [1,1,1,3,3,4,3,2,4,2] | true   |

### Solution 1
Создаем mutableMapOf<Int, Int> и добавляем в нее значения из nums. 
Перед добавлением делаем проверку, если ключ существует - возвращаем true