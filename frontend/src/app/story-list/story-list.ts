import { NgFor, AsyncPipe } from '@angular/common';
import { Component, inject } from '@angular/core';
import {
  ReactiveFormsModule,
  FormGroup,
  FormControl,
  Validators,
} from '@angular/forms';
import { RouterLink } from '@angular/router';
import { Observable } from 'rxjs';
import { Story } from '../story';

@Component({
  standalone: true,
  selector: 'story-list',
  imports: [NgFor, AsyncPipe, RouterLink, ReactiveFormsModule],
  template: `
    <main class="main-card">
      <div class="content">
        <div class="left-side">
          <h1>Interactive Stories</h1>
          <form
            [formGroup]="storyForm"
            (ngSubmit)="addStory()"
            class="story-form"
          >
            <div class="form-group">
              <label for="title">Story Title</label>
              <input
                id="title"
                type="text"
                formControlName="title"
                placeholder="Enter a title"
                required
                class="form-control"
              />
            </div>
            <div class="form-group">
              <label for="content">Story Content</label>
              <textarea
                id="content"
                formControlName="content"
                placeholder="Write your story here..."
                required
                rows="4"
                class="form-control"
              ></textarea>
            </div>
            <button
              type="submit"
              [disabled]="storyForm.invalid"
              class="submit-btn"
            >
              Add Story
            </button>
          </form>
          <hr />
          <h2>Story Threads</h2>
          <div>
            <a
              *ngFor="let item of stories$ | async; trackBy: trackById"
              class="story-thread clickable"
              [routerLink]="['/story', item.id]"
            >
              <h3>{{ item.title }}</h3>
              <p>{{ item.content }}</p>
            </a>
          </div>
        </div>
      </div>
    </main>
  `,
})
export class StoryList {
  storyForm = new FormGroup({
    title: new FormControl('', Validators.required),
    content: new FormControl('', Validators.required),
  });

  storyService = inject(Story);
  stories$: Observable<Story[]>;

  constructor() {
    this.stories$ = this.storyService.getStories();
  }
  addStory() {
    if (this.storyForm.valid) {
      const { title, content } = this.storyForm.getRawValue();
      if (typeof title === 'string' && typeof content === 'string') {
        this.storyService.addStory({ title, content }).subscribe(() => {
          this.storyForm.reset();
          this.stories$ = this.storyService.getStories();
        });
      }
    }
  }
  trackById(index: number, item: Story) {
    return item.id;
  }
}
