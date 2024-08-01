package comparable;

import java.util.ArrayList;
import java.util.List;

/**
 * class for writing notes in a notebook
 */
public class Notebook {
    /**
     * creates a new note
     */
    private List<Note> notes = new ArrayList<>();

    /**
     * adds a new entry to notebook
     *
     * @param note -notation to add
     */
    public void addNote(String note) {
        notes.add(new Note(note));
    }

    /**
     * deletes a note from notebook
     *
     * @param note -notation to delete
     */
    public void deleteNote(String note) {
        for (int i = 0; i < notes.size(); i++) {
            if (notes.get(i).getNote().equals(note)) {
                notes.remove(i);
                break;
            }
        }
    }

    /**
     * edits a note to notebook
     *
     * @param index    -position in the list
     * @param newNote- adding a new note
     */
    public void editNote(int index, String newNote) {
        if (index >= 0 && index < notes.size()) {
            notes.get(index).setNote(newNote);
        } else {
            System.out.println("Invalid index");
        }
    }

    /**
     * print through all the notes in the notebook
     */
    public void seeAllNotes() {
        for (Note note : notes) {
            System.out.println(note);
        }
    }
}
