package io.weli.spring.demo;

import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public static BeanFactoryPostProcessor beanFactoryPostProcessor() {

        // 参考：https://github.com/alchemy-studio/java-snippets/pull/2
        return factory -> {

            var registry = (BeanDefinitionRegistry) factory;

            registry.registerBeanDefinition("myBean",
                    BeanDefinitionBuilder.genericBeanDefinition(String.class)
                            .addConstructorArgValue("This is myBean")
                            .getBeanDefinition()
            );
        };
    }
}
