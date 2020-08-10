package novi.spring.rest.data.request;

import lombok.Getter;

import java.util.List;

public class NoteRequest {
    @Getter
    private String name;
    @Getter
    private String url;
    @Getter
    private List<String> tags;
}
