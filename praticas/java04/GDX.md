# Respostas

## Afazer 1

- [x] Feito!
- [x] Surgiram dúvidas aqui

Classe definida em `DesktopLauncher.java`: `DesktopLauncher`

Classe definida em `Drop.java`: `Drop`

## Afazer 3

- [x] Feito!

Na classe `Drop`.

## Afazer 4

- [x] Feito!

```java
private Texture dropImage; // Representa a imagem da gota
private Array<Rectangle> raindrops; // Representa um as gotas. Mais especificamente coordenadas de gotas.
```

## Afazer 5

- [x] Feito!

Provavelmente a visibilidade é do tipo `public`, caso contrário não seria possível acessar de forma direta o atributo `x` (há menos que a classe `Drop` fosse herdada da classe `Rectangle` e o atributo `x` fosse do tipo `protected`, o que não é o caso).

## Afazer 6

- [x] Feito!

É o nome de uma classe, pois a primeira letra de seu nome é maiúscula. Não é uma referência para um objeto pois não foi instanciado nenhum objeto previamente à chamada ao método `random`. Ele, por sua vez, é `static`, já que não precisa ser chamado em um objeto instanciado.

## Afazer 7

- [x] Feito!

Porque o atributo `lastDropTime` pertence à classe `Drop`, assim como o método `spawnRaindrop`, então "todo mundo se conhece".

## Afazer 8

- [x] Feito!

A classe `Drop` está herdando atributos e métodos da classe `ApplicationAdapter`. Por exemplo, a classe `Drop` sobrepõe o método `render` (provavelmente herdado pela classe `ApplicationAdapter`) com sua própria implementação, para satisfazer as necessidades daquele contexto.
