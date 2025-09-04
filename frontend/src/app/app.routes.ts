import { Routes } from '@angular/router';

export const routes: Routes = [
  {
    path: '',
    loadComponent: () =>
      import('./story-list/story-list').then((m) => m.StoryList as any),
  },
  {
    path: 'story/:id',
    loadComponent: () =>
      import('./story-detail/story-detail').then((m) => m.StoryDetail as any),
  },
];
