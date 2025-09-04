
package works.lionel.practice.story.controller;

import org.springframework.web.bind.annotation.*;
import works.lionel.practice.story.Story;
import works.lionel.practice.story.StoryService;
import works.lionel.practice.story.Passage;
import works.lionel.practice.story.dto.StoryDto;
import works.lionel.practice.story.dto.PassageDto;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/stories")
public class StoryController {
    private final StoryService storyService;

    public StoryController(StoryService storyService) {
        this.storyService = storyService;
    }

    @PostMapping
    public StoryDto createStory(@RequestBody StoryDto storyDto) {
        Story story = storyService.createStory(storyDto.getTitle(), storyDto.getContent());
        return toDto(story);
    }

    @GetMapping
    public List<StoryDto> getAllStories() {
        return storyService.getAllStories().stream().map(this::toDto).collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public StoryDto getStoryById(@PathVariable Long id) {
        Story story = storyService.getStoryById(id);
        return story != null ? toDto(story) : null;
    }

    private StoryDto toDto(Story story) {
        List<PassageDto> passageDtos = story.getPassages() == null ? List.of()
                : story.getPassages().stream().map(this::toDto).collect(Collectors.toList());
        return new StoryDto(story.getId(), story.getTitle(), story.getContent(), passageDtos);
    }

    private PassageDto toDto(Passage passage) {
        return new PassageDto(
                passage.getId(),
                passage.getTitle(),
                passage.getContent(),
                passage.getPassageOrder(),
                passage.getAuthor(),
                passage.getStory() != null ? passage.getStory().getId() : null);
    }
}
