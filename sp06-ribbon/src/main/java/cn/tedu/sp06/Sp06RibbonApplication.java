package cn.tedu.sp06;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;
//@EnableDiscoveryClient
//@EnableCircuitBreaker
//@SpringBootApplication
@SpringCloudApplication
public class Sp06RibbonApplication {

	public static void main(String[] args) {

		SpringApplication.run(Sp06RibbonApplication.class, args);
	}
	@LoadBalanced
	@Bean
	public RestTemplate getRestTemplate(){
		SimpleClientHttpRequestFactory factory = new SimpleClientHttpRequestFactory();
		factory.setConnectTimeout(1000);
		factory.setReadTimeout(1000);
		return new RestTemplate(factory);
	}
}
