
package works.lionel.practice.story;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;

public interface StoryRepository extends JpaRepository<Story, Long> {
    @Query("SELECT s FROM Story s LEFT JOIN FETCH s.passages WHERE s.id = :id")
    Story findByIdWithPassages(Long id);

    @Query("SELECT DISTINCT s FROM Story s LEFT JOIN FETCH s.passages")
    List<Story> findAllWithPassages();
}
