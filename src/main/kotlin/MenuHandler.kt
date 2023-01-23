import java.util.*

class MenuHandler(menuMap: MenuMap) {
    private val menuMap: MutableMap<String, () -> Unit> = menuMap.menuMap
    private val menuName = menuMap.menuName

    fun navigateOnMenu() {
        val input = readInputMenu()
        for ((num, string) in menuMap.keys.withIndex()) {
            if (num == input) {
                menuMap[string]?.invoke()
            }
        }
    }

    fun printMenu() {
        println(menuName)
        for ((n, string) in menuMap.keys.withIndex()) {
            println("$n. $string")
        }
    }

    private fun readInputMenu(): Int {
        var input: String
        while (true) {
            input = Scanner(System.`in`).nextLine()
            if (input.toIntOrNull() == null) {
                println("Не правильный ввод, введено не числовое значение. Попробуйте еще раз.")
                continue
            } else if (input.toInt() in 0 until menuMap.size) {
                break
            } else println("Не правильный ввод, введено число вне диапазона меню. Попробуйте еще раз.")
            continue
        }
        return input.toInt()
    }
}