
生成镜像
mvn clean package docker:build -DpushImageTag
删除none镜像
docker rmi `docker images | grep  "<none>" | awk '{print $3}'`
创建容器
docker run -d -p 8280:8280 -m 256M --name mzjtestboot mzj:5000/mzjtestboot
java -XX:+PrintFlagsFinal -XX:+UnlockExperimentalVMOptions -XX:+UseCGroupMemoryLimitForHeap -version | grep MaxHeapSize
# 结果是 1G / 4 = 256M

测试:
先 kubectl get services 获取到 service地址和端口
NAME                  TYPE        CLUSTER-IP     EXTERNAL-IP   PORT(S)          AGE
mzjtestboot-service   NodePort    10.97.33.156   <none>        8280:31985/TCP   5d16h
访问地址:
curl http://10.97.33.156:8280/mzjtestboot/
curl http://10.97.33.156:8280/mzjtestboot/animal/call

部署Docker Image
kubectl create -f kube.yaml
查看
kubectl get deployment -o wide
kubectl get rs
kubectl get pods
kubectl get services
kubectl describe pod mzjtestboot-deployment-5bccbcdf89-xrpzx
kubectl describe service mzjtestboot-service

使用dashboard:
kubectl create -f kubernetes-dashboard.yaml
kubectl create -f k8s-admin.yaml
获取token:
kubectl describe serviceaccount admin -n kube-system
kubectl describe secret admin-token-pkkhl -n kube-system
访问 https://mzjvm:30001/#!/login 或 http://mzjvm:30002/#!/login