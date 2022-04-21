import java.util.Vector;


public class Teste {
  public static void main(String[] args){
    Vector<Disciplina> lista_de_disciplinas = new Vector<Disciplina> ();
    lista_de_disciplinas = Disciplinas_2019.leDisciplinas("TAP_Disciplinas_2019.csv");
    for (int i = 0; i < lista_de_disciplinas.size(); i++){
      System.out.println(lista_de_disciplinas.get(i));
    }

  }
  
}
