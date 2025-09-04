package works.lionel.practice.story;

import jakarta.persistence.*;
import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
public class Passage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "story_id")
    @JsonBackReference
    private Story story;

    private String title;
    private String content;
    private String author;

    @Column(name = "passage_order")
    private int passageOrder;

    public Passage() {
    }

    public Passage(Long id, Story story, String title, String content, int passageOrder, String author) {
        this.id = id;
        this.story = story;
        this.title = title;
        this.content = content;
        this.passageOrder = passageOrder;
        this.author = author;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Story getStory() {
        return story;
    }

    public void setStory(Story story) {
        this.story = story;
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

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getPassageOrder() {
        return passageOrder;
    }

    public void setPassageOrder(int passageOrder) {
        this.passageOrder = passageOrder;
    }
}