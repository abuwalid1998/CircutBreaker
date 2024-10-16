package com.example.circutbreaker.Service;


import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import io.github.resilience4j.retry.annotation.Retry;
import org.springframework.stereotype.Service;

@Service
public class HandleServices {

    @CircuitBreaker(name = "HandleServices", fallbackMethod = "fallback")
    @Retry(name = "advancedService")
    @RateLimiter(name = "advancedService")
    public String performRemoteCall() {
        // Simulate a call to a remote service (e.g., HTTP REST API)
        if (Math.random() > 0.5) {
            throw new RuntimeException("Service failed!");
        }
        return "Success";
    }

    // Fallback method in case of failure
    public String fallback(Throwable t) {
        // Custom fallback logic (e.g., return a default response, notify user)
        return "Service is unavailable. Please try again later. Reason: " + t.getMessage();
    }
}
