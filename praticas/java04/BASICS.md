# Respostas

## Afazer 1

- [x] Feito!

Abaixo segue a minha explicação do que acontece quando o método `main` é executado.

- Linha 31: o construtor da classe `Person` é chamado e é mostrado "Construtor de Person"; o atributo `name` é inicializado com "Fulano".

- Linha 32: o construtor herdado da classe `Person` pela classe `Student` é chamado e é mostrado "Construtor de Person", além de inicializar o atributo `name` com "Fulano"; em seguida, o próprio construtor da classe `Student` é chamado, mostrando "Construtor de Student".

- Linhas 34 e 35: `p` é adicionado na lista, seguido por `s`.

- Linha 36: o campo `name` da classe `Student` (herdado da classe `Person`) é alterado para "Beltrano".

- Linha 37 a 39: o campo `name` dos objetos adicionados na lista é mostrado; primeiro o de `p`, depois o de `s`.

### Output esperado por mim

Eu acabei analisando apenas o método `main`, sem perceber que os construtores também mostravam uma mensagem. Só me dei conta depois que rodei o programa, então o que eu esperava era:

```java
Fulano
Beltrano
```

### Output real

```java
Construtor de Person
Construtor de Person
Construtor de Student
Fulano
Beltrano
```

## Afazer 2

- [x] Feito!

## Afazer 3

- [x] Feito!

O compilador não reconhece a existência de um atributo chamado `name` na classe `Student`, porque ele não está visível no escopo em que está sendo utilizado. O correto seria utilizar o método `setter` (`getName`) herdado da classe `Person` para acessar o atributo `name` ou, ainda, alterar o modificador do atributo `name` para `protected`, ao invés de `private`.

A classe `Student` não tem como acessar o atributo herdado de forma direta, apenas a classe `Person` tem esse direito, pois é a classe "pai".

## Afazer 4

- [x] Feito!

Com essa mudança, o código executa normalmente. Isso porque o modificador `protected` permite que um atributo declarado em uma classe "pai" seja acessado diretamente pela classe "filho".

## Afazer 5

- [x] Feito!

## Afazer 6

- [x] Feito!

## Afazer 7

- [x] Feito!

Em `new PhdStudent()`, a ordem de chamada de construtores é a seguinte:

1. `Person()`;
2. `Student()`;
3. `PhdStudent()`.

## Afazer 8

- [x] Feito!

O método `equals` da classe `Object` retorna `true` caso o objeto em que o método foi chamado e outro objeto passado por parâmetro representarem o mesmo objeto na memória.

Já o método `getClass` da classe `Object` retorna a classe do objeto em que o método foi chamado.
