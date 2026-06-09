<script setup lang="ts">
import { computed, onMounted, ref } from 'vue';
import { createTodo, deleteTodo, fetchTodos, updateTodo, type Todo } from './api/todos';

const todos = ref<Todo[]>([]);
const title = ref('');
const isLoading = ref(false);
const errorMessage = ref('');

const remainingCount = computed(() => todos.value.filter((todo) => !todo.completed).length);

async function loadTodos() {
  isLoading.value = true;
  errorMessage.value = '';
  try {
    todos.value = await fetchTodos();
  } catch {
    errorMessage.value = '无法加载任务，请确认后端服务已启动。';
  } finally {
    isLoading.value = false;
  }
}

async function addTodo() {
  const nextTitle = title.value.trim();
  if (!nextTitle) {
    return;
  }

  const created = await createTodo(nextTitle);
  todos.value = [...todos.value, created];
  title.value = '';
}

async function toggleTodo(todo: Todo) {
  const updated = await updateTodo({ ...todo, completed: !todo.completed });
  todos.value = todos.value.map((item) => (item.id === updated.id ? updated : item));
}

async function removeTodo(id: number) {
  await deleteTodo(id);
  todos.value = todos.value.filter((todo) => todo.id !== id);
}

onMounted(loadTodos);
</script>

<template>
  <main class="app-shell">
    <section class="toolbar">
      <div>
        <p class="eyebrow">GitHub Learning</p>
        <h1>Todo Workflow</h1>
      </div>
      <div class="counter">
        <strong>{{ remainingCount }}</strong>
        <span>open</span>
      </div>
    </section>

    <form class="todo-form" @submit.prevent="addTodo">
      <input v-model="title" aria-label="Todo title" placeholder="Add a task for your GitHub workflow" />
      <button type="submit">Add</button>
    </form>

    <p v-if="errorMessage" class="error">{{ errorMessage }}</p>
    <p v-else-if="isLoading" class="loading">Loading todos...</p>

    <ul class="todo-list" aria-label="Todo list">
      <li v-for="todo in todos" :key="todo.id" class="todo-item">
        <label>
          <input type="checkbox" :checked="todo.completed" @change="toggleTodo(todo)" />
          <span :class="{ completed: todo.completed }">{{ todo.title }}</span>
        </label>
        <button class="ghost" type="button" @click="removeTodo(todo.id)">Delete</button>
      </li>
    </ul>
  </main>
</template>
