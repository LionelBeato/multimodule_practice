package works.lionel.practice.story.dto;

public class PassageDto {
    private Long id;
    private String title;
    private String content;
    private int order;
    private String author;
    private Long storyId;

    public PassageDto() {
    }

    public PassageDto(Long id, String title, String content, int order, String author, Long storyId) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.order = order;
        this.author = author;
        this.storyId = storyId;
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

    public int getOrder() {
        return order;
    }

    public void setOrder(int order) {
        this.order = order;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Long getStoryId() {
        return storyId;
    }

    public void setStoryId(Long storyId) {
        this.storyId = storyId;
    }
}
