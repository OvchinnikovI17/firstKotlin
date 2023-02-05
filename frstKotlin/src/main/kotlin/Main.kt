import java.time.Period

fun main(args: Array<String>) {

    // МЕГА БАЗА
    println("Hello World!")

    val CONST: String = "Constanta" // val - константа

    var usualperem: String = "notConst" // var - обычная переменная
    var num1: Int = 1
    var num2: Int = 2

    println("cymma: ${num1 + num2}")
    println("prikolnya ficha $usualperem") // красивый вывод

    // СПИСКИ

    val items = listOf("коробка1", "коробка2", "коробка3") // неизменаяемый список

    // FOR
    for (item in items){
        println(item)
    }

    // WHILE
    var ind: Int = 0;
    while (ind < items.size){
        println(items[ind])
        ind++
    }

    // ДИАПОЗОНЫ
    println(5 in 4..10)
    for (i in 5..10){  // for (i in 5 until 10) - означает до 10 не включая ее, downTo в убывающем порядке for (i in 5..10 step 2) - шаг 2
        println(i)
    }

    // ВЫЗОВЫ ФУНКЦИЙ
    println(TestFunc())
    println(TestFunc2(3, 7))
    println(CallBackList(1, 2, 3))
    TestFunc3()
    TestFunc3(3)
    TestFunc3(5,3)
    Summeriser(2, 3, 4, 5, 6, 7, 7, 8, 9)
    Summeriser(*intArrayOf(1,2,3,4,5,6)) // * - вычленяет компоненты массива
    testWhen(1)
    testWhen(2)
    testWhen(11)
    testWhen("beb")

    // КАК KOTLIN РАБОТАЕТ С NULL

    var assd: String = "HI" // a = null - нельзя
    var b: String?  // нельзя вызывать методы напрямую
    b = null
    b?.length // безопасный вызов
    // Elvis оператор
    val l = b?.length ?: -1 // если null, то положем -1
    // !! - выбрасывает NullPointerException в слеучае если в пременной null
    b = if ((0..10).random() > 5) "okay" else null
    val t = b!!.length

    //ЛЯМБДЫ
    val a = listOf<Int>(1, 2, 3, 4, 5, 6, 7, 8)
    a.forEach { e -> println(e) }
    println(a.map { e -> e * 2 }) // оторбражает эелементы в другие
    println(a.filter { e -> e % 2 == 0 }) // фильтр
    a.reduce { sum, e -> sum + e} // sum()

    //ФУНКЦИИ

    a.any {it > 10}  // true, если есть хотябы 1 элемент удовлетворяющий условию
    a.all {it > 10}  // true, если все удовлетворяют условию
    a.sum() // суммирует все элементы

    val numbers = listOf(1, 3, -4, 2, -11)
    val (positive, negative) = numbers.partition { it > 0 } // разделяет на две коллкции по какому-либо признаку
    println(positive)
    println(negative)

    val result = listOf("a", "b", "ds", "bas").groupBy { it.length }
    println(result)

    val p2 = Person("Boris", "Tompson", 13)
    println(p2.firstName)
    val p1 = Person("Oleg", "Tompson", 33, p2)

    val recta1 = Rectangle(5.0, 3.0)
    println("This perimeter is ${recta1.periemetr}")

    val recta2 = Rectangle(5.0, 3.0)
    println(recta1 == recta2)
}


// ФУНКЦИИ

fun TestFunc(): Int{
    return 1+1
}

fun TestFunc2(x: Int, y: Int): Int{
    return x + y
}

fun CallBackList(a1: Int, a2: Int, a3:Int): List<Int>{
    return listOf(a1, a2, a3)
}

fun TestFunc3(x: Int = 1, y: Int = 2){ // значения по умолчанию
    println(x + y)
}

// VARARG - передаем в функцию любое кол-во переменных

fun Summeriser(vararg numbers: Int){
    numbers.forEach {
        e -> if (e % 2 == 0 ) println("число $e четное")  // вот лямбда кстати
    }
}

fun testWhen(input: Any){  // Any - любой тип данных
    when (input){
        1 -> println("edinica")
        2 -> println("dvoyka")
        in 3..20 -> println("mnogo")
        is String -> println("Na vhod podana stroka")
        else -> println("drygie sluchai")
    }
}

//КЛАСС
class Person(val firstName: String, val lastName: String, var age: Int){ // первичный конуструктор
    var children: MutableList<Person> = mutableListOf() // ArrayList

    init { // первичное(при создании)
        println("Person is created $firstName")
    }

    constructor(firstName: String, lastName: String, age: Int, child: Person): this(firstName, lastName, age){
        children.add(child)
    }

    constructor(): this("", "", -1)

}

data class Rectangle(var height: Double, var length: Double) { // data - автоматически создается equals, toString, hashCode
    var periemetr = (height + length) * 2

    var test = 1
        get() = field + 1 // field = this
        set(value){
            if (value < 0) println("Negative value")
            field = value
        }

    fun area() = height * height
}