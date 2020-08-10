package novi.spring.model.notes;

import com.fasterxml.jackson.annotation.JsonBackReference;
import novi.spring.model.users.User;

import javax.persistence.*;

@Entity
@Table(name = "comments")
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne()
    @JsonBackReference
    private Note note;

    @ManyToOne()
    @JsonBackReference
    private User user;

    private String text;

    public Comment() {}

    public Comment(Note note, User user, String text) {
        this.note = note;
        this.user = user;
        this.text = text;
    }

    public Note getNote() {
        return note;
    }

    public User getUser() {
        return user;
    }

    public String getText() {
        return text;
    }

}
