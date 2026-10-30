package com.project.poc_java8_completable_future.example;

import java.util.concurrent.CompletableFuture;

public class Example03CompletableFutureChaining {

    public static void main(String[] args) {

        CompletableFuture<Integer> priceFuture =
                CompletableFuture.supplyAsync(() -> {
                    System.out.println("Fetching product price...");
                    return 100;
                });

        CompletableFuture<Integer> discountedPriceFuture =
                priceFuture.thenApply(price -> {
                    System.out.println("Applying discount...");
                    return price - 10;
                });

        CompletableFuture<Void> notificationFuture =
                discountedPriceFuture.thenAccept(discountedPrice -> {
                    System.out.println(
                            "Discounted price: " + discountedPrice
                    );
                });

        CompletableFuture<Void> finalFuture =
                notificationFuture.thenRun(() -> {
                    System.out.println("Order processing completed!");
                });

        finalFuture.join();

        System.out.println("Main thread finished.");
    }

    /**
     * Fetching product price...
     * Applying discount...
     * Discounted price: 90
     * Order processing completed!
     * Main thread finished.
     */
}
