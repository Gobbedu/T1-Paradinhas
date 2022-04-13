## Trabalho 1 de Paradigmas de programação 

## Login
Rode `git clone git@github.com:Gobbedu/T1-Paradinhas.git` com verificação ssh,
coloca um X dentro dos [ ] no seu nome em `README.md` e testa os comando a baixo. 
(vamo ter q fazer isso direto pra ir salvando oq cada um fez)

-   `git commit -am "eu fiz login"`  salva as mudancas que vc fez

-   `git pull` puxa oq tem no github (resolve os conflito no vscode)

-   `git push` empurra oq foi mudado pro github


- [ ] Dante
- [x] Ackermann
- [X] Anderson
- [ ] Vitoria
- [X] Gobbo 


### Objetivos:
Desenvolver um software, usando o paradigma de programação orientada a objetos, seu principais con-
ceitos e uma linguagem de programação orientada a objetos, no caso, Java.
### Descrição:
O software a ser desenvolvido terá como descrição um dos temas colocados a seguir. Cada equipe deverá 
escolher um dos temas e implementá-lo. No caso de dúvidas, procurar o professor da disciplina para
resolvê-lo.

## To Do
- [ ] Aluno obtem as suas informações do histórico importando um arquivo .CSV
- [ ] Importar dados sobre as disciplinas (disponibilidade no semestre e na grade curricular), em arquivo .CSV
- [ ] O sistema deverá colocar estes dados em uma lista com as matérias cursadas e uma lista das matérias do curso
- [ ] Apresentar uma tabela com as matérias cursadas por período e asmatérias que faltam cursar para a barreira
- [ ] Apresentar dados de aprovação do último período, como porcentagem de aprovação e quantas matérias reprovou por falta
- [ ] Mostra ao aluno o conjunto de disciplinas ofertadas neste semestre que não foram cursadas neste semestre por ordem de período
- [ ] Aluno seleciona um conjunto de disciplinas que ele deseja cursar, com informação sobre a prioridade delas
- [ ] O sistema devera calcular o número de disciplinas sugerido pelas regras aprovadas em colegiado e mostrar este resultado
- [ ] Salvar os dados do pedido em um arquivo de forma a permitir que o aluno os edite posteriormente
- [ ] Ao selecionar enviar, gerar um arquivo de texto contendo os dados do pedido

# Sistema Pedido de quebra de barreira:
O sistema tem por objetivo auxiliar o aluno no seu pedido de quebra de barreira, verificar a situação do
aluno e gerar um arquivo texto com o pedido de quebra e seus dados.
O sistema deve permitir que o aluno obtenha as suas informações do histórico importando um arquivo
.CSV. Além disso, o sistema deverá importar dados sobre as disciplinas, sua disponibilidade no semestre
e a grade curricular, também de arquivo .CSV.
O sistema deverá colocar estes dados em uma lista com as matérias cursadas e uma lista das matérias 
do curso. O sistema deverá então apresentar uma tabela com as matérias cursadas por período e as
matérias que faltam cursar para a barreira. Além disso, o sistema deverá apresentar os dados de aprovação 
do último período como porcentagem de aprovação e quantas matérias reprovou por falta.
O sistema deverá mostra ao aluno o conjunto de disciplinas ofertadas neste semestre que não foram
cursadas neste semestre por ordem de período. O sistema deverá possibilitar que o aluno selecione um
conjunto de disciplinas que ele deseja cursar com informação sobre a prioridade delas.
O sistema devera calcular o número de disciplinas sugerido pelas regras aprovadas em colegiado e
mostrar este resultado. O sistema deve permitir salvar os dados do pedido em um arquivo de forma a
permitir que o aluno os edite posteriormente. Quando o aluno selecionar enviar, o sistema deverá gerar
um arquivo texto contendo os dados do pedido.

## Regras:
- O desenvolvimento e a entrega deverão seguir as seguintes regras:
- O software deverá ser feito em Java, seguindo os conceitos de orientação a objetos
- O software deverá compilar e rodar no ambiente do Dinf.
- O trabalho deverá compilar no Dinf (com Makefile ou eclipse) e gerar um arquivo .jar que será executado com o comando  `java -jar`
- O tipo de interface com o usuário é de escolha da equipe podendo ser modo texto ou gráfica.
- A entrega do trabalho será em 2 partes: os fontes juntamente com arquivo de descrição do trabalho
e make (ou projeto do eclipse);
- apresentação do trabalho para o professor com toda a equipe.
Avaliação:
O trabalho será avaliado pelos seguintes quesitos:
- Funciona (Compila, funciona e cumpre os requisitos) 50 pt
- Modularização e Padronização 30 pt
– DAO.
– padrões (Grasp e GOF).
– MVC.
- Interface 10 pt
- C´odigo em geral 10 pt

