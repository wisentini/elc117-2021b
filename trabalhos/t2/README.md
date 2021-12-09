# Trabalho 2: Continuando o primeiro trabalho





## Entrega


- Entregue o projeto completo em: https://classroom.github.com/a/tzMi9eTt
- Deadline: terça-feira, 11/01/2022


## Contexto
---

No primeiro trabalho, você partiu de um código fornecido e implementou a inserção e leitura de dados sobre linguagens de programação, mantidos [nesta planilha](https://docs.google.com/spreadsheets/d/1UceqvZgF2dTHRFzYO_bY6fE3oOht02-8tkCgcRMb24k/edit?usp=sharing) e acessíveis via um web service. 

Você já sabe que existem muitas linguagens, algumas mais populares que outras. Quem deseja aprender uma nova linguagem de programação pode consultar uma grande diversidade de recursos disponíveis online, como tutoriais, vídeos, livros ou até mesmo códigos para execução em nuvem. 

Na planilha do trabalho, existe uma aba para armazenar links sobre recursos que podem ajudar no aprendizado de uma determinada linguagem de programação. Para cada recurso, armazenamos a URL, a linguagem a que se refere, o tipo/categoria do recurso (ver aba 'category' na planilha) e mais alguns dados, incluindo a identificação do usuário que indicou o recurso. São esses dados sobre recursos que serão manipulados neste trabalho.


## Objetivo
---

Seu objetivo será criar um programa em Java para cadastro e busca de recursos sobre linguagens de programação, por meio do web service que escreve e lê dados da planilha. Você também vai usar este programa para alimentar a planilha com dados reais de recursos escolhidos e indicados por você, sobre uma ou mais linguagens de programação.




## Requisitos mínimos
---

1. O programa deverá ter **interface gráfica**. Você pode usar os componentes gráficos do Swing, aproveitando os exemplos fornecidos nas práticas, mas também explorando outros componentes, por exemplo JComboBox, JMenu, etc. Você pode usar manualmente as classes de layout do Swing ou usar alguma ferramenta de desenho de interface. 


2. O programa deverá permitir a **inclusão** de um recurso na planilha via web service. O tipo/categoria do recurso não deverá ser digitado pelo usuário, mas sim escolhido entre as opções lidas da aba 'category' da planilha e apresentadas na interface gráfica. 

3. O programa deverá permitir alguma forma de **busca** de recursos na planilha (usando pelo menos uma das opções do web service) e exibição dos dados em uma tabela na interface gráfica. 

4. O programa deverá ter tratamento de **exceções** que podem ocorrer, principalmente, quando a comunicação pela rede não for possível. Você pode forçar isso, por exemplo, usando uma URL inválida para o web service.

5. Você deverá usar seu programa para incluir **pelo menos 5 recursos** na planilha, com seu userId.

## Requisitos adicionais 
---
Para ir além do mínimo, implemente pelo menos um requisito adicional que não esteja na lista anterior e que amplie sua experiência. Por exemplo:

1. Implemente um 'login' no seu programa para não precisar digitar o userId a cada inclusão de recurso. Esse userId pode ou não ser validado junto ao GitHub. Uma vez feito o login, todos os recursos inseridos terão o userId preenchido por default. 

2. Amplie as opções de busca de recursos, usando o web service ou implementando alguma filtragem sobre os dados lidos da planilha.

3. Implemente a busca de recursos em uma nova thread, para evitar bloqueio da interface gráfica caso haja delay na comunicação de dados. 

4. Na tabela de exibição dos recursos, implemente a possibilidade de selecionar um recurso e abrir o navegador default para acessar sua URL.



## Orientações gerais
---

1. Faça o trabalho incrementalmente, sem tentar resolver todos os requisitos de uma vez só. Comece aproveitando os exemplos fornecidos nas práticas, adaptando-os ao novo contexto.


2. Lembre-se que você está exercitando POO e por isso seu código deverá ser distribuído em várias classes, cada uma com sua "responsabilidade". 

3. No primeiro trabalho, as classes `Language` e `LanguageRepository` estavam prontas. Elas foram implementadas de acordo com o web service que executa na nuvem Google. Agora, você vai ter que implementar as classes que fazem as operações com `resource` e `category`, usando como referência a documentação do web service mais abaixo. Lembre-se que você não precisa entender de programação web, apenas identificar o que muda de uma requisição para outra!

4. Lembre-se que as classes podem se relacionar de diferentes formas. Quando uma classe precisar de acesso a um objeto de outra classe, ela poderá criar o objeto ou receber uma referência para ele. Isso é particularmente importante na implementação da interface gráfica.


5. Reserve tempo para refatorar seu código e fazê-lo evoluir em organização/legibilidade de uma versão para outra.




 


## Web service
---
Assim como no primeiro trabalho, o acesso à planilha que armazena os dados se dá por meio de requisições Web.

As requisições implementadas só realizam inclusões e leituras, sem a possibilidade de alterações e exclusões. Para facilitar testes, todas as requisições Web podem ser enviadas via navegador.

### URL do web service

Todas as requisições devem ser enviadas a esta URL, à qual são adicionados parâmetros que indicam operações e dados (ver tabelas adiante):
```
https://script.google.com/macros/s/AKfycbxFHJM5G11Wc4SRwl4Gh3VKun9_QzlfmFAthGI0rihrbd9maY3c3nb8XFaE020HMYQc/exec?
```

### Operações

| Operação | Parâmetro 'action' |
|----------|---------|
| Obter categorias | action=getCategories | 
| Incluir recurso | action=postResource |
| Obter todos recursos | action=getResources |
| Obter recursos por linguagem | action=getResourcesByLanguage |
| Obter recursos por categoria | action=getResourcesByCategory |


| Action   | getCategories  |
|------------|-----------|
| Parâmetros | nenhum  |
| Exemplo    |   https://script.google.com/macros/s/AKfycbxFHJM5G11Wc4SRwl4Gh3VKun9_QzlfmFAthGI0rihrbd9maY3c3nb8XFaE020HMYQc/exec?action=getCategories        |
| Resposta   | JSON contendo array de objetos com atributos `category` (nome da categoria) e `description` (descrição da categoria):   `{"success":true,"objects":[{"category":"single page tutorial","description":"tutorial curto com explicações e exemplos"}]}`          |



| Action   | postResource  |
|------------|-----------|
| Parâmetros |  url=`text`&languageId=`text`&tags=`text`&category=`text`&comment=`text`&userId=`text`
| Exemplo    |   https://script.google.com/macros/s/AKfycbxFHJM5G11Wc4SRwl4Gh3VKun9_QzlfmFAthGI0rihrbd9maY3c3nb8XFaE020HMYQc/exec?action=postResource&url=https%3A%2F%2Fwww.baeldung.com%2Fjava-this&languageId=java&tags=keyword%3B+this&category=single+page+tutorial&comment=Explica%C3%A7%C3%A3o+sobre+5+situa%C3%A7%C3%B5es+de+uso+da+keyword+this&userId=andreainfufsm        |
| Resposta           | `{"success":true,"message":"Resource added: url}` |
| Erros | `{"success":false,"message":"Missing request parameter"}` ou `{"success":false,"message":"Language not found"}` ou `{"success":false,"message":"Category not found"}` | 

| Action   | getResources |
|------------|-----------|
| Parâmetros | nenhum  |
| Exemplo    |   https://script.google.com/macros/s/AKfycbxFHJM5G11Wc4SRwl4Gh3VKun9_QzlfmFAthGI0rihrbd9maY3c3nb8XFaE020HMYQc/exec?action=getResources
| Resposta   | JSON contendo array de objetos com atributos `url`, `languageId`, `tags`, `category`, `comment` e `userId`: `{"success":true,"objects":[{"url":"https://www.baeldung.com/java-this","languageId":"java","tags":"keyword; this","category":"single page tutorial","comment":"Explicação sobre 5 situações de uso da keyword this","userId":"andreainfufsm"}]}`          |

| Action   | getResourcesByLanguage |
|------------|-----------|
| Parâmetros | languageId=`text`  |
| Exemplo    |   https://script.google.com/macros/s/AKfycbxFHJM5G11Wc4SRwl4Gh3VKun9_QzlfmFAthGI0rihrbd9maY3c3nb8XFaE020HMYQc/exec?action=getResourcesByLanguage&languageId=java
| Resposta   | JSON contendo array de objetos com atributos `url`, `languageId`, `tags`, `category`, `comment` e `userId`: `{"success":true,"objects":[{"url":"https://www.baeldung.com/java-this","languageId":"java","tags":"keyword; this","category":"single page tutorial","comment":"Explicação sobre 5 situações de uso da keyword this","userId":"andreainfufsm"}]}`          |
| Erros | `{"success":false,"message":"Missing request parameter"}` ou `{"success":false,"message":"Language not found"}`  | 


| Action   | getResourcesByCategory |
|------------|-----------|
| Parâmetros | category=`text`  |
| Exemplo    |   https://script.google.com/macros/s/AKfycbxFHJM5G11Wc4SRwl4Gh3VKun9_QzlfmFAthGI0rihrbd9maY3c3nb8XFaE020HMYQc/exec?action=getResourcesByCategory&category=cheatsheet
| Resposta   | JSON contendo array de objetos com atributos `url`, `languageId`, `tags`, `category`, `comment` e `userId`: `{"success":true,"objects":[{"url":"https://www.edureka.co/blog/cheatsheets/java-oop-cheat-sheet/","languageId":"java","tags":"object oriented ","category":"cheatsheet","comment":"Resumo com conceitos e exemplos de POO em Java","userId":"andreainfufsm"}]}`          |
| Erros | `{"success":false,"message":"Missing request parameter"}` ou `{"success":false,"message":"Language not found"}`  | 





