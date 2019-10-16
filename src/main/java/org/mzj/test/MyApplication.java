package org.mzj.test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.server.ConfigurableWebServerFactory;
import org.springframework.boot.web.server.WebServerFactoryCustomizer;

/**
 *  启动加速的VM参数:
 *  -XX:TieredStopAtLevel=1  多层编译编译到第一层,只用C1
 *  -noverify  关闭字节码校验
 * @author mzj
 */
@SpringBootApplication
public class MyApplication {
    public static void main(String[] args) {
        SpringApplication.run(MyApplication.class, args);
    }
    
//    @Bean
	public WebServerFactoryCustomizer<ConfigurableWebServerFactory> webServerFactoryCustomizer() {
		return factory -> factory.setPort(8081);
	}
	
//	@Configuration
//    @Profile("local")
//    @ComponentScan(lazyInit = true)
//    static class LocalConfig {
//		static {
//			System.out.println("延迟加载，加速应用启动。");
//		}
//    }
}
