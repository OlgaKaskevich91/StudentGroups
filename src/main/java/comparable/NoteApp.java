package comparable;

public class NoteApp {
    public static void main(String[] args) {
        Notebook notebook=new Notebook();
        notebook.addNote("Hi");
        notebook.addNote("Hello");
        notebook.addNote("Good");
        notebook.addNote("Day");
        System.out.println("All notes after adding");
        notebook.seeAllNotes();
        System.out.println();
        notebook.deleteNote("Good");
        System.out.println("All notes after deleting");
        notebook.seeAllNotes();
        System.out.println();
        notebook.editNote(2,"Night");
        System.out.println("All notes after editing");
        notebook.seeAllNotes();

    }
}
