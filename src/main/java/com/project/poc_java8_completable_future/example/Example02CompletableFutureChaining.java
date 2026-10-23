package com.project.poc_java8_completable_future.example;

import java.util.concurrent.CompletableFuture;

public class Example02CompletableFutureChaining {

    public static void main(String[] args) {

        CompletableFuture<Double> priceFuture =
                CompletableFuture.supplyAsync(() -> {
                    System.out.println("Fetching product price...");
                    return 100.0;
                });

        // Recebe o resultado anterior e produz resultado útil.
        CompletableFuture<Double> discountedPriceFuture =
                priceFuture.thenApply(price -> price * 0.90);

        // Recebe o resultado anterior, mas não retorna.
        CompletableFuture<Void> printFuture =
                priceFuture.thenAccept(price ->
                        System.out.println("Original price: " + price)
                );

        // Não Recebe o resultado, e não retorna.
        CompletableFuture<Void> finalFuture =
                priceFuture.thenRun(() ->
                        System.out.println("Price processing completed.")
                );


        System.out.println("Discounted price: " + discountedPriceFuture.join());

        printFuture.join();
        finalFuture.join();

        System.out.println("Main thread finished.");

        /**
         * Fetching product price...
         * Original price: 100.0
         * Price processing completed.
         * Discounted price: 90.0
         * Main thread finished.
         */
    }
}
