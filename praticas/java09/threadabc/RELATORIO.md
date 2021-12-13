# Relatório

## Resumo

Foi necessário adicionar a keyword `synchronized` na declaração do método `addChar` da classe `SharedArray`, já que existem três threads que agem sobre o objeto (`array`), podendo causar conflitos e produzir resultados incorretos.

## Detalhado

### 1. Identificar o que está sendo compartilhado entre as threads do programa

O objeto `array` da classe `SharedArray` está sendo compartilhado entre três threads da classe `ArrayWriter`.

### 2. Identificar qual(is) método(s) do objeto compartilhado pode(m) causar problemas (seções críticas)

O método `addChar` da classe `SharedArray` é o único que está sendo utilizado pelo método `run` das threads.

### 3. Usar `synchronized`

- `public synchronized void addChar(char c) {}`

- A keyword `synchronized` aplicada na declaração de um método faz com que a thread que está executando aquele método sobre o objeto compartilhado termine sua execução antes que outra thread inicie uma operação sobre o mesmo.
