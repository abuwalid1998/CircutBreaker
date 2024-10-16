package com.example.circutbreaker.Functions;

import io.github.resilience4j.circuitbreaker.event.CircuitBreakerOnStateTransitionEvent;
import io.github.resilience4j.circuitbreaker.CircuitBreakerRegistry;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class CircuitBreakerEventListener {

    private final CircuitBreakerRegistry circuitBreakerRegistry;

    public CircuitBreakerEventListener(CircuitBreakerRegistry registry) {
        this.circuitBreakerRegistry = registry;
    }

    @EventListener
    public void onCircuitBreakerStateChange(CircuitBreakerOnStateTransitionEvent event) {
        System.out.println("Circuit breaker state changed: " + event.getStateTransition());
        // Send notifications or log the state changes
    }
}