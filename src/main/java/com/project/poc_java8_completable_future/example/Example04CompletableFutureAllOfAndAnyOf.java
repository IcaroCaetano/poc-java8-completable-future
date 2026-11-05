package com.project.poc_java8_completable_future.example;

import java.util.concurrent.CompletableFuture;

public class Example04CompletableFutureAllOfAndAnyOf {

    public static void main(String[] args) {


        System.out.println("Starting allOf example...");

        CompletableFuture<String> customersFuture =
                CompletableFuture.supplyAsync(() -> {
                    sleep(2000);
                    return "Customers loaded";
                });

        CompletableFuture<String> productsFuture =
                CompletableFuture.supplyAsync(() -> {
                    sleep(1500);
                    return "Products loaded";
                });

        CompletableFuture<String> ordersFuture =
                CompletableFuture.supplyAsync(() -> {
                    sleep(1000);
                    return "Orders loaded";
                });

        CompletableFuture<Void> allFuture =
                CompletableFuture.allOf(
                        customersFuture,
                        productsFuture,
                        ordersFuture
                );

        allFuture.join();

        System.out.println(customersFuture.join());
        System.out.println(productsFuture.join());
        System.out.println(ordersFuture.join());

        System.out.println("All operations completed!");

        System.out.println("--------------------------------");


        System.out.println("Starting anyOf example...");

        CompletableFuture<String> apiAFuture =
                CompletableFuture.supplyAsync(() -> {
                    sleep(2000);
                    return "Response from API A";
                });

        CompletableFuture<String> apiBFuture =
                CompletableFuture.supplyAsync(() -> {
                    sleep(1000);
                    return "Response from API B";
                });

        CompletableFuture<Object> firstResult =
                CompletableFuture.anyOf(
                        apiAFuture,
                        apiBFuture
                );

        System.out.println("First response: " + firstResult.join());

        System.out.println("Main thread finished.");
    }

    private static void sleep(long milliseconds) {
        try {
            Thread.sleep(milliseconds);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new RuntimeException(e);
        }

        /**
         * Fetching user ID...
         * Fetching details for USER-123
         * User details: John Doe
         * ----------------***********************----------------
         * Fetching product price...
         * Fetching product quantity...
         * Order total: 300.0
         */
    }
}
