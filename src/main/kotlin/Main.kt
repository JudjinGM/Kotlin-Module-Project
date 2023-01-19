fun main() {
    var contentMap: MutableMap<String, Content> = mutableMapOf()
    val menuChooseArchive = Menu(MenuType.ARCHIVE)
    while (menuChooseArchive.isWork) {
        menuChooseArchive.printMenu()
        menuChooseArchive.navigateOnMenu()
    }

 }






