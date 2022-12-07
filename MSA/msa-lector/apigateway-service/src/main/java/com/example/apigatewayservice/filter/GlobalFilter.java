package com.example.apigatewayservice.filter;

import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.http.server.ServletServerHttpRequest;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.stereotype.Component;

import reactor.core.publisher.Mono;

@Component
public class GlobalFilter extends AbstractGatewayFilterFactory<GlobalFilter.Config>{
	
	public GlobalFilter() {
		super(Config.class);
	}
	
	
	@Override
	public GatewayFilter apply(Config config) {
		return ((exchange, chain)-> {
			//request filter -> pre custom filter
			ServerHttpRequest request = exchange.getRequest();
			ServerHttpResponse respone = exchange.getResponse();
			
			return chain.filter(exchange).then(Mono.fromRunnable(() -> {
				//response filter -> post custom filter
				ServerHttpResponse response = exchange.getResponse();
			}));
		});
	}

	public static class Config{
		//configuration properties
		private String baseMessage;
		private boolean preLogger;
		private boolean postLogger;

	}
}
