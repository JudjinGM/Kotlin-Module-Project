import java.util.*

class MenuCreateNote(private val archiveName: String) : Menu() {
    init {
        initMenuMap()
    }

    override val menuName = "Создать заметку в [$archiveName]"

    override fun initMenuMap() {
        menuMap["Ввести имя и текст новой заметки"] = { createNote(archiveName) }
        menuMap["Назад"] = { exitOrBack() }
    }

    private fun createNote(archiveName: String) {
        println("Введите имя заметки")
        val noteName = Scanner(System.`in`).nextLine()
        println("Введите текст заметки")
        val noteText = Scanner(System.`in`).nextLine()
        DataArchivesAndNotes.addNoteToSpecificArchive(archiveName, noteName, noteText)
    }

}