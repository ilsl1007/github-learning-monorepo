# Contributing

## 分支规则

- `main`：稳定分支，只接受 Pull Request 合并。
- `feature/*`：新功能。
- `fix/*`：缺陷修复。

## 提交信息

推荐使用简洁的 Conventional Commits：

```text
feat: add todo creation
fix: handle empty todo title
docs: update learning plan
ci: add frontend build workflow
```

## Pull Request 流程

1. 从最新 `main` 创建分支。
2. 保持变更聚焦，一个 PR 解决一个明确问题。
3. 填写 PR 模板，关联 Issue。
4. 等待 CI 通过。
5. 至少一位 reviewer approve 后合并。

## 本地检查

```bash
cd backend && mvn test
cd frontend && npm test && npm run build
```

