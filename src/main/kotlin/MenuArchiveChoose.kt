class MenuArchiveChoose : MenuMap() {

    init {
        initMenuMap()
    }

    override val menuName = "Выбор архива"

    override fun initMenuMap() {
        menuMap["Создать архив"] = { createMenuArchive() }
        for (archive in DataArchivesAndNotes.getArchiveWithNotes().keys) {
            menuMap[archive.name] = { openArchive(archive.name) }
        }
        menuMap["Выход"] = { exitOrBack() }
    }

     fun updateMenuMap() {
        menuMap.remove("Выход")
        for (archive in DataArchivesAndNotes.getArchiveWithNotes().keys) {
            menuMap[archive.name] = { openArchive(archive.name) }
        }
        menuMap["Выход"] = { exitOrBack() }
    }

     private fun createMenuArchive() {
        val menuCreateArchive = MenuCreateArchive()
        val menuHandlerCreateArchive = MenuHandler(menuCreateArchive)
        while (menuCreateArchive.isOnMenu) {
            menuHandlerCreateArchive.printMenu()
            menuHandlerCreateArchive.navigateOnMenu()
        }
    }

     private fun openArchive(archiveName: String) {
        val menuOpenArchive = MenuOpenArchive(archiveName)
        val menuHandlerOpenArchive = MenuHandler(menuOpenArchive)
        while (menuOpenArchive.isOnMenu) {
            menuOpenArchive.updateMenuMap()
            menuHandlerOpenArchive.printMenu()
            menuHandlerOpenArchive.navigateOnMenu()
        }

    }

}