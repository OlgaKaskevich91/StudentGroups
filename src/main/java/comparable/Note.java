package comparable;

public class Note {
    /**
     * class Note with line of note
     *
     * @author Olga Kaskevich
     * @version 1.0.
     */
    private String note;

    /**
     * constructor-create new Note
     *
     * @param note-notation
     */
    public Note(String note) {
        this.note = note;
    }

    /**
     * Function to get field value
     *
     * @ return the text of the note
     */
    public String getNote() {
        return note;
    }

    /**
     * Function to set field value
     *
     * @param note-notation
     */
    public void setNote(String note) {
        this.note = note;
    }

    /**
     * Display information from a note in an easy-to-read format
     *
     * @return information
     */
    @Override
    public String toString() {
        return "Note{" +
                "note='" + note + '\'' +
                '}';
    }
}
