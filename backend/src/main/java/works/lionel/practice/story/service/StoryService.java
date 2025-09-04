package works.lionel.practice.story;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class StoryService {
    private final StoryRepository storyRepository;

    @Autowired
    public StoryService(StoryRepository storyRepository) {
        this.storyRepository = storyRepository;
    }

    public Story createStory(String title, String content) {
        Story story = new Story();
        story.setTitle(title);
        story.setContent(content);
        return storyRepository.save(story);
    }

    public List<Story> getAllStories() {
        return storyRepository.findAllWithPassages();
    }

    public Story getStoryById(Long id) {
        return storyRepository.findByIdWithPassages(id);
    }
}
