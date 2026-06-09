# 2 周 GitHub 速成路线

## 第 1 周：从仓库到协作

| Day | 主题 | 实战任务 |
| --- | --- | --- |
| 1 | 仓库基础 | 创建仓库、README、LICENSE、`.gitignore`、目录结构 |
| 2 | 后端项目 | 实现 Spring Boot Todo API 和测试 |
| 3 | 前端项目 | 实现 Vue 3 页面并调用后端 API |
| 4 | 分支与 PR | 创建 feature 分支、提交、打开 PR、review、merge |
| 5 | 项目管理 | 使用 Issues、Labels、Milestones、Projects 管理迭代 |
| 6 | CI 基础 | 配置后端 Maven test、前端 npm test/build |
| 7 | CI 排错 | 查看 Actions 日志、缓存、artifacts、状态徽章 |

## 第 2 周：大型项目常用能力

| Day | 主题 | 实战任务 |
| --- | --- | --- |
| 8 | 合并门禁 | 配置 Ruleset、CODEOWNERS、PR Template |
| 9 | 安全治理 | 配置 Dependabot、CodeQL，理解 secret 风险 |
| 10 | 镜像发布 | 后端 Dockerfile，发布镜像到 GHCR |
| 11 | 前端部署 | 使用 GitHub Pages 部署前端 |
| 12 | 环境管理 | 使用 Environments、Secrets、部署审批和回滚思路 |
| 13 | 大型项目实践 | 学习 ownership、release train、版本策略、CI 拆分 |
| 14 | 完整演练 | 从 Issue 到分支、PR、CI、review、merge、release、部署 |

## 验收清单

- [ ] `main` 禁止直接推送。
- [ ] PR 必须通过 CI 才能合并。
- [ ] 修改 `backend/` 会请求后端 owner review。
- [ ] 修改 `frontend/` 会请求前端 owner review。
- [ ] Dependabot 能创建依赖升级 PR。
- [ ] 发布 tag 会生成 release，并触发 Docker 镜像发布。
- [ ] 合并到 `main` 后前端能部署到 GitHub Pages。

