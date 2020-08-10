package novi.spring.model.notes;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import novi.spring.model.users.User;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "notes")
public class Note {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne()
    @JsonManagedReference
    private User user;

    private String name;
    private String description;
    private String url;

    @OneToMany(mappedBy = "note")
    @JsonManagedReference
    private List<Like> likes = new ArrayList<>();

    @OneToMany(mappedBy = "note")
    @JsonManagedReference
    private List<Comment> comments = new ArrayList<>();

    @ManyToMany()
    @JoinTable(	name = "note_tag",
            joinColumns = @JoinColumn(name = "note_id"),
            inverseJoinColumns = @JoinColumn(name = "tag_id"))
    private List<Tag> tags = new ArrayList<>();

    public Note() {}

    public Note(User user, String name, String url) {
        this.user = user;
        this.name = name;
        this.url = url;
    }

    public User getUser() {
        return user;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getUrl() {
        return url;
    }

    public List<Like> getLikes() {
        return likes;
    }

    public List<Tag> getTags() {
        return tags;
    }

    public void addLike(Like like) {
        this.likes.add(like);
    }

    public void addComment(Comment comment) {
        this.comments.add(comment);
    }

    public void addTag(Tag tag) {
        this.tags.add(tag);
    }
}