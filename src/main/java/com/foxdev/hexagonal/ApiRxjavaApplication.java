package com.foxdev.hexagonal;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executors;

@SpringBootApplication
public class ApiRxjavaApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(ApiRxjavaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		CompletableFuture<String> completableFuture=new CompletableFuture();
		Executors.newCachedThreadPool().submit(() -> {
			Thread.sleep(500);
			completableFuture.complete("Hello");
			return null;
		});
	}
}
