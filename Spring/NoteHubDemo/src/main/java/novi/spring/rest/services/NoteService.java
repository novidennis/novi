package novi.spring.rest.services;

import novi.spring.repository.NoteRepository;
import novi.spring.repository.TagRepository;
import novi.spring.model.notes.Note;
import novi.spring.model.notes.Tag;
import novi.spring.model.users.User;
import novi.spring.rest.data.request.NoteRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.sql.SQLDataException;
import java.util.List;
import java.util.Optional;

@Controller
public class NoteService {

    @Autowired
    private UserService userService;

    @Autowired
    private NoteRepository notes;

    @Autowired
    private TagRepository tags;

    public String createNote(NoteRequest noteRequest) throws SQLDataException {
        User user = userService.getActiveUser();
        Note note = new Note(user, noteRequest.getName(), noteRequest.getUrl());

        for (String tagName : noteRequest.getTags()) {
            Optional<Tag> _tag = tags.findByName(tagName);
            Tag tag;
            if (!_tag.isPresent()) {
                tag = new Tag(tagName);
                tags.save(tag);
            } else {
                tag = _tag.get();
            }
            note.addTag(tag);
        }

        notes.save(note);
        return "Note succesfully created";
    }

    public List<Note> getNotesFromUser() throws SQLDataException {
        User user = userService.getActiveUser();
        return notes.findAllByUser(user);
    }

    public Note getNoteById(int noteId) throws SQLDataException {
        Optional<Note> _note = notes.findById(noteId);
        if (!_note.isPresent()) {
            throw new SQLDataException("Failed to add like: Note not present");
        }
        return _note.get();
    }
}