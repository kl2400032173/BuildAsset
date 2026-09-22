package com.buildasset.gateway.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.function.RouterFunction;
import org.springframework.web.servlet.function.ServerResponse;

import static org.springframework.cloud.gateway.server.mvc.filter.LoadBalancerFilterFunctions.lb;
import static org.springframework.cloud.gateway.server.mvc.handler.GatewayRouterFunctions.route;
import static org.springframework.cloud.gateway.server.mvc.handler.HandlerFunctions.http;

@Configuration
public class GatewayRoutes {

    @Bean
    public RouterFunction<ServerResponse> contractorRoute() {
        return route("contractor-service")
                .GET("/api/contractors/**", http())
                .POST("/api/contractors/**", http())
                .PUT("/api/contractors/**", http())
                .DELETE("/api/contractors/**", http())
                .filter(lb("CONTRACTOR-SERVICE"))
                .build();
    }

    @Bean
    public RouterFunction<ServerResponse> equipmentRoute() {
        return route("equipment-service")
                .GET("/api/equipment/**", http())
                .POST("/api/equipment/**", http())
                .PUT("/api/equipment/**", http())
                .DELETE("/api/equipment/**", http())
                .filter(lb("EQUIPMENT-SERVICE"))
                .build();
    }

    @Bean
    public RouterFunction<ServerResponse> rentalRoute() {
        return route("rental-service")
                .GET("/api/rentals/**", http())
                .POST("/api/rentals/**", http())
                .PUT("/api/rentals/**", http())
                .DELETE("/api/rentals/**", http())
                .filter(lb("RENTAL-SERVICE"))
                .build();
    }

    @Bean
    public RouterFunction<ServerResponse> dispatchRoute() {
        return route("dispatch-service")
                .GET("/api/dispatch/**", http())
                .POST("/api/dispatch/**", http())
                .PUT("/api/dispatch/**", http())
                .DELETE("/api/dispatch/**", http())
                .filter(lb("DISPATCH-SERVICE"))
                .build();
    }
}