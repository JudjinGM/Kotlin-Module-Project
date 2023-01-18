import java.util.*

class CommonMenu(val type: MenuType, ) {
    private val contentMap: MutableMap<String, Content> = mutableMapOf()

    private var content = ""

    init {
        content = when (type) {
            MenuType.ARCHIVE -> "архив"
            MenuType.NOTE -> "заметку"
        }
        initMenuMap()
    }

    private val menuMap = mutableMapOf<String, () -> Unit>()


    private fun initMenuMap(){
        when(type){
            MenuType.ARCHIVE -> {
                menuMap["Создать $content"] = { createContent() }
                menuMap["Выход"] = { exitOrBack() }
            }
            MenuType.NOTE -> menuMap["Выход"] = { exitOrBack() }
        }
    }

    fun navigateOnMenu(inputType: InputType) {
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

    fun printMenu() {
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
        var input = ""
        while (true) {
            input = Scanner(System.`in`).nextLine()
            when (inputType) {
                InputType.MENU_CHOOSE -> {
                    if (input.toIntOrNull() != null && input.toInt() in 0..(menuMap.size - 1)) {
                        break
                    } else {
                        println("Не правильный ввод, попробуйте еще раз")
                        continue
                    }
                }

                InputType.MENU_INSIDE -> {
                    if (input.toIntOrNull() != null && input.toInt() in 0..(contentMap.size - 1)) {
                        break
                    } else {
                        println("Не правильный ввод, попробуйте еще раз")
                        continue
                    }
                }
                InputType.CONTENT_NAME -> {
                    break
                }
                InputType.NOTE -> {
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


    private fun createContent() {
        var input: String = ""
        when (type) {
            MenuType.ARCHIVE -> {
                if (readInput(InputType.MENU_INSIDE).toInt() == 0) {
                    input = readInput(InputType.CONTENT_NAME)
                    contentMap[input] = Archive(input)
                    println("Создаю архив c именем $input")
                }
            }

            MenuType.NOTE -> {
                if (readInput(InputType.MENU_INSIDE).toInt() == 0) {
                    input = readInput(InputType.CONTENT_NAME)
                    contentMap[input] = Note(input)
                    println("Введите текст заметки")
                    val text = readInput(InputType.CONTENT_NAME)
                    contentMap[input]
                    println("Создаю заметку с именем $input")


                }
            }
        }
    }

    private fun openContent(string: String) {
        //нужна реализация
    }


    private fun exitOrBack(): Boolean {
        return false
        //нужна реализация
    }

    fun returnContentMap():MutableMap<String, Content>{
        return contentMap
    }
}