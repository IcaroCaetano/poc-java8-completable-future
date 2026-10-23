package com.project.poc_java8_completable_future.example;

import java.util.concurrent.CompletableFuture;

public class Example01CompletableFuture {

    public static void main(String[] args) {

        CompletableFuture<Void> task1 =
                CompletableFuture.runAsync(() -> {
                    System.out.println(
                            "Task 1 running on: "
                                    + Thread.currentThread().getName()
                    );
                });

        task1.join();

        CompletableFuture<String> task2 =
                CompletableFuture.supplyAsync(() -> {
                    System.out.println(
                            "Task 2 running on: " + Thread.currentThread().getName()
                    );

                    return "Hello from CompletableFuture";
                });

        String result = task2.join();

        System.out.println("Result: " + result);
        System.out.println("Main thread finished");

        /**
         * Task 1 running on: ForkJoinPool.commonPool-worker-1
         * Task 2 running on: ForkJoinPool.commonPool-worker-1
         * Result: Hello from CompletableFuture
         * Main thread finished
         */
    }
}
