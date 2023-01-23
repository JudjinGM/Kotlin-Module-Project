class MenuOpenArchive(private val archiveName: String) : MenuMap() {

    init {
        initMenuMap()
    }

    override val menuName = "[$archiveName]"

    val listOfNotes = DataArchivesAndNotes.getListOfNotesFromArchive(archiveName)

    override fun initMenuMap() {
        menuMap["Создать заметку"] = { createMenuNote(archiveName) }
        if (listOfNotes != null) {
            for (note in listOfNotes) {
                menuMap[note.name] = { openMenuNote(note.name) }
            }
        }

        menuMap["Назад"] = { exitOrBack() }
    }

     fun updateMenuMap() {
        menuMap.remove("Назад")
        if (listOfNotes != null) {
            for (note in listOfNotes) {
                menuMap[note.name] = { openMenuNote(note.name) }
            }
        }
        menuMap["Назад"] = { exitOrBack() }
    }

     private fun createMenuNote(archiveName: String) {
        val menuCreateNote = MenuCreateNote(archiveName)
        val menuHandlerCreateNote = MenuHandler(menuCreateNote)

        while (menuCreateNote.isOnMenu) {
            menuHandlerCreateNote.printMenu()
            menuHandlerCreateNote.navigateOnMenu()
        }
    }

    private fun openMenuNote(noteName: String) {
        val menuMapOpenNote = MenuMapOpenNote(archiveName, noteName)
        val menuHandlerOpenNote = MenuHandler(menuMapOpenNote)
        while (menuMapOpenNote.isOnMenu) {
            DataArchivesAndNotes.printSpecificNote(archiveName, noteName)
            menuHandlerOpenNote.printMenu()
            menuHandlerOpenNote.navigateOnMenu()
        }
    }

}