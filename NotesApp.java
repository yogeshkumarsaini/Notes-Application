import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

public class NotesApp {
    private static ArrayList<Note> notes = new ArrayList<>();
    private static int idCounter = 1;
    private static final String FILE_NAME = "notes.txt";
    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");

    public static void main(String[] args) {
        loadNotesFromFile(); // Load existing notes

        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n--- Notes Application ---");
            System.out.println("1. Add Note");
            System.out.println("2. View Notes");
            System.out.println("3. Update Note");
            System.out.println("4. Delete Note");
            System.out.println("5. Search Notes");
            System.out.println("6. Exit");
            System.out.print("Enter choice: ");
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1 -> addNote(sc);
                case 2 -> viewNotes();
                case 3 -> updateNote(sc);
                case 4 -> deleteNote(sc);
                case 5 -> searchNotes(sc);
                case 6 -> saveNotesToFile(); // On exit - save notes
                default -> System.out.println("Invalid option!");
            }
        } while (choice != 6);

        sc.close();
    }

    private static void addNote(Scanner sc) {
        System.out.print("Enter note content: ");
        String content = sc.nextLine();
        notes.add(new Note(idCounter++, content));
        System.out.println("Note added successfully!");
    }

    private static void viewNotes() {
        if (notes.isEmpty()) {
            System.out.println("No notes found.");
            return;
        }

        System.out.println("\n--- All Notes ---");
        for (Note note : notes) {
            System.out.println("ID: " + note.getId() +
                    " | " + note.getContent() +
                    " | Created: " + note.formatTimestamp());
        }
    }

    private static void updateNote(Scanner sc) {
        System.out.print("Enter note ID to update: ");
        int id = sc.nextInt();
        sc.nextLine();

        for (Note note : notes) {
            if (note.getId() == id) {
                System.out.print("Enter new content: ");
                note.setContent(sc.nextLine());
                System.out.println("Note updated successfully!");
                return;
            }
        }
        System.out.println("Note not found!");
    }

    private static void deleteNote(Scanner sc) {
        System.out.print("Enter note ID to delete: ");
        int id = sc.nextInt();
        notes.removeIf(note -> note.getId() == id);
        System.out.println("Note deleted successfully!");
    }

    private static void searchNotes(Scanner sc) {
        System.out.print("Enter keyword: ");
        String keyword = sc.nextLine().toLowerCase();

        boolean found = false;
        for (Note note : notes) {
            if (note.getContent().toLowerCase().contains(keyword)) {
                System.out.println("ID: " + note.getId() +
                        " | " + note.getContent() +
                        " | Created: " + note.formatTimestamp());
                found = true;
            }
        }

        if (!found) System.out.println("No matching notes found!");
    }

    // Save notes to file
    private static void saveNotesToFile() {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(FILE_NAME))) {
            for (Note note : notes) {
                bw.write(note.getId() + "::" +
                        note.getContent() + "::" +
                        note.formatTimestamp());
                bw.newLine();
            }
            System.out.println("Notes saved to file successfully.");
        } catch (IOException e) {
            System.out.println("Error saving notes: " + e.getMessage());
        }
    }

    // Load notes from file
    private static void loadNotesFromFile() {
        File file = new File(FILE_NAME);
        if (!file.exists()) return;

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;

            while ((line = br.readLine()) != null) {
                String[] data = line.split("::");
                if (data.length == 3) {
                    int id = Integer.parseInt(data[0]);
                    String content = data[1];
                    LocalDateTime timestamp = LocalDateTime.parse(data[2], formatter);
                    notes.add(new Note(id, content, timestamp));
                    idCounter = Math.max(idCounter, id + 1);
                }
            }
            System.out.println("Notes loaded successfully.");
        } catch (IOException e) {
            System.out.println("Error loading notes: " + e.getMessage());
        }
    }
}
