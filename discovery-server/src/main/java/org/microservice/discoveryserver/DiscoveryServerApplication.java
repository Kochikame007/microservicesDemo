package org.microservice.discoveryserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/*
* This is the main class for discovery server application
* @This class intializes EurekaServer to enable service discovery and registration
* */
@SpringBootApplication
@EnableEurekaServer
public class DiscoveryServerApplication {

    /*
    * Main entry point for this class
    * @param args command line argument passed to the application
    * */
    public static void main(String[] args) {
        SpringApplication.run(DiscoveryServerApplication.class, args);
    }
}
