package com.metehansargin.lesson_service.config;

import com.metehansargin.lesson_service.client.StudentClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.reactive.LoadBalancedExchangeFilterFunction;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.support.WebClientAdapter;
import org.springframework.web.service.invoker.HttpServiceProxyFactory;

@Configuration
public class WebClientConfig {

    @Autowired
    private LoadBalancedExchangeFilterFunction filterFunction;
    @Bean
    public WebClient studentWebClient() {
    return WebClient.builder().baseUrl("https://student-service").filter(filterFunction).build();
    }
    @Bean
    public StudentClient studentClient() {
        HttpServiceProxyFactory httpServiceProxyFactory= HttpServiceProxyFactory.builderFor(WebClientAdapter.create(studentWebClient())).build();
        return httpServiceProxyFactory.createClient(StudentClient.class);
        /*
        * Student clientın dönebilmesi için web clientten student servisimize bir bağlantı sağladık ve oradan
        * yarattığımız web clientide httpserviceProxyFactor e verdik ve oradan da
        * client yaratarak geri dönüş sağladık
        * */
    }
}
