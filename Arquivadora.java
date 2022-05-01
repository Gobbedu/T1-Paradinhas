import java.util.Vector;


public class Arquivadora {
  
  private static Arquivadora InstanciaSingleton;
  private Vector<Disciplina> lista_de_disciplinas2019 = new Vector<Disciplina> ();
  private Vector<Disciplina> disciplinas_barreira = new Vector<Disciplina> ();
  private Aluno aluno =  new Aluno ();

  private Arquivadora() {
    this.lista_de_disciplinas2019 = Leitura_Disciplinas.leDisciplinas("TAP_Disciplinas_2019.csv");
    this.aluno = Leitura_Disciplinas.leAluno("TAP_historico.csv");
    this.disciplinas_barreira = Leitura_Disciplinas.geraBarreira(this.lista_de_disciplinas2019);
    this.aluno.setBarreira(Leitura_Disciplinas.geraBarreira_Aluno(this.disciplinas_barreira, this.aluno.getHistorico()));
  }

  public static Arquivadora getUnica(){
    if(InstanciaSingleton==null){
      InstanciaSingleton = new Arquivadora();
    }
    return InstanciaSingleton;      
  }

  public Vector<Disciplina> getLista_de_disciplinas2019() {
    return this.lista_de_disciplinas2019;
  }

  public Aluno getAluno() {
    return this.aluno;
  }

  public Vector<Disciplina> getDisciplinas_Barreira(){
    return this.disciplinas_barreira;
  }

  
}
