import java.io.File;
import java.util.Vector;
import java.io.IOException;
import java.util.Scanner;

public class Leitura_Disciplinas{

  public static Vector<Disciplina> leDisciplinas(String arquivo){
    Vector<Disciplina> lista_de_Disciplinas = new Vector<Disciplina>();
    File arquivo_Disciplinas = new File("dados/"+arquivo);
    try{
      Scanner usuario = new Scanner (arquivo_Disciplinas);
      usuario.nextLine();
      usuario.nextLine();

      usuario.useDelimiter(";");

      while(usuario.hasNext()){
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
        lista_de_Disciplinas.add(materia);
      }
      usuario.close();
      return lista_de_Disciplinas;
    }
    catch(IOException e){
      System.out.println("Erro ao ler o arquivo");
      e.printStackTrace();
      return lista_de_Disciplinas;
    }
  }

  public static Aluno leAluno(String arquivo){
    Aluno id = new Aluno();
    Vector<Disciplinas_Cursadas> lista_Disc_Cursadas = new Vector<Disciplinas_Cursadas>();
    File arquivo_Historico = new File("dados/"+arquivo);

    try{
      Scanner usuario = new Scanner(arquivo_Historico);
      usuario.nextLine();
      usuario.nextLine();
      usuario.useDelimiter(";");

      while (usuario.hasNext()){ 
        id.setGRR(usuario.next());
        id.setNOME(usuario.next());
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
        lista_Disc_Cursadas.add(materia);
        usuario.nextLine();
      }
      id.setHistorico(lista_Disc_Cursadas);
      usuario.close();
      return id;
    }
    catch(IOException e){
      System.out.println("Erro ao ler o arquivo");
      e.printStackTrace();
      return id;
    }
  }

  public static Vector<Disciplina> geraBarreira(Vector<Disciplina> Disciplinas_2019){
    Vector<Disciplina> disciplinas_barreira = new Vector<Disciplina> ();
    int n = Disciplinas_2019.size();
    for (int i = 0; i < n; i++){
      Disciplina candidato = new Disciplina();
      candidato = Disciplinas_2019.get(i);
      if((candidato.getPERIODO_IDEAL().equals("1"))||(candidato.getPERIODO_IDEAL().equals("2"))||(candidato.getPERIODO_IDEAL().equals("3"))){
        disciplinas_barreira.add(candidato);
      }
    }
    return disciplinas_barreira;
  }

  public static Vector<Disciplina> geraBarreira_Aluno(Vector <Disciplina> disciplinas_barreira, Vector <Disciplinas_Cursadas> historico){
    Vector<Disciplina> barreira_aluno = new Vector<Disciplina> ();
    int n = disciplinas_barreira.size();
    int cursou=0;
    int k = historico.size();
    for(int i = 0; i < n; i++){
      for(int j = 0; j < k; j++){
        if((disciplinas_barreira.get(i).getCOD_DISCIPLINA().equals(historico.get(j).getCOD_ATIV_CURRIC())))
          cursou=1;
      }
      if(cursou==0)
        barreira_aluno.add(disciplinas_barreira.get(i));
      else
        cursou=0;
    }
    return barreira_aluno;
  }
}
