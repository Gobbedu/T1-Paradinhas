import java.io.File;
import java.util.Vector;
import java.io.IOException;
import java.util.Scanner;

//Classe contendo os métodos de leitura de arquivos e geração dos valores armazenados na arquivadora
public class Leitura_Disciplinas {
  //Le as disciplinas de um arquivo csv e armazena num Vector
  public static Vector<Disciplina> leDisciplinas(String arquivo) {
    Vector<Disciplina> lista_de_Disciplinas = new Vector<Disciplina>(); //Cria uma lista de objetos da classe Disciplinas
    File arquivo_Disciplinas = new File("dados/" + arquivo);
    try {
      Scanner usuario = new Scanner(arquivo_Disciplinas);
      usuario.nextLine();
      usuario.nextLine();

      usuario.useDelimiter(";");                      //Usa ; como limitador para se mover

      while (usuario.hasNext()) {
        Disciplina materia = new Disciplina();
        materia.setCOD_CURSO(usuario.next());
        materia.setNUM_VERSAO(usuario.next());
        materia.setDESCR_ESTRUTURA(usuario.next());
        materia.setCOD_DISCIPLINA(usuario.next());
        materia.setNOME_UNIDADE(usuario.next());
        materia.setNOME_DISCIPLINA(usuario.next());
        materia.setPERIODO_IDEAL(usuario.next());
        materia.setNUM_HORAS(usuario.next());
        materia.setTIPO_DISCIPLINA(usuario.next());
        materia.setCH_TOTAL(usuario.next());
        materia.setDESCR_SITUACAO(usuario.next());
        usuario.nextLine();
        lista_de_Disciplinas.add(materia);            //Adiciona a matéria no Vector de disciplinas.
      }
      usuario.close();
      return lista_de_Disciplinas;
    } catch (IOException e) {
      System.out.println("Erro ao ler o arquivo");
      e.printStackTrace();
      return lista_de_Disciplinas;
    }
  }

  //Método respons[avel por ler o arquivo de histórico, gerar um aluno com os atributos preenchidos e retorna-lo
  public static Aluno leAluno(String arquivo) {
    Aluno id = new Aluno();
    Vector<Disciplinas_Cursadas> lista_Disc_Cursadas = new Vector<Disciplinas_Cursadas>();  //Lista de disciplinas cursadas
    File arquivo_Historico = new File("dados/" + arquivo);

    try {
      Scanner usuario = new Scanner(arquivo_Historico);
      usuario.nextLine();
      usuario.nextLine();
      usuario.useDelimiter(";");                                   //Usa ; como limitador para se mover

      while (usuario.hasNext()) {
        id.setGRR(usuario.next());                                 //Le o nome do Aluno e armazena
        id.setNOME(usuario.next());                                //Le o GRR do aluno e armazena
        Disciplinas_Cursadas materia = new Disciplinas_Cursadas();
        materia.setCOD_CURSO(usuario.next());
        materia.setNOME_CURSO(usuario.next());
        materia.setNUM_VERSAO(usuario.next());
        materia.setANO(usuario.next());
        materia.setMEDIA_FINAL(usuario.next());
        materia.setSITUACAO_ITEM(usuario.next());
        materia.setPERIODO(usuario.next());
        materia.setSITUACAO(usuario.next());
        materia.setCOD_ATIV_CURRIC(usuario.next());
        materia.setNOME_ATIV_CURRIC(usuario.next());
        materia.setCH_TOTAL(usuario.next());
        materia.setDESCR_ESTRUTURA(usuario.next());
        materia.setFREQUENCIA(usuario.next());
        materia.setSIGLA(usuario.next());
        lista_Disc_Cursadas.add(materia);                         //Adiciona a matéria na lista de objetos da classe Disciplinas_Cursadas
        usuario.nextLine();
      }
      id.setHistorico(lista_Disc_Cursadas);
      usuario.close();
      int n = id.getHistorico().size();
      //Seta o período atual e o armazena em Aluno
      String periodo_atual = id.getHistorico().get(n-1).getPERIODO();
      if(periodo_atual.equals("1o. Semestre"))
        id.setPeriodo_atual(1);
      else
        id.setPeriodo_atual(2);
      return id;
    } catch (IOException e) {
      System.out.println("Erro ao ler o arquivo");
      e.printStackTrace();
      return id;
    }
  }

  //Método responsável por criar a lista de disciplinas da barreira, retorna uma lista para Arquivadora
  public static Vector<Disciplina> geraBarreira(Vector<Disciplina> Disciplinas_2019) {
    Vector<Disciplina> disciplinas_barreira = new Vector<Disciplina>();
    int n = Disciplinas_2019.size();
    for (int i = 0; i < n; i++) {
      Disciplina candidato = new Disciplina();
      candidato = Disciplinas_2019.get(i);
      //Compara para ver se a diciplina da iteração pertence a um dos 3 primeiros períodos
      if ((candidato.getPERIODO_IDEAL().equals("1")) || (candidato.getPERIODO_IDEAL().equals("2"))
          || (candidato.getPERIODO_IDEAL().equals("3"))) {
        disciplinas_barreira.add(candidato);
      }
    }
    return disciplinas_barreira;
  }

  public static Vector<Disciplina> geraBarreira_Aluno(Vector<Disciplina> disciplinas_barreira,
      Vector<Disciplinas_Cursadas> historico) {
    Vector<Disciplina> barreira_aluno = new Vector<Disciplina>();
    int n = disciplinas_barreira.size();
    int cursou = 0;
    int k = historico.size();
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < k; j++)
        if (disciplinas_barreira.get(i).getCOD_DISCIPLINA().equals(historico.get(j).getCOD_ATIV_CURRIC())) {
          cursou = 1;
          if (!(historico.get(j).getSITUACAO().equals("Aprovado")))
            cursou = 0;
        }
      if (cursou == 0)
        barreira_aluno.add(disciplinas_barreira.get(i));
      else
        cursou = 0;
    }
    return barreira_aluno;
  }

  //Metodo responsável por gerar e armazenar os dados do último semestre em Aluno
  public static void geraDados_semestre(Aluno aluno) {
    int n = aluno.getHistorico().size();
    int ano;
    int ano_i;
    String semestre_anterior;
    int aprovacao = 0;
    int total = 0;
    int reprov_falta = 0;

    //Seta qual foi o ultimo período cursado, se baseia no período de matrícula atual
    ano = Integer.parseInt(aluno.getHistorico().get(n - 1).getANO());
    if (aluno.getHistorico().get(n - 1).getPERIODO().equals("1o. Semestre")) {
      semestre_anterior = "2o. Semestre";
      ano--;
    } else
      semestre_anterior = "1o. Semestre";

    //Conta as disciplinas cursadas no semestre anterior, vendo qual foi aprovada e quais não
    for (int i = 0; i < n; i++) {
      ano_i = Integer.parseInt(aluno.getHistorico().get(i).getANO());
      if ((ano_i == ano) && (aluno.getHistorico().get(i).getPERIODO().equals(semestre_anterior))) {
        total++;
        if (aluno.getHistorico().get(i).getSITUACAO().equals("Aprovado"))
          aprovacao++;
        if (aluno.getHistorico().get(i).getSITUACAO().equals("Reprovado por Frequencia"))
          reprov_falta++;
      }
    }

    aluno.setPorc_aprovacao((aprovacao * 100) / total);
    aluno.setReprov_falta(reprov_falta);
  }

  //Método responsável por gerar uma lista de disciplinas pares pós-barreira para matrícula
  public static Vector<Disciplina> geraDisc_pares(Vector<Disciplina> disciplinas_2019, 
      Vector<Disciplinas_Cursadas> historico)
  {
    Vector<Disciplina> disciplinas_pares = new Vector<Disciplina>();
    int n = disciplinas_2019.size();
    for (int i = 0; i < n; i++) {
      Disciplina candidato = new Disciplina();
      candidato = disciplinas_2019.get(i);
      int periodo = Integer. parseInt(disciplinas_2019.get(i).getPERIODO_IDEAL());
      if ((periodo%2 == 0) && (periodo > 3)){
        disciplinas_pares.add(candidato);
      }
    }
    remove_cursadas(disciplinas_pares, historico);
    return disciplinas_pares;
  }

  //Método responsável por gerar uma lista de disciplinas pares pós-barreira para matrícula
  public static Vector<Disciplina> geraDisc_impares(Vector<Disciplina> disciplinas_2019,
      Vector<Disciplinas_Cursadas> historico)
  {
    Vector<Disciplina> disciplinas_impares = new Vector<Disciplina>();
    int n = disciplinas_2019.size();
    for (int i = 0; i < n; i++) {
      Disciplina candidato = new Disciplina();
      candidato = disciplinas_2019.get(i);
      int periodo = Integer.parseInt(disciplinas_2019.get(i).getPERIODO_IDEAL());
      if ((periodo%2 != 0) && (periodo > 3)){
        disciplinas_impares.add(candidato);
      }
    }
    remove_cursadas(disciplinas_impares, historico);
    return disciplinas_impares;
  }

  //Método auxiliar a geraDisc_impares e geraDisc_pares, esse método remove da lista as matérias que já foram cursadas
  //para que assim não exista a possibilidade de se matricular nela denovo
  public static void remove_cursadas(Vector<Disciplina> disciplinas, Vector<Disciplinas_Cursadas> historico){
    for(int i = 0; i < historico.size(); i++){
      int periodo = Integer.parseInt(historico.get(i).getSITUACAO_ITEM());
      if(periodo >= 4)
        for(int j = 0; j < disciplinas.size(); j++)
          if(disciplinas.get(j).getCOD_DISCIPLINA().equals(historico.get(i).getCOD_ATIV_CURRIC()))
            disciplinas.remove(j);
    }
  }

  

}
