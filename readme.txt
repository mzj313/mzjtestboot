
生成镜像
mvn clean package docker:build -DpushImageTag
删除none镜像
docker rmi `docker images | grep  "<none>" | awk '{print $3}'`
创建容器
docker run -d -p 8280:8280 -m 256M --name mzjtestboot mzj:5000/mzjtestboot
java -XX:+PrintFlagsFinal -XX:+UnlockExperimentalVMOptions -XX:+UseCGroupMemoryLimitForHeap -version | grep MaxHeapSize
# 结果是 1G / 4 = 256M

访问测试地址:
curl http://localhost:8280/mzjtestboot/
curl http://localhost:8280/mzjtestboot/animal/call

部署Docker Image
kubectl create -f kube.yaml
查看
kubectl get deployment -o wide
kubectl get rs
kubectl get pods
kubectl get services
kubectl describe pod mzjtestboot-deployment-5bccbcdf89-xrpzx
kubectl describe service mzjtestboot-service
