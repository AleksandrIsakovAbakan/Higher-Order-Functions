fun main() {

    val a = "красный"
    val b = "синий"
    println("Функция action возвращает результат в виде строки смешанный цвет из двух заданных: ${action(a, b, ::function)}")
    println()

    val array = intArrayOf(5, 5, 6, 677, 8, 900, 0, 100, 120, -2)
    println("Исходный массив: " + array.contentToString())
    println("Увеличение числа на единицу: " + functionArray(array, ::increasingNumberByOne).contentToString())
    println("Умножение на два: " + functionArray(array, ::multiplyingByTwo).contentToString())

}

/*
Написать функцию высшего порядка action, которая на вход принимает значения двух цветов типа String.
Они будут смешиваться в функции, которая на вход поступает в качестве третьего аргумента в action,
она же возвращает строку – получившейся цвет.
Функция action возвращает результат в виде строки смешанный цвет из двух заданных.
*/
fun action(a: String, b: String, function: (String, String) -> String): String {
    return function(a, b)
}

fun function(a: String, b: String): String {
    if (a == b) return a
    return when(a){
        "красный" -> return funRed(b)
        "оранжевый" -> return funOrange(b)
        "желтый" -> return funYellow(b)
        "зеленый" -> return funGreen(b)
        "синий" -> return funBlue(b)
        "фиолетовый" -> return funViolet(b)
        else -> "Цвет не определен"
    }
}

fun funRed(b: String): String {
    return when(b){
        "оранжевый" -> "красно-оранжевый"
        "желтый" -> "оранжевый"
        "зеленый" -> "желтый"
        "синий" -> "фиолетовый"
        "фиолетовый" -> "пурпурный"
        else -> "Цвет не определен"
    }
}

fun funOrange(b: String): String {
    return when(b){
        "красный" -> "красно-оранжевый"
        "желтый" -> "желто-оранжевый"
        "зеленый" -> "горчичный"
        "синий" -> "красновато-коричневый"
        "фиолетовый" -> "коричневый"
        else -> "Цвет не определен"
    }
}

fun funYellow(b: String): String {
    return when(b){
        "красный" -> "оранжевый"
        "оранжевый" -> "желто-оранжевый"
        "зеленый" -> "оливковый"
        "синий" -> "зеленый"
        "фиолетовый" -> "нейтральный серый"
        else -> "Цвет не определен"
    }
}

fun funGreen(b: String): String {
    return when(b){
        "красный" -> "желтый"
        "оранжевый" -> "горчичный"
        "желтый" -> "оливковый"
        "синий" -> "сине-зеленый"
        "фиолетовый" -> "мурена"
        else -> "Цвет не определен"
    }
}

fun funBlue(b: String): String {
    return when(b){
        "красный" -> "фиолетовый"
        "оранжевый" -> "красновато-коричневый"
        "желтый" -> "зеленый"
        "зеленый" -> "сине-зеленый"
        "фиолетовый" -> "сине-фиолетовый"
        else -> "Цвет не определен"
    }
}

fun funViolet(b: String): String {
    return when(b){
        "красный" -> "пурпурный"
        "оранжевый" -> "коричневый"
        "желтый" -> "нейтральный серый"
        "зеленый" -> "мурена"
        "синий" -> "сине-фиолетовый"
        else -> "Цвет не определен"
    }
}

/*
Написать функции изменения числа: одна – увеличение числа на единицу, вторая – умножение на два.
Написать функцию высшего порядка, которая на вход принимает массив целых чисел и вторым параметром функцию,
принимающую число и возвращающая число.
Функция высшего порядка будет возвращать измененный массив, который будет получаться за счет вызова внутри нее
у этого массива функции map, внутри которой будет вызываться функция изменения числа.
*/
fun increasingNumberByOne(c: Int): Int = c + 1

fun multiplyingByTwo(c: Int): Int = c * 2

fun functionArray(array: IntArray, function: (Int) -> Int): IntArray{
    return array.map { function(it) }
        .toIntArray()
}