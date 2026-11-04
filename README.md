# POC — CompletableFuture

O objetivo do CompletableFuture é permitir que você execute tarefas assíncronas, encadeie operações e combine resultados sem precisar bloquear a thread principal enquanto cada tarefa é executada.

O CompletableFuture foi introduzido no Java 8 e permite executar tarefas de forma assíncrona, encadear operações e combinar resultados sem precisar bloquear a execução a cada etapa.

Imagine um microsserviço que precisa consultar três APIs externas. Em vez de esperar a conclusão de cada chamada para iniciar a próxima, podemos executar as consultas de forma independente e combinar os resultados depois.

## Roteiro de estudos

### 01 runAsync() e supplyAsync()
Vamos começar aqui
Executar tarefas assíncronas com e sem retorno de valor.

#### runAsync 
 - executa uma tarefa sem retornar um resultado.

Exemplo: enviar uma notificação, gravar um log ou executar uma rotina de limpeza.

#### supplyAsync

- Utilize quando você precisa executar uma operação e obter algum resultado.


### 02 thenApply(), thenAccept() e thenRun()

Transformar resultados, consumir valores e executar ações posteriores.

#### thenApply() — transforma o resultado
Use quando você precisa receber o resultado de uma operação e transformá-lo em outro valor.

package com.example.completablefuture;

#### thenAccept() — consome o resultado
Use quando você quer receber o resultado para fazer alguma coisa com ele, sem produzir um novo valor para a próxima etapa.
import java.util.concurrent.CompletableFuture;

#### thenRun() — executa uma ação sem receber o resultado
Use quando você só precisa executar uma ação após a conclusão da etapa anterior, sem utilizar o resultado dela.
public class Example03CompletableFutureComposeAndCombine {

### 03 thenCompose() e thenCombine()
    public static void main(String[] args) {

Encadear operações assíncronas e combinar resultados independentes.
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

### 04 allOf() e anyOf()
        System.out.println("--------------------------------");

Coordenar múltiplas tarefas assíncronas.
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

### 05 Tratamento de erros
        System.out.println(
                "Order total: " + totalFuture.join()
        );
    }
}

Estudar exceptionally(), handle() e whenComplete().



### 06 Executores personalizados e exemplo real

Controlar threads e montar um fluxo semelhante ao de um microsserviço.
