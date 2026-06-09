export interface Todo {
  id: number;
  title: string;
  completed: boolean;
  createdAt: string;
  updatedAt: string;
}

const API_BASE_URL = import.meta.env.VITE_API_BASE_URL ?? 'http://localhost:8080';

async function request<T>(path: string, options?: RequestInit): Promise<T> {
  const response = await fetch(`${API_BASE_URL}${path}`, {
    headers: {
      'Content-Type': 'application/json',
      ...options?.headers,
    },
    ...options,
  });

  if (!response.ok) {
    throw new Error(`API request failed: ${response.status}`);
  }

  if (response.status === 204) {
    return undefined as T;
  }

  return response.json() as Promise<T>;
}

export function fetchTodos(): Promise<Todo[]> {
  return request<Todo[]>('/api/todos');
}

export function createTodo(title: string): Promise<Todo> {
  return request<Todo>('/api/todos', {
    method: 'POST',
    body: JSON.stringify({ title }),
  });
}

export function updateTodo(todo: Todo): Promise<Todo> {
  return request<Todo>(`/api/todos/${todo.id}`, {
    method: 'PUT',
    body: JSON.stringify({ title: todo.title, completed: todo.completed }),
  });
}

export function deleteTodo(id: number): Promise<void> {
  return request<void>(`/api/todos/${id}`, {
    method: 'DELETE',
  });
}

