fun main() {
    val menuArchiveChoose = MenuArchiveChoose()
    val menuHandlerArchive = MenuHandler(menuArchiveChoose)
    while (menuArchiveChoose.isOnMenu) {
        menuArchiveChoose.updateMenuMap()
//        println ("Выбор архива")
        menuHandlerArchive.printMenu()
        menuHandlerArchive.navigateOnMenu()
    }
}