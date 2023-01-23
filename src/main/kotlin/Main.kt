fun main() {
    val menuArchiveChoose = MenuArchiveChoose()
    val menuHandlerArchiveChoose = MenuHandler(menuArchiveChoose)
    while (menuArchiveChoose.isOnMenu) {
        menuArchiveChoose.updateMenuMap()
        menuHandlerArchiveChoose.printMenu()
        menuHandlerArchiveChoose.navigateOnMenu()
    }
}