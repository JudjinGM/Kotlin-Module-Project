class MenuCreate(type: MenuType) : Menu(type) {

    override fun initMenuMap() {
        menuMap["Введите название архива"] = { "Типа создал" }
        menuMap["Выход"] = { println("Типа вышел") }
    }

    override fun printMenu() {
        updateMenuMap()
        println("Создать архив")
        for ((n, string) in menuMap.keys.withIndex()) {
            println("$n. $string")
        }
    }

}