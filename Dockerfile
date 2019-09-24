#FROM maven:3.5-jdk-8 AS build
#COPY src /usr/src/app/src
#COPY pom.xml /usr/src/app
#RUN mvn -f /usr/src/app/pom.xml clean package

FROM openjdk:8-jre-alpine
#将本地文件挂到到/tmp目录 在主机 /var/lib/docker 目录下创建了一个临时文件，并链接到容器的/tmp
#/tmp目录用来持久化到 Docker 数据文件夹，因为 Spring Boot 使用的内嵌 Tomcat 容器默认使用/tmp作为工作目录
VOLUME /tmp
#复制文件到容器
ADD target/mzjtestboot-1.0-SNAPSHOT.jar /mzjtestboot.jar
#暴露8080端口
EXPOSE 8280
#配置启动容器后执行的命令 为了缩短 Tomcat 启动时间，添加一个系统属性指向 “/dev/urandom” 作为 Entropy Source
ENTRYPOINT ["sh","-c","java $JAVA_OPTS -Djava.security.egd=file:/dev/./urandom -jar /mzjtestboot.jar"]
