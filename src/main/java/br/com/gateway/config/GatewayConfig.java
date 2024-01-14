package br.com.gateway.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GatewayConfig {
	
	@Value("${api.golang.url}")
	private String golangApi;

	@Bean
	public RouteLocator routes(RouteLocatorBuilder builder) {
		return builder.routes().route(r -> r.path("/minio/**").uri(golangApi)).build();
	}

}