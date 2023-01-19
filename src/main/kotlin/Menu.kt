import java.util.*

open class Menu(private val type: MenuType) {

    val contentMap: MutableMap<String, Content> = mutableMapOf()

    private var content = ""
    val menuMap = mutableMapOf<String, () -> Unit>()

    init {
        content = when (type) {
            MenuType.ARCHIVE -> "архив"
            MenuType.NOTE -> "заметку"

        }
        initMenuMap()
    }

    open fun initMenuMap() {
        when (type) {
            MenuType.ARCHIVE -> {
                menuMap["Создать $content"] = { createContent() }
                menuMap["Выход"] = { exitOrBack() }
            }

            MenuType.NOTE -> menuMap["Выход"] = { exitOrBack() }
        }
    }

    fun navigateOnMenu() {
        val input = readInput(InputType.MENU_CHOOSE).toInt()
        for ((num, string) in menuMap.keys.withIndex()) {
            if (num == input) {
                menuMap[string]?.invoke()
            }
        }
    }

    fun updateMenuMap() {
        for (string in contentMap.keys) {
            menuMap.remove("Выход")
            menuMap[string] = { openContent(string) }
            menuMap["Выход"] = { exitOrBack() }
        }
    }

    open fun printMenu() {
        updateMenuMap()
        when (type) {
            MenuType.ARCHIVE -> {
                println("Выбор архива")
                for ((n, string) in menuMap.keys.withIndex()) {
                    println("$n. $string")
                }
            }
            MenuType.NOTE -> {
                println("Выбор заметки")
                for ((n, string) in menuMap.keys.withIndex()) {
                    println("$n. $string")
                }
            }
        }
    }

    private fun readInput(inputType: InputType): String {
        var input: String
        while (true) {
            input = Scanner(System.`in`).nextLine()
            when (inputType) {
                InputType.MENU_CHOOSE -> {
                    if (input.toIntOrNull() != null && input.toInt() in 0 until menuMap.size) {
                        break
                    } else {
                        println("Не правильный ввод, попробуйте еще раз")
                        continue
                    }
                }

                InputType.MENU_INSIDE -> {
                    if (input.toIntOrNull() != null && input.toInt() in 0 until contentMap.size) {
                        break
                    } else {
                        println("Не правильный ввод, попробуйте еще раз")
                        continue
                    }
                }
                InputType.TEXT -> {
                    break
                }
                InputType.MENU_NOTE -> {
                    if (input.toIntOrNull() != null && input.toInt() == 0) {
                        break
                    } else {
                        println("Не правильный ввод, попробуйте еще раз")
                        continue
                    }
                }
            }
        }
        return input
    }

    open fun createContent() {
        when (type) {
            MenuType.ARCHIVE -> {
                val menuCreate = MenuCreate(MenuType.ARCHIVE)
                menuCreate.printMenu()
                menuCreate.navigateOnMenu()
                // чтото явно не то((

            }
            MenuType.NOTE -> {

            }
        }


    }

    private fun openContent(string: String) {
        //надо придумать реализацию
    }


    private fun exitOrBack() {
        //надо придумать реализацию
    }

}