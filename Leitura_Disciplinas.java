import java.io.File;
import java.util.Vector;
import java.io.IOException;
import java.util.Scanner;

public class Leitura_Disciplinas{

  public static Vector<Disciplina> leDisciplinas(String arquivo){
    Vector<Disciplina> lista_de_Disciplinas = new Vector<Disciplina>();
    File arquivo_Disciplinas = new File(arquivo);

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

  public static Vector<Aluno> leAluno(String arquivo){
    Vector<Aluno> lista_de_alunos = new Vector<Aluno>();
    Vector<Disciplinas_Cursadas> lista_Disc_Cursadas = new Vector<Disciplinas_Cursadas>();
    File arquivo_Historico = new File(arquivo);

    try{
      Scanner usuario = new Scanner (arquivo_Historico);
      usuario.nextLine();
      usuario.nextLine();
      usuario.useDelimiter(";");

      while(usuario.hasNext()){
        Aluno id = new Aluno();
        id.setGRR(usuario.next());
        id.setNOME(usuario.next());
        while (usuario.hasNext()){                                            //ver outro metodo de parada
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
          usuario.next();
          usuario.next();
          usuario.nextLine();
        }
        id.setHistorico(lista_Disc_Cursadas);
        lista_de_alunos.add(id);
      }
      usuario.close();
      return lista_de_alunos;
    }
    catch(IOException e){
      System.out.println("Erro ao ler o arquivo");
      e.printStackTrace();
      return lista_de_alunos;
    }
  }

}