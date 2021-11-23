# Prática: Classes abstratas em Java


## Objetivos
Nesta prática, você vai trabalhar com herança e com uma classe abstrata em Java. 

## Pré-requisitos

Antes desta prática, consulte o material sobre classes abstratas e interfaces em Java (<a href="https://docs.google.com/presentation/d/1LvvfEGY9IxSbbnlcLILp-4yZBtSk4W3-ugOvR8CveSs/edit?usp=sharing">slides</a> | <a href="https://drive.google.com/file/d/1l4p_gTNBkmvi89xO60-ry4s6XZWaPzeb/view?usp=sharing">vídeo</a>).


## Entrega

Esta prática vai ser entregue em um repositório específico no GitHub Classroom. Clique [aqui](https://classroom.github.com/a/34mSuTrp) para criá-lo. 


## Preparação

Para começar, baixe o arquivo [abstractexample.zip](src/abstractexample.zip) ou, se você fez fork do repositório da disciplina, sincronize os repositórios seguindo estas [instruções](https://docs.github.com/en/github/collaborating-with-pull-requests/working-with-forks/syncing-a-fork) (também possível via [linha de comando](https://www.freecodecamp.org/news/how-to-sync-your-fork-with-the-original-git-repository/)).

Neste código fornecido, temos as seguintes classes:
- [Language.java](src/abstractexample/app/src/main/java/abstractexample/Language.java): classe que armazena dados sobre linguagens, mesma classe do trabalho T1;
- [LanguageTableModel.java](src/abstractexample/app/src/main/java/abstractexample/LanguageTableModel.java): classe que provê dados (Model) para exibição em formato de tabela;
- [LanguageTableGUI.java](src/abstractexample/app/src/main/java/abstractexample/LanguageTableGUI.java): classe que implementa a interface gráfica (View). 

Nestes [slides](https://docs.google.com/presentation/d/1ytrLL75Dxd7ucYHszVVBw9oA7pWlBkBTFL5wdEuYl54/edit?usp=sharing) você encontra uma explicação sobre a apresentação de dados em tabela usando Java.


A interface gráfica do programa tem uma tabela e 2 botões, um para acrescentar linhas na tabela ("Add row") e outro que imprime o conteúdo da tabela no terminal ("Save"). A tabela é editável, ou seja, é possível clicar em uma célula e preenchê-la.




## Sua missão

1. Compile e execute o código usando Gradle:
```
gradle run
```

2. Analise o código fornecido e identifique a sequência de instruções executadas quando o usuário clica no botão "Add row".

3. Adicione um botão em `LanguageTableGUI` para remover uma linha selecionada na tabela.

4. Altere o código referente ao botão "Save" para armazenar o conteúdo da tabela em um arquivo. Você deverá pesquisar como fazer isso em Java, lembrando que existem várias alternativas. Você pode salvar o conteúdo em qualquer formato.


## Extra

Se você quiser exercitar mais, crie um novo programa que apresente outra lista de objetos em forma de tabela (por exemplo, uma tabela com dados sobre pessoas, sobre produtos vendidos, etc. Procure variar os tipos dos atributos (não se limite à classe String).

## Material de apoio 

[How to make Editable JTable in Java Swing](https://www.codejava.net/java-se/swing/editable-jtable-example)  
Artigo descrevendo um código semelhante ao que é fornecido nesta prática.
