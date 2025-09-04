import { HttpClient } from '@angular/common/http';
import { inject, Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { tap } from 'rxjs/operators';

export interface Passage {
  id: number;
  storyId: number;
  title: string;
  content: string;
  order: number;
  author: string;
}

export interface Story {
  id: number;
  title: string;
  content: string;
  passages: Passage[];
}

@Injectable({
  providedIn: 'root',
})
export class Story {
  private http = inject(HttpClient);
  private storiesCache: Story[] | null = null;

  getStories(): Observable<Story[]> {
    if (this.storiesCache) {
      return new Observable<Story[]>((observer) => {
        observer.next(this.storiesCache!);
        observer.complete();
      });
    }
    return this.http
      .get<Story[]>('http://localhost:8080/api/stories')
      .pipe(tap((stories) => (this.storiesCache = stories)));
  }

  getStory(id: number): Observable<Story> {
    if (this.storiesCache) {
      const story = this.storiesCache.find((s) => s.id === id) || null;
      return new Observable<Story>((observer) => {
        if (story) observer.next(story);
        observer.complete();
      });
    }
    return this.http.get<Story>(`http://localhost:8080/api/stories/${id}`);
  }

  addStory(story: { title: string; content: string }): Observable<Story> {
    // Invalidate cache after adding a story
    this.storiesCache = null;
    return this.http.post<Story>('http://localhost:8080/api/stories', story);
  }

  addPassage(
    storyId: number,
    passage: { title: string; content: string }
  ): Observable<Passage> {
    // Invalidate cache after adding a passage
    this.storiesCache = null;
    return this.http.post<Passage>(
      `http://localhost:8080/api/stories/${storyId}/passages`,
      passage
    );
  }
}
