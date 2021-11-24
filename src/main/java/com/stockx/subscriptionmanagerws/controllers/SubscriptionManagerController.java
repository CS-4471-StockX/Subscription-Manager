package com.stockx.subscriptionmanagerws.controllers;

import com.stockx.subscriptionmanagerws.services.SubscriptionManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SubscriptionManagerController {

    @Autowired
    SubscriptionManagerService subscriptionManagerService;

    @GetMapping("/health")
    public String health() {
        return "UP";
    }

    @PutMapping("/subscribe")
    public void subscribeToTopic(@RequestParam("symbol") String symbol, @RequestParam("service") String service) {
        subscriptionManagerService.subscribeToTopic(symbol, service);
    }

    @PutMapping("/unsubscribe")
    public void unsubscribeFromTopic(@RequestParam("symbol") String symbol) {
        subscriptionManagerService.unsubscribeFromTopic(symbol);
    }

}
