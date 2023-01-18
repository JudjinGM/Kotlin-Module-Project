fun main() {

    val archiveChooseMenu = CommonMenu(MenuType.ARCHIVE)

    archiveChooseMenu.updateMenuMap()
    archiveChooseMenu.printMenu()
    archiveChooseMenu.navigateOnMenu(InputType.MENU_CHOOSE)

    if (createChooseArchive == true){
        archiveCreateMenu = CommonMenu(MenuType.ARCHIVE)

    }




    }




}






