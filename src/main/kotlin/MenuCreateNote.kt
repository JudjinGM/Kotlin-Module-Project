class MenuCreateNote(type: MenuType):Menu(type) {
    class MenuCreateArchive(type: MenuType) : Menu(type) {

        override fun initMenuMap() {
            menuMap["Ввод название заметки"] = { createNote() }
            menuMap["Выход"] = {  }
        }

        override fun printMenu() {
            updateMenuMap()
            println("Создать архив")
            for ((n, string) in menuMap.keys.withIndex()) {
                println("$n. $string")
            }
        }

        fun createNote() {
            println("Введите название заметки")
            val input = readInput(InputType.TEXT)
            contentMap[input] = Archive(input)
        }
    }


}