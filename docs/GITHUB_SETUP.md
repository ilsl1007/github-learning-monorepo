# GitHub 仓库手动配置指南

这些配置依赖 GitHub 账号、组织、仓库权限，不能只靠本地文件完全生效。

## 1. 创建远程仓库

```bash
git init -b main
git add .
git commit -m "feat: initialize github learning monorepo"
git remote add origin git@github.com:<owner>/<repo>.git
git push -u origin main
```

## 2. 修改 CODEOWNERS

将 `.github/CODEOWNERS` 里的占位符替换为真实账号或团队：

```text
* @your-org/maintainers
/backend/ @your-org/backend-team
/frontend/ @your-org/frontend-team
/.github/ @your-org/platform-team
```

个人仓库可以先改成：

```text
* @your-user
/backend/ @your-user
/frontend/ @your-user
/.github/ @your-user
```

## 3. 配置 Ruleset

进入 GitHub 仓库：

1. Settings -> Rules -> Rulesets -> New ruleset -> New branch ruleset。
2. Target branches 选择 `main`。
3. 开启 Restrict deletions。
4. 开启 Require a pull request before merging。
5. Required approvals 设置为 `1`。
6. 开启 Require review from Code Owners。
7. 开启 Require status checks to pass。
8. 添加 required checks：
   - `Backend`
   - `Frontend`
   - `Analyze (java-kotlin)`
   - `Analyze (javascript-typescript)`
9. 开启 Block force pushes。
10. 保存并启用 ruleset。

## 4. 配置 GitHub Pages

1. Settings -> Pages。
2. Source 选择 GitHub Actions。
3. 在 Settings -> Environments 中确认 `github-pages` 环境已创建。
4. 如果后端 API 有线上地址，在 Settings -> Secrets and variables -> Actions -> Variables 中添加：

```text
VITE_API_BASE_URL=https://your-api.example.com
```

## 5. 配置 Labels 和 Milestones

建议创建这些 labels：

- `type: feature`
- `type: bug`
- `area: backend`
- `area: frontend`
- `area: ci`
- `dependencies`

建议创建第一个 milestone：

- `v0.1 GitHub workflow practice`

## 6. 配置 Project

创建一个 GitHub Project，至少包含：

- Backlog
- Ready
- In Progress
- In Review
- Done

用第 14 天完整演练把 Issue 从 Backlog 推到 Done。

## 7. 发布版本

```bash
git tag v0.1.0
git push origin v0.1.0
```

这会触发：

- `.github/workflows/release.yml` 生成 GitHub Release。
- `.github/workflows/docker.yml` 发布后端镜像到 GHCR。

