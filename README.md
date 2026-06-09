# GitHub Learning Monorepo

这是一个用于系统学习 GitHub 协作与高级功能的 Java + Vue Monorepo 示例项目。

## 项目结构

```text
.
├── backend/      # Java 21 + Spring Boot + Maven
├── frontend/     # Vue 3 + Vite + TypeScript
└── .github/      # GitHub Actions、模板、CODEOWNERS、Dependabot
```

## 示例业务

项目实现一个最小 Todo 应用：

- 后端提供 REST API。
- 前端调用 API 展示、创建、更新、删除任务。
- GitHub 配置覆盖 Issues、PR、CI/CD、安全扫描、依赖升级、发布和部署。

## 后端 API

| Method | Path | Description |
| --- | --- | --- |
| GET | `/api/health` | 健康检查 |
| GET | `/api/todos` | 查询任务列表 |
| POST | `/api/todos` | 创建任务 |
| PUT | `/api/todos/{id}` | 更新任务 |
| DELETE | `/api/todos/{id}` | 删除任务 |

## 本地运行

### 后端

需要 Java 21。

```bash
cd backend
mvn spring-boot:run
```

### 前端

```bash
cd frontend
npm install
npm run dev
```

前端默认访问 `http://localhost:8080`。可以通过 `.env.local` 覆盖：

```text
VITE_API_BASE_URL=http://localhost:8080
```

## 常用命令

```bash
# 后端测试
cd backend && mvn test

# 前端测试
cd frontend && npm test

# 前端构建
cd frontend && npm run build
```

## GitHub 学习重点

- 分支模型：`main`、`feature/*`、`fix/*`
- Pull Request：模板、review、required checks
- Issues：labels、milestones、projects
- 代码所有权：CODEOWNERS
- CI：后端测试、前端测试、构建产物
- CD：GitHub Pages、Docker 镜像发布到 GHCR
- 安全：Dependabot、CodeQL、secret 风险管理
- 发布：tags、releases、changelog
