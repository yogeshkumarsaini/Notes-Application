import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Note {
    private int id;
    private String content;
    private LocalDateTime timestamp;

    public Note(int id, String content) {
        this.id = id;
        this.content = content;
        this.timestamp = LocalDateTime.now();
    }

    public Note(int id, String content, LocalDateTime timestamp) {
        this.id = id;
        this.content = content;
        this.timestamp = timestamp;
    }

    public int getId() {
        return id;
    }

    public String getContent() {
        return content;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String formatTimestamp() {
        return timestamp.format(DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss"));
    }
}
