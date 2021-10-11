package com.streamobserver.streamobserver;

import com.github.britooo.looca.api.core.Looca;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class StreamObserverApplication {
    public static void main(String[] args) {
        SpringApplication.run(StreamObserverApplication.class, args);

        Looca looca = new Looca();
    }
}