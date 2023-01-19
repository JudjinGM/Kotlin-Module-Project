class MenuCreateArchive(type: MenuType) : Menu(type) {

    override fun initMenuMap() {
        menuMap["Ввод название архива"] = { createArchive() }
        menuMap["Выход"] = {  }
    }

    override fun printMenu() {
        updateMenuMap()
        println("Создать архив")
        for ((n, string) in menuMap.keys.withIndex()) {
            println("$n. $string")
        }
    }

    fun createArchive() {
        println("Введите название архива")
        val input = readInput(InputType.TEXT)
        contentMap[input] = Archive(input)
    }
}
