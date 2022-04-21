import java.io.File;
import java.util.Vector;
import java.io.IOException;
import java.util.Scanner;

public class Disciplinas_2019{

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
}