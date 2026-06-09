# 常用练习命令

## Git 分支与 PR

```bash
git switch -c feature/add-todo-filter
git status
git add .
git commit -m "feat: add todo filter"
git push -u origin feature/add-todo-filter
```

## 后端

```bash
cd backend
mvn test
mvn spring-boot:run
```

如果本机默认不是 Java 21，Windows PowerShell 可以临时切换：

```powershell
$env:JAVA_HOME='C:\Users\yulj\scoop\apps\temurin21-jdk\current'
$env:Path="$env:JAVA_HOME\bin;$env:Path"
mvn test
```

## 前端

```bash
cd frontend
npm install
npm test
npm run build
npm run dev
```

## 发布

```bash
git tag v0.1.0
git push origin v0.1.0
```

推送 tag 后会触发 GitHub Release 和后端 Docker 镜像发布 workflow。

