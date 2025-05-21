# ProcessManager


## Descrição

---

O problema proposto é uma simulação de execução de um pool de processos. O pool consiste em numa fila (deve ser
implementada com array) de processos que é incrementada pelo usuário e que serão executados num segundo
momento, também por opção do usuário.
Os processos são inseridos pelo usuário um-a-um e sempre no final da fila dos processos (portanto, na próxima posição
livre do array). Os processos também devem ser executados na ordem em que foram cadastrados, a menos que o
usuário solicite um específico pelo seu pid. Neste caso, portanto, um processo pode ser executado antes do que o
próximo a ser executado de direito. Quando isto acontece os demais processos, sucessores do escolhido devem
“andar” uma posição a frente no array.
Existem 4 tipos específicos de processos. Cada tipo implementa um algoritmo para execução. Eles são especializados
nos seguintes tipos: processo de gravação, processo de leitura, processo de impressão e processo de cálculo. Veja
abaixo o que deve ser executado no método executar de cada tipo.
Quanto aos atributos, todo processo (na sua forma mais geral) possui um pid e tem o método execute(). A superclasse
processo não deve implementar o execute() apenas deve declará-la. Cada subclasse específica de processo deve fazer
a sua implementação do método execute().
  - Processo de cálculo (ComputingProcess): executa o cálculo de uma expressão e imprime o resultado do cálculo.
Uma expressão é formada por dois operandos e uma operação (que pode ser +, -, * ou /). A expressão deve saber
como se executar. Por exemplo, se é uma soma, então o resultado do cálculo é a soma dos dois operandos.
  - Processo de gravação (WritingProcess): executa a gravação de uma expressão em um arquivo de processos
(chamado computation.txt). Note que, se já existem expressões gravadas no arquivo, o processo de gravação não
deve sobrescrevê-las.
  - Processo de leitura (ReadingProcess): deve ler completamente o arquivo de computações (computation.txt) e,
para cada registro lido do arquivo deve criar um objeto de processo de cálculo (ComputingProcess) e adicioná-lo
na lista de processos do sistema. Ao final da leitura, o processo deve “limpar” o arquivo. Vale lembrar que cada
linha do arquivo é uma expressão aritmética.
  - Processo de impressão (PrintingProcess): tem por objetivo simplesmente imprimir na tela o pool de processos a
serem executados. Imprimindo o pid, o tipo do processo e atributos relacionados, se for o caso.

---

## Atividades que devem ser implementadas no trabalho:
- Implementar as classes relacionadas a processo.
- Implementar as seguintes opções de menu do sistema:
  - **Criar processo:** permite ao usuário criar um processo de um dos quatro tipos específicos. Portanto, deve
solicitar ao usuário o tipo de processo a ser criado e os dados necessários para tipo de processo. Por exemplo,
para um processo do ComputingProcess, deve ser lida e montada a expressão a ser executada. Esta opção do
sistema apenas cria um objeto e o adiciona no final do array.
  - **Executar próximo:** executa o próximo processo na ordem em que foram criados. Deve também remover o
processo executado e atualizar a lista. Portanto, executar sempre o processo do índice zero do array (o
primeiro), depois de executado removê-lo e, por fim, trazer os sucessores uma posição a frente no array de
processos.
  -  **Executar processo específico:** deve solicitar ao usuário o pid do processo a ser executado, procura o processo
pelo pid informado e, caso tenha encontrado, executa este processo mesmo que ele não seja o primeiro da
fila/array. Após a execução o processo deve ser removido e os seus sucessores devem ocupar uma posição a
frente no array.
  - **Salvar a fila de processos:** salvar em arquivo o estado atual da fila de processos em Arquivo.
  - **Carregar do arquivo a fila de processos:** inicializar o sistema com um array de processos do arquivo.
---
