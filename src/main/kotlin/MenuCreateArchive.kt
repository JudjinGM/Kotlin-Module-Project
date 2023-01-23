import java.util.*

class MenuCreateArchive : Menu() {
    init {
        initMenuMap()
    }

    override val menuName = "Создать архив"

    override fun initMenuMap() {
        menuMap["Ввести имя нового архива "] = { createArchive() }
        menuMap["Назад"] = { exitOrBack() }
    }

    private fun createArchive() {
        println("Введите имя нового архива")
        val input = Scanner(System.`in`).nextLine()
        DataArchivesAndNotes.addArchiveToMap(input)
    }

}