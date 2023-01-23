object DataArchivesAndNotes {

    private val archivesWithNotes: MutableMap<Archive, MutableList<Note>> = mutableMapOf()

    fun addArchiveToMap(name: String) {
        val listOfNotes: MutableList<Note> = mutableListOf()
        archivesWithNotes[Archive(name)] = listOfNotes
    }

    fun addNoteToSpecificArchive(archiveName: String, noteName: String, noteText: String) {
        val archive = archivesWithNotes.keys.find { it.name == archiveName }
        if (archive != null) {
            val newNote = Note(noteName, noteText)
            archivesWithNotes[archive]?.add(newNote)
        }
    }

    fun getArchiveWithNotes(): MutableMap<Archive, MutableList<Note>> {
        return archivesWithNotes
    }

    fun getListOfNotesFromArchive(archiveName: String): MutableList<Note> {
        val archive = archivesWithNotes.keys.find { it.name == archiveName }
        return archivesWithNotes[archive] ?: mutableListOf()
    }

    fun printSpecificNote(archiveName: String, noteName: String){
        val archive = archivesWithNotes.keys.find {it.name == archiveName}
        val listOFNotes = archivesWithNotes[archive]
        val note = listOFNotes?.find { it.name==noteName }
        println(note?.text)
    }
}