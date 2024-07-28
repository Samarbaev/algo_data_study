### Базовые структуры данных

#### 1. Массивы постоянного размера

Массив - это базовая структура данных, которая умеет хранить однотипный набор значений.
Массив всегда занимает один непрерывный участок в памяти, поэтому массив имеет фиксированный размер.
Индексация массива в большинстве языках программирования начинается с 0.

Операции с массивом:

1) Получить значение элемента по индекс(Асимптотическое время операции - О(1));
2) Перезаписать значение по индексу(Асимптотическое время операции - О(1));

Рассмотри пример, как массив хранит данные:
Пусть у нас есть массив numbers из 10 беззнаковых целых чисел. Адрес нулевого элемента нам известен — это 1000.
Чтобы узнать положение следующего элемента, нам нужно прибавить к адресу начала размер элемента в байтах.
Каждое число занимает по 4 байта, так что первый (нулевой) элемент займёт байты 1000, 1001, 1002, 1003.
Значит, элемент с индексом 1 будет записан по адресу 1004.

| 20 + 2 * 256 = 532 | 192 |Значение итоговых чисел |
|-----|-----|-----|-----|-----|-----|-----|-----|--------------------------|
| 20 | 2 | 0 | 0 | 192 | 0 | 0 | 0 |Значение отдельных байтов |
| 1000|1001 |1002 |1003 | 1004| 1005| 1006|1007 |Адреса |

```
    // пример создания массива на kotlin
    // создали массив int-ов на 10 элементов и заполнили его ну нулями 
    val array = IntArray(size = 10) { 0 }

    // пример создания массива на c++ и использование библиотеку stl
    std::array<int, 10> numbers
```

#### 2. Динамический массив

##### 2.1 Вставка и удаление

Часто возникает ситуация, когда мы не знает размер массива заранее и в этом случае мы будем использовать динамический
массив.
Динамический массив - это массив, который умеет изменять свой размер, при этом сохраняет данные, которые в него уже были
записаны.

Операции с динамическим массивом:

1) Получить значение элемента по индекс(Асимптотическое время операции - О(1));
2) Перезаписать значение по индексу(Асимптотическое время операции - О(1));
3) Вставить новый элемент(Асимптотическое время операции зависит от места, куда нужно вставить элемент: в начало, в
   середину или в конец)
4) Удалить существующий элемент(Асимптотическое время операции зависит от места, откуда нужно удалить элемент: в начало,
   в середину или в конец)

Рассмотрим каждую из ситуаций подробнее:

1) Вставка в конец
   чтобы это сделать достаточно узнать номер последней ячейки массива и записать элемент в следующую за ней.

```
    // вставка в конец динамического массива - kotlin
    var filmsWishList = mutableListOf("Джон Уик 3", "Аватар 2", "Форсаж 9", "Индиана Джонс 5", "Бэтмен")
    filmsWishList.add("Чёрная Вдова")
    
    // вставка в конец динамического массива - c++
    #include <iostream>
    #include <vector>
    using namespace std;

    int main() {
         vector<string> films_wish_list = {"Джон Уик 3", "Аватар 2", "Форсаж 9", "Индиана Джонс 5", "Бэтмен"};
         films_wish_list.push_back("Чёрная Вдова");

         vector<string> list_of_tasks = {"Полить цветы", "Приготовить завтрак", "Пойти на работу", "Сходить в магазин", "Позвонить бабушке"};
    
         return 0;
    } 
```

2) Вставка в начало
   Чтобы это сделать необходимо подвинуть все элементы на n+1, чтобы освободить место и тогда мы уже сможем вставить
   элемент в начало

```
   // вставка в начало динамического массива - kotlin
   var filmsWishList = mutableListOf("Джон Уик 3", "Аватар 2", "Форсаж 9", "Индиана Джонс 5", "Бэтмен")
   filmsWishList.add(0, "Чёрная Вдова")
   
   // вставка в начало динамического массива - с++ 
   #include <vector>

   int main() {
       std::vector<int> v{ 1, 2, 3, 4, 5 };
       v.insert(v.begin(), 6);
   }
```

3) Вставка в середину:
   Для того чтобы вставить элемент в середину, так же как и в начало необходимо подвинуть элементы

Сложность удаления из динамического массива
При удалении, как и при вставке в массив, требуется сдвинуть все элементы правее ячейки, в которой происходит операция.
При добавлении в массив элементы сдвигаются на один вправо. А при удалении — на один влево.

##### 2.2 Реаллокация памяти в динамическом массиве

Как быть, размер массива закончил?
Обычно в этом случае создается массив размером в 2 раза больше и данные из старого массива копируются в новый

| Вставка в начало в худшем случае   | Вставка в середину в худшем случае  | Вставка в конец в худшем случае    |
|------------------------------------|-------------------------------------|------------------------------------|
| 0(n)                               | 0(n)                                | 0(n)                               |
| Вставка в начало в среднем случае  | Вставка в середину в среднем случае | Вставка в конец в среднем случае   |
| 0(n)                               | 0(n)                                | 0(1)                               |

#### 3. Связанные списки

Что делать, если нам нужно эффективно вставлять в начало и в конец? В этом случае нам подойдет связанный список.

Связанный список - это список, который хранит узел, который содержит значение этого узла и ссылку на следующий элемент.
Начало списка - голова(head), конец списка - хвост(tail)

Типы связанных списков:

1) Однонаправленный - каждая нода содержит ссылку только на следующий элемент
2) Двунаправленный - каждая нода содержит ссылку на следующий и предыдущий элемент
3) Кольцевой - хвост указывает на голову

```
   // создание связанного списка на kotlin
   class Node(var value: Any? = null, var next: Node? = null)

   fun printLinkedList(vertex: Node?) {
      var current = vertex
      
      while (current != null) {
         print("${current.value} -> ")
         current = current.next
      }
   
      println("None")
      }
   }
   
   val n3 = Node(value = 'third')
   val n2 = Node(value = 'second', next = n3)
   val n1 = Node(value = 'first', next = n2)
   printLinkedList(n1)
      
   // Создание связанного списка на c++
   #include <iostream>

   struct Node {
     int value;
       Node* next = nullptr;
   }

   void print_linked_list(Node* vertex) {
     while (vertex) {
           std::cout << vertex->value << " -> ";
           vertex = vertex->next;
      }
     std::cout << "None" << std::endl;
   }

   int main() {
      Node* n3 = new Node("third");
      Node* n2 = new Node("second", n3);
      Node* n1 = new Node("first", n2);
      print_linked_list(n1);
      print_linked_list(n2);

      delete n3;
      delete n2;
      delete n1;
      return 0;
      }
   }

```

Рассмотрим операцию вставки. В связанном списке, также как и в массиве, можно вставлять в разные места: в начало, в
конец и в середину.
Рассмотрим операцию вставки в конкретное место:

```
// вставка в произвольное место на kotlin
fun getNodeByIndex(node: Node?, index: Int): Node? {
    var current = node
    while (index > 0 && current != null) {
        current = current.next
        index--
    }
    return current
}

fun insertNode(head: Node?, index: Int, value: Any): Node? {
    val newNode = Node(value)
    if (index == 0) {
        newNode.next = head
        return newNode
    }
    val previousNode = getNodeByIndex(head, index - 1)
    if (previousNode != null) {
        newNode.next = previousNode.next
        previousNode.next = newNode
    }
    return head
}

val node = Node("first")
node.next = Node("second")
node.next?.next = Node("third")

val index = 2
val value = "new_node"
var head = insertNode(node, index, value)

printLinkedList(head)

//вставка в произвольное место на с++
#include <iostream>

struct Node {
    Node *next;
    int value;
    Node(int value) : next(nullptr), value(value) {}
};

void printLinkedList(Node *node) {
    while (node != nullptr) {
        std::cout << node->value << " -> ";
        node = node->next;
    }
    std::cout << "None" << std::endl;
}

Node *getNodeByIndex(Node *node, int index) {
    while (index > 0) {
        node = node->next;
        index--;
    }
    return node;
}

Node *insertNode(Node *head, int index, int value) {
    Node *newNode = new Node(value);
    if (index == 0) {
        newNode->next = head;
        return newNode;
    }
    Node *previousNode = getNodeByIndex(head, index-1);
    newNode->next = previousNode->next;
    previousNode->next = newNode;
    return head;
}

int main() {
    Node *n3 = new Node(3);
    Node *n2 = new Node(2);
    Node *n1 = new Node(1);
    n1->next = n2;
    n2->next = n3;
    Node *node = n1;
    int index = 2;
    int value = 4;
    Node *head = insertNode(node, index, value);
    printLinkedList(head);
    return 0;
} 
```

| Вставка в начало в худшем случае  | Вставка в середину в худшем случае  | Вставка в конец в худшем случае  |
|-----------------------------------|-------------------------------------|----------------------------------|
| 0(1)                              | 0(n)                                | 0(1)                             |
| Вставка в начало в среднем случае | Вставка в середину в среднем случае | Вставка в конец в среднем случае |
| 0(1)                              | 0(n)                                | 0(1)                             |

#### 4. Стек

Стек - это структура данных, которая работает по принципе LIFO(последним вошел - первым вышел)

Стек, обладает следующим интерфейсом:

1) push(item) - добавить элемент на вершину стека;
2) pop() - возвращает элемент с вершины стека и удаляет его;
3) peek() или top() - получить значение на вершине стека;
   Также нередко для удобства использования стека есть и дополнительные методы:
4) isEmpty() - определяет пустой ли стек

```
    // реализация стека на kotlin
   class Stack {
    private var items = mutableListOf<Any>()
    fun push(item: Any) {
        items.add(item)
    }
    fun pop(): Any? {
        return if (items.isNotEmpty()) items.removeAt(items.size - 1) else null
    }
    fun peek(): Any? {
        return if (items.isNotEmpty()) items.last() else null
    }
    fun size(): Int {
        return items.size
    }
}

    fun main(args: Array<String>) {
       val stack = Stack()
       stack.push("apple")
       stack.push("banana")
       stack.push("orange")
       stack.pop()
}

    // реализация стека на с++
   #include <iostream>
   #include <vector>
   #include <string>

    class Stack {
     private:
       std::vector<std::string> items;
    
     public:
       void push(std::string item) { items.push_back(item); }

       std::string pop() {
        std::string lastItem = items.back();
        items.pop_back();
        return lastItem;
       }

       std::string peek() { return items.back(); }

       int size() { return items.size(); }
};

int main() {
   Stack stack;
   stack.push("apple");
   stack.push("banana");
   stack.push("orange");
   stack.pop();

   return 0;
}

```

#### 5. Очередь и дек

#### 6. Стек вызовов и переполнение стека вызов
