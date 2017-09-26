# ms-template

Here are the list of features provided in the library and the template show cases how to use these features with ease. 

## VIP management (local and global)
```xml
        <dependency>
            <groupId>com.services.micro.commons</groupId>
            <artifactId>commons-vip</artifactId>
            <version>1.0.0</version>
        </dependency>
```
http://localhost:8080/demo/vipStatus
http://localhost:8080/demo/vipLocalStatus
http://localhost:8080/demo/vipGlobalStatus

## JSONP support
```xml
        <dependency>
            <groupId>com.services.micro.commons</groupId>
            <artifactId>commons-jsonp</artifactId>
            <version>1.0.0</version>
        </dependency>
```

http://localhost:8080/demo/test?callback=abc

## Memcache integration
```xml
        <dependency>
            <groupId>io.sixhours</groupId>
            <artifactId>memcached-spring-boot-starter</artifactId>
            <version>1.0.1</version>
        </dependency>
```
        


## Telemetry support OOB (metrics ) 
```xml
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-actuator</artifactId>
        </dependency>
        <dependency>
            <groupId>com.services.micro.commons</groupId>
            <artifactId>commons-metric</artifactId>
            <version>1.0.0</version>
        </dependency>
```

 http://localhost:8080/demo/metrics
 http://localhost:8080/demo/dropMetrics
 http://localhost:8080/demo/promMetrics



## CircuitBreaker for dependencies 
```xml
       <dependency>
            <groupId>org.springframework.cloud</groupId>
            <artifactId>spring-cloud-starter-hystrix</artifactId>
        </dependency>
        <dependency>
            <groupId>org.springframework.cloud</groupId>
            <artifactId>spring-cloud-starter-hystrix-dashboard</artifactId>
        </dependency>
```
## Service registration and discovery and load-balancing with Eureka . No more VIPs
```xml
```
## Swagger integration for SDK generation and documentation
```xml
        <dependency>
            <groupId>com.services.micro.commons</groupId>
            <artifactId>commons-swagger</artifactId>
            <version>1.0.0</version>
        </dependency>
```
 http://localhost:8080/demo/swagger-ui.html
 
## SCM (git) build status of the deployed service
```xml
        <dependency>
            <groupId>com.services.micro.commons</groupId>
            <artifactId>commons-git</artifactId>
            <version>1.0.0</version>
        </dependency>
```
 http://localhost:8080/demo/buildStatus
 

 
## Auto configuration with GIT as backend server using spring cloud config server
```xml
        <dependency>
            <groupId>org.springframework.cloud</groupId>
            <artifactId>spring-cloud-config-server</artifactId>
        </dependency>
        <dependency>
            <groupId>org.springframework.cloud</groupId>
            <artifactId>spring-cloud-starter-config</artifactId>
        </dependency>
```

## Distributed log tracing and analysis
```xml
        <dependency>
            <groupId>org.springframework.cloud</groupId>
            <artifactId>spring-cloud-starter-zipkin</artifactId>
        </dependency>
```
