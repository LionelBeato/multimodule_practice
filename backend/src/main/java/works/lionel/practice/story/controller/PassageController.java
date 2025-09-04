package works.lionel.practice.story.controller;

import org.springframework.web.bind.annotation.*;
import works.lionel.practice.story.Passage;
import works.lionel.practice.story.service.PassageService;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/stories/{storyId}/passages")
public class PassageController {
    private final PassageService passageService;

    public PassageController(PassageService passageService) {
        this.passageService = passageService;
    }

    @GetMapping
    public List<Passage> getPassagesByStory(@PathVariable Long storyId) {
        return passageService.getPassagesByStory(storyId);
    }

    @PostMapping
    public Passage createPassage(@PathVariable Long storyId, @RequestBody Passage passage) {
        return passageService.createPassage(storyId, passage);
    }

    @GetMapping("/{id}")
    public Passage getPassageById(@PathVariable Long storyId, @PathVariable Long id) {
        return passageService.getPassageById(storyId, id);
    }

    @PutMapping("/{id}")
    public Passage updatePassage(@PathVariable Long storyId, @PathVariable Long id, @RequestBody Passage updated) {
        return passageService.updatePassage(storyId, id, updated);
    }

    @DeleteMapping("/{id}")
    public void deletePassage(@PathVariable Long storyId, @PathVariable Long id) {
        passageService.deletePassage(storyId, id);
    }
}
