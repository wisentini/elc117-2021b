# Prática: Programação Funcional em Java


## Objetivos
Nesta prática você vai exercitar alguns recursos de programação funcional em Java. 

## Pré-requisitos

Antes de fazer a prática, assista esta [playlist](https://youtube.com/playlist?list=PLbPKf0-GhyAsJ2WifIWvBYD6yyOj326W6) ou estes slides sobre [programação funcional](https://docs.google.com/presentation/d/1cWCR9AaXOQRbggy-DLaMt-_YsAON-AJXg_ku6vLRpxo/edit?usp=sharing) (independente de linguagem) e sobre [programação funcional em Java](https://docs.google.com/presentation/d/1tQRppQuFbrrIIVWgZ0Gwv-Io04_4MI_gxJXzjRvVY_c/edit?usp=sharing).




## Entrega

Esta prática vai ser entregue em um repositório específico no GitHub Classroom. Clique [aqui](https://classroom.github.com/a/w8pcgME1) para criá-lo.


## Expressões Lambda versus Classes Anônimas Aninhadas


1. Baixe o programa [LanguageComparatorLambda.java](src/LanguageComparatorLambda.java) e analise seu código. Veja que foi usada uma classe anônima aninhada para implementar um Comparator, usado na ordenação da lista de linguagens. Substitua a classe anônima aninhada por uma expressão lambda equivalente.


2. Baixe o programa [PersonComparatorLambda.java](src/PersonComparatorLambda.java) e analise seu código. Novamente, veja que foi usada uma classe anônima aninhada para implementar um [Comparator](https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/util/Comparator.html#compare(T,T)), usado na ordenação de uma lista de pessoas pelo nome. Você deverá substituir a classe anônima aninhada por uma expressão lambda que compare pessoas pela idade e não pelo nome. **Atenção**: você vai comparar atributos do tipo `int` e não `String`, portanto não vai usar `compareTo`. Dica: caso você tenha dúvidas, primeiro implemente a comparação por idade dentro da classe anônima aninhada e, quando isso estiver funcionando, faça a substituição pela expressão lambda equivalente.

3. Mais uma vez! No programa [RunnableLambda.java](src/RunnableLambda.java), substitua a classe anônima aninhada por uma expressão lambda equivalente.

Obs.: A título de curiosidade, se você mais tarde quiser se aprofundar e desenvolver uma visão crítica sobre o assunto, [aqui tem um artigo científico](https://sol.sbc.org.br/journals/index.php/jserd/article/view/744) que investiga prós e contras do uso de lambdas em Java, considerando a opinião de desenvolvedores com perfis variados.


## Expressões Lambda e Streams


Resolva os exercícios abaixo seguindo o paradigma funcional, usando streams e expressões lambda, sem nenhum laço explícito e sem modificar as listas existentes.

1. Em um arquivo nomeado `IntegerStreams.java`, entregue um programa que: crie uma lista de inteiros, todos positivos. Processe esta lista multiplicando os inteiros pares por `-1` e os ímpares por `2`, armazenando o resultado em outra lista.


2. No arquivo [NameStreams.java](src/NameStreams.java), temos um programa que cria 2 listas, uma de String e outra de Person, ambas contendo nomes de pessoas. Você deverá adicionar tags HTML a cada nome, no formato ``<li>nome</li>``, e armazenar o resultado em uma única `List<String>`, que terá 4 elementos.  Dica: pesquise como concatenar 2 streams.

3. Ainda no arquivo [NameStreams.java](src/NameStreams.java), crie outra `List<Person>` e adicione 4 pessoas na lista com idades aleatórias até 25 anos (para isso, você pode usar a classe Random, por exemplo). Depois processe a lista e mostre apenas as pessoas que forem maiores de idade.