import { Component, inject } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { AsyncPipe, NgFor, NgIf } from '@angular/common';
import { Story, Story as StoryService } from '../story';
import { Observable } from 'rxjs';
import {
  FormGroup,
  FormControl,
  Validators,
  ReactiveFormsModule,
} from '@angular/forms';

@Component({
  standalone: true,
  selector: 'story-detail',
  imports: [AsyncPipe, ReactiveFormsModule],
  templateUrl: './story-detail.html',
  styleUrls: ['./story-detail.css'],
})
export class StoryDetail {
  story$: Observable<Story>;
  passageForm: FormGroup;
  storyId: number;
  private route = inject(ActivatedRoute);
  private storyService = inject(StoryService);

  constructor() {
    this.storyId = Number(this.route.snapshot.paramMap.get('id'));
    this.story$ = this.storyService.getStory(this.storyId);
    this.passageForm = new FormGroup({
      title: new FormControl('', Validators.required),
      content: new FormControl('', Validators.required),
    });
  }

  addPassage() {
    if (this.passageForm.valid) {
      const { title, content } = this.passageForm.getRawValue();
      if (typeof title === 'string' && typeof content === 'string') {
        this.storyService
          .addPassage(this.storyId, { title, content })
          .subscribe(() => {
            this.passageForm.reset();
            this.story$ = this.storyService.getStory(this.storyId);
          });
      }
    }
  }
}
