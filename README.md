## Trabalho 1 de Paradigmas de programação 
Anderson Aparecido do Carmo Frasão GRR 20204069
Dante Eleutério dos Santos GRR 20206686
Eduardo Gobbo Willi Vasconcellos Gonçalves GRR 20203892
Erick Eckermann Cardoso GRR  20186075
Vitória Stavis de Araujo GRR 20200243


### Objetivos:
Desenvolver um software, usando o paradigma de programação orientada a objetos, seu principais con-
ceitos e uma linguagem de programação orientada a objetos, no caso, Java.

# Sistema Pedido de quebra de barreira:
O sistema tem por objetivo auxiliar o aluno no seu pedido de quebra de barreira, verificar a situação do
aluno e gerar um arquivo texto com o pedido de quebra e seus dados. 

## Sobre o Sistema
O sistema pede que o aluno insira seu GRR e realizará uma busca no seu banco de dados (diretório "dados") conferindo se encontra o respectivo
histórico. Caso positivo, irá ler esse histórico e mostrará ao usuário quais disciplinas ele já cursou, quais faltam ele cursar de dentro da 
barreira, o seu rendimento no último período e quantas disciplinas tem direito com base nele. Além disso mostrará quais disciplinas estão sendo
ofertadas nesse período e ele poderá escolher quais irá solicitar para apresentar ao colegiado, podendo escrever na tabela a ordem de prioridade
de cada uma. Ao clicar no botão "gerar pedido" , um arquivo texto chamado "PedidoDeQuebra.txt" será sobescrito no diretório "dados" e conterá o pedido de quebra do aluno.

#COMO TESTAR
Use o makefile para gerar o arquivo .jar e o execute com java -jar
    $ make
    $ java -jar QuebraDeBarreira.jar
    
OBS: Para o teste os arquivos devem do histórico e o arquivo de diciplinas devem estar na pasta dados, o arquivo do histórico tendo o nome da forma <numero GRR>_historico.csv
Use o GRR 41561234 como teste
IMPORTANTE: AO ESCREVER NA TABELA,CLIQUE EM QUALQUER OUTRA LINHA DA MESMA PARA GARANTIR QUE A ESCRITA SERÁ SALVA
