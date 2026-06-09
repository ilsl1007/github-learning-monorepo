import { render, screen, waitFor } from '@testing-library/vue';
import App from './App.vue';
import { afterEach, beforeEach, describe, expect, it, vi } from 'vitest';

const seedTodos = [
  {
    id: 1,
    title: 'Create first GitHub issue',
    completed: false,
    createdAt: '2026-06-09T00:00:00Z',
    updatedAt: '2026-06-09T00:00:00Z',
  },
  {
    id: 2,
    title: 'Open a pull request',
    completed: true,
    createdAt: '2026-06-09T00:00:00Z',
    updatedAt: '2026-06-09T00:00:00Z',
  },
];

describe('App', () => {
  beforeEach(() => {
    vi.stubGlobal(
      'fetch',
      vi.fn().mockResolvedValue({
        ok: true,
        status: 200,
        json: () => Promise.resolve(seedTodos),
      }),
    );
  });

  afterEach(() => {
    vi.unstubAllGlobals();
  });

  it('loads and renders todos', async () => {
    render(App);

    await waitFor(() => {
      expect(screen.getByText('Create first GitHub issue')).toBeTruthy();
    });

    expect(screen.getByText('Open a pull request')).toBeTruthy();
    expect(screen.getByText('1')).toBeTruthy();
  });
});

