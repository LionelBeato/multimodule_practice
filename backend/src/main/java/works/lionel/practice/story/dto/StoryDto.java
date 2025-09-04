package works.lionel.practice.story.dto;

import java.util.List;

public class StoryDto {
    private Long id;
    private String title;
    private String content;
    private List<PassageDto> passages;

    public StoryDto() {
    }

    public StoryDto(Long id, String title, String content, List<PassageDto> passages) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.passages = passages;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public List<PassageDto> getPassages() {
        return passages;
    }

    public void setPassages(List<PassageDto> passages) {
        this.passages = passages;
    }
}
