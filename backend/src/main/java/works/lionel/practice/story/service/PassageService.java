package works.lionel.practice.story.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import works.lionel.practice.story.Passage;
import works.lionel.practice.story.PassageRepository;
import works.lionel.practice.story.Story;
import works.lionel.practice.story.StoryRepository;
import java.util.List;
import java.util.Optional;
import jakarta.persistence.CascadeType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.FetchType;
import com.fasterxml.jackson.annotation.JsonBackReference;

@Service
public class PassageService {
    private final PassageRepository passageRepository;
    private final StoryRepository storyRepository;

    @Autowired
    public PassageService(PassageRepository passageRepository, StoryRepository storyRepository) {
        this.passageRepository = passageRepository;
        this.storyRepository = storyRepository;
    }

    public List<Passage> getPassagesByStory(Long storyId) {
        return passageRepository.findByStoryId(storyId);
    }

    public Passage createPassage(Long storyId, Passage passage) {
        Optional<Story> storyOpt = storyRepository.findById(storyId);
        if (storyOpt.isPresent()) {
            passage.setStory(storyOpt.get());
            return passageRepository.save(passage);
        }
        return null;
    }

    public Passage getPassageById(Long storyId, Long id) {
        Optional<Passage> passageOpt = passageRepository.findById(id);
        if (passageOpt.isPresent() && passageOpt.get().getStory() != null
                && passageOpt.get().getStory().getId().equals(storyId)) {
            return passageOpt.get();
        }
        return null;
    }

    public Passage updatePassage(Long storyId, Long id, Passage updated) {
        Optional<Passage> passageOpt = passageRepository.findById(id);
        Optional<Story> storyOpt = storyRepository.findById(storyId);
        if (passageOpt.isPresent() && storyOpt.isPresent()) {
            Passage passage = passageOpt.get();
            updated.setId(id);
            updated.setStory(storyOpt.get());
            return passageRepository.save(updated);
        }
        return null;
    }

    public void deletePassage(Long storyId, Long id) {
        Optional<Passage> passageOpt = passageRepository.findById(id);
        if (passageOpt.isPresent() && passageOpt.get().getStory() != null
                && passageOpt.get().getStory().getId().equals(storyId)) {
            passageRepository.deleteById(id);
        }
    }

    @OneToMany(mappedBy = "story", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Passage> passages;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "story_id")
    @JsonBackReference
    private Story story;
}
