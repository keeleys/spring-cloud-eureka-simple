## 关于

一个spring-cloud启动服务中心,提供服务注册和服务发现的例子

## 步骤

1. 启动注册中心, `gradle :eureka-server:bootRun`,
2. 启动服务提供者, `gradle :provider:bootRun`
3. 启动服务消费者, `gradle :consumer:bootRun`
3. 启动服务消费者, `gradle :consumer-feign:bootRun`

## 测试
可以通过 `http://localhost:8761/`访问注册中心
可以通过 `http://localhost:8002/hello` 测试
可以通过 `http://localhost:8003/hello/tian` 测试



