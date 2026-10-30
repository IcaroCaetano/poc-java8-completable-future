package com.project.poc_java8_completable_future.example;

import java.util.concurrent.CompletableFuture;

public class Example03CompletableFutureComposeAndCombine {

    public static void main(String[] args) {

        // Example 1: thenCompose()
        // Simulate fetching a user ID
        CompletableFuture<String> userIdFuture =
                CompletableFuture.supplyAsync(() -> {
                    System.out.println("Fetching user ID...");
                    return "USER-123";
                });

        // Fetch user details based on the user ID
        CompletableFuture<String> userDetailsFuture =
                userIdFuture.thenCompose(userId ->
                        CompletableFuture.supplyAsync(() -> {
                            System.out.println(
                                    "Fetching details for " + userId
                            );
                            return "John Doe";
                        })
                );

        System.out.println(
                "User details: " + userDetailsFuture.join()
        );

        System.out.println("--------------------------------");

        // Example 2: thenCombine()
        // Simulate two independent operations
        CompletableFuture<Double> priceFuture =
                CompletableFuture.supplyAsync(() -> {
                    System.out.println("Fetching product price...");
                    return 100.0;
                });

        CompletableFuture<Integer> quantityFuture =
                CompletableFuture.supplyAsync(() -> {
                    System.out.println("Fetching product quantity...");
                    return 3;
                });

        // Combine both results
        CompletableFuture<Double> totalFuture =
                priceFuture.thenCombine(
                        quantityFuture,
                        (price, quantity) -> price * quantity
                );

        System.out.println(
                "Order total: " + totalFuture.join()
        );

        /**
         * Fetching user ID...
         * Fetching details for USER-123
         * User details: John Doe
         * --------------------------------
         * Fetching product price...
         * Fetching product quantity...
         * Order total: 300.0
         */
    }
}
