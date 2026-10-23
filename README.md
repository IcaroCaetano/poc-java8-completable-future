# POC — CompletableFuture 

O objetivo do CompletableFuture é permitir que você execute tarefas assíncronas, encadeie operações e combine resultados sem precisar bloquear a thread principal enquanto cada tarefa é executada.

O CompletableFuture foi introduzido no Java 8 e permite executar tarefas de forma assíncrona, encadear operações e combinar resultados sem precisar bloquear a execução a cada etapa.

Imagine um microsserviço que precisa consultar três APIs externas. Em vez de esperar a conclusão de cada chamada para iniciar a próxima, podemos executar as consultas de forma independente e combinar os resultados depois.

## Roteiro de estudos

### 01 runAsync() e supplyAsync()
Vamos começar aqui
Executar tarefas assíncronas com e sem retorno de valor.



### 02 thenApply(), thenAccept() e thenRun()

Transformar resultados, consumir valores e executar ações posteriores.



### 03 thenCompose() e thenCombine()

Encadear operações assíncronas e combinar resultados independentes.



### 04 allOf() e anyOf()

Coordenar múltiplas tarefas assíncronas.



### 05 Tratamento de erros

Estudar exceptionally(), handle() e whenComplete().



### 06 Executores personalizados e exemplo real

Controlar threads e montar um fluxo semelhante ao de um microsserviço.