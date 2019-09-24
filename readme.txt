
生成镜像
mvn clean package docker:build -DpushImageTag
删除none镜像
docker rmi `docker images | grep  "<none>" | awk '{print $3}'`
创建容器
docker run -d -p 8280:8280 --name mzjtestboot mzj:5000/mzjtestboot

访问测试地址:
curl http://localhost:8280/mzjtestboot/
curl http://localhost:8280/mzjtestboot/animal/call