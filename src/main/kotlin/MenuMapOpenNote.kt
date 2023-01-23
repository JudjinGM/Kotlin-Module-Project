class MenuMapOpenNote(private val archiveName: String, private val noteName: String):MenuMap() {
    init{
        initMenuMap()
    }
    override val menuName: String = "Заметка [$noteName] в архиве [$archiveName]"

    override fun initMenuMap() {
        menuMap["Назад"] = { exitOrBack() }
    }

}