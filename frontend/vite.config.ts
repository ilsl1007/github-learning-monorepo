import { fileURLToPath, URL } from 'node:url';
import vue from '@vitejs/plugin-vue';
import { defineConfig } from 'vite';

export default defineConfig({
  base:
    process.env.GITHUB_PAGES === 'true' && process.env.GITHUB_REPOSITORY
      ? `/${process.env.GITHUB_REPOSITORY.split('/')[1]}/`
      : '/',
  plugins: [vue()],
  resolve: {
    alias: {
      '@': fileURLToPath(new URL('./src', import.meta.url)),
    },
  },
  test: {
    environment: 'jsdom',
    globals: true,
  },
});
