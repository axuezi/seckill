package com.axue.solution.activity;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;

/**
 * 活动系统
 *
 * @author axue
 */
@Slf4j
@EnableFeignClients
@EnableDiscoveryClient
@SpringBootApplication
public class ActivityMain {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(ActivityMain.class, args);
        ConfigurableEnvironment env = context.getEnvironment();
        log.info("\n-------------------------------------------------------------------------------\n" +
                        "应用 '{}' 运行成功! \n" +
                        "配置中心地址为:{}\t命名空间为:{}\n" +
                        "注册中心地址为:{}\t命名空间为:{}\n" +
                        "-------------------------------------------------------------------------------",
                env.getProperty("spring.application.name"),
                env.getProperty("spring.cloud.nacos.config.server-addr"),
                env.getProperty("spring.cloud.nacos.config.namespace", "public"),
                env.getProperty("spring.cloud.nacos.discovery.server-addr"),
                env.getProperty("spring.cloud.nacos.discovery.namespace", "public")
        );
    }

}
