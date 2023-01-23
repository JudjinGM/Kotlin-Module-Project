class MenuOpenNote(archiveName: String, noteName: String) : Menu() {
    init {
        initMenuMap()
    }

    override val menuName: String = "Заметка [$noteName] в архиве [$archiveName]"

    override fun initMenuMap() {
        menuMap["Назад"] = { exitOrBack() }
    }

}