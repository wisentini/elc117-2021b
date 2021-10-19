# Prática: Primeiro Contato com Java


Nesta parte da disciplina, vamos inverter a ordem clássica de teoria seguida de prática. Vamos primeiro fazer uma prática com Java, a linguagem orientada a objetos que vamos utilizar, para logo depois entender mais sobre este paradigma de programação.

## Preparação do Ambiente 


Para fazer estes exercícios, você vai precisar de um ambiente de desenvolvimento Java (Java Development Kit - JDK). Existem diferentes ambientes e versões. Você encontra algumas delas aqui: https://www.oracle.com/java/technologies/javase-downloads.html



## Exercícios

### Olá, Mundo!

1. Baixe o programa [OlaMundo.java](src/OlaMundo.java).

2. Num terminal de comandos, compile o programa:

   ```
   javac OlaMundo.java
   ```
   O comando acima produz um arquivo .class para a classe contida em OlaMundo.java. Um arquivo .class contém um código (bytecode) interpretável por uma máquina virtual Java.

3. Execute o programa na máquina virtual Java, informando o **nome da classe que contém o método main**:

   ```
   java -cp . OlaMundo
   ```
   Obs.: Se algo der errado e você estiver usando Windows, veja esta [página da Oracle](https://docs.oracle.com/javase/tutorial/getStarted/problems/index.html) sobre problemas comuns e suas soluções. 



### Circle

1. Baixe os programas [Circle.java](src/Circle.java) e [TestCircle.java](src/TestCircle.java) e **coloque-os na mesma pasta**. 

2. Observe os códigos e procure identificar semelhanças e diferenças entre Java e C.

3. Compile e execute o programa:
   ```
   javac Circle.java TestCircle.java
   java -cp . TestCircle
   ```
4. No programa [TestCircle.java](src/TestCircle.java), inclua a seguinte linha de código ao final do método `main`:
    ```
    c1.r = 0.5;
    ```
    Compile o programa. Algo vai dar errado... Se o código fosse em C e você quisesse acessar um elemento de um struct, isso estaria certo. Por que será que em Java é diferente? Aguarde o novo episódio, ou tente desvendar esse mistério consultando a bibliografia básica da disciplina :smiley:  (Robert Sebesta. Conceitos de Linguagens de Programação. Bookman, 2018. Disponível no [Portal de E-books](https://www.ufsm.br/orgaos-suplementares/biblioteca/e-books-2/) da UFSM).
    

### Além do círculo 

E se, em vez de círculos, você quisesse representar algum outro tipo de objeto? Quais seriam suas características? O que se poderia fazer com este objeto? Com base em Circle.java e TestCircle.java, crie um programa simples para representar o que você pensou. Mantenha o código em 2 arquivos nomeados e organizados com o mesmo padrão dos exemplos (substitua Circle pelo que você quiser representar).


### Aventure-se!

Se você quiser viver perigosamente :smiley: ... aventure-se por códigos maiores, baixando o programa [HttpURLConnectionExample.java](src/HttpURLConnectionExample.java). Este programa faz uma requisição HTTP a um serviço que retorna frases sobre programação. 

Compile e execute o programa para ver o resultado. Modifique o programa para fazer uma requisição a uma URL diferente. Por exemplo, troque por uma URL que faz uma consulta ao GitHub ou para este serviço com piadas do Chuck Norris: https://api.chucknorris.io/jokes/random :-)
