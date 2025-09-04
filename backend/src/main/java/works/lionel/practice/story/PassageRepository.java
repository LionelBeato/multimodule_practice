package works.lionel.practice.story;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface PassageRepository extends JpaRepository<Passage, Long> {
    List<Passage> findByStoryId(Long storyId);
}
