abstract class Menu {

    val menuMap: MutableMap<String, () -> Unit> = mutableMapOf()
    abstract val menuName: String
    var isOnMenu = true

    abstract fun initMenuMap()

    fun exitOrBack() {
        isOnMenu = false
    }

}
