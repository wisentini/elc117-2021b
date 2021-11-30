# Prática: Exceções em Java


## Objetivos
Nesta prática, você vai trabalhar com exceções em Java, que se baseiam fortemente no conceito de herança de POO.

## Pré-requisitos

Antes desta prática, consulte o material sobre exceções em Java (<a href="https://docs.google.com/presentation/d/1qaRbIe9X0UjKwHwnFqHvNK-fS97LCzm4CaXX0NGMhCo/edit?usp=sharing">slides</a>).


## Entrega

Esta prática vai ser entregue em um repositório específico no GitHub Classroom. Clique [aqui](https://classroom.github.com/a/xibKSpK3) para criá-lo. 


## Preparação

Esta parte não precisa ser entregue!

No arquivo [ExceptionExamples.java](src/ExceptionExamples.java) há vários exemplos envolvendo exceções, tratadas ou não, verificadas ou não (checked/unchecked). São várias pequenas classes no mesmo arquivo, para facilitar a visualização dos exemplos.

1. Compile o código e execute cada uma das classes (note que todas têm seu método main). 

2. Identifique todas as classes de exceções dos exemplos em [ExceptionExamples.java](src/ExceptionExamples.java). Consulte a documentação de referência do Java e descubra a hierarquia de classes de cada uma das classes de exceção dos exemplos.

3. Na classe `CheckedExceptionTryCatch`, temos `catch` para as exceções `FileNotFoundException` e `IOException`. Estas exceções são verificadas (checked) pelo compilador. Se removermos as 2 linhas referentes ao `catch` de `FileNotFoundException`, haverá erro na compilação do programa? Por quê?


## Exercício

No arquivo [HttpURLConnectionExample.java](src/HttpURLConnectionExample.java), há um programa que faz uma requisição pela rede a uma URL. Compile e execute o programa.

Alere um caractere da URL (variável `urlstr`) para torná-la inválida. Compile e execute o programa novamente. Como a URL alterada, o programa produzirá uma exceção e terminará abruptamente. Como o main está declarado com `throws Exception`, a exceção não é capturada e tratada.

Altere o programa para capturar e tratar a exceção que ocorre quando a URL não pode ser acessada.

Entregue o arquivo modificado.
