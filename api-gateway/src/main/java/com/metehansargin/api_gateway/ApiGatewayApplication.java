package com.metehansargin.api_gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class ApiGatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiGatewayApplication.class, args);
	}
	//burada apigateway kullanmamızın sebebi şu birden fazla service kısmını tek bir localhost portundan çağırabiliyoruz
	//appilication.yaml da yazdığım şeyler sayesinde hem lesson hemde student servislerindeki bütün değerleri döndürür
}
