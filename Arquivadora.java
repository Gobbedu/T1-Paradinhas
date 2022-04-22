import java.util.Vector;


public class Arquivadora {
  private Vector<Disciplina> lista_de_disciplinas2019 = new Vector<Disciplina> ();
  private Vector<Disciplina> lista_de_disciplinas2011 = new Vector<Disciplina> ();
  private Vector<Aluno> lista_de_alunos =  new Vector<Aluno> ();

  public Arquivadora() {
    this.lista_de_disciplinas2019 = Leitura_Disciplinas.leDisciplinas("TAP_Disciplinas_2019.csv");
    //this.lista_de_disciplinas2011 = Leitura_Disciplinas.leDisciplinas("TAP_Disciplinas_2011.csv");
    this.lista_de_alunos = Leitura_Disciplinas.leAluno("TAP_historico.csv");
  }

  public Vector<Disciplina> getLista_de_disciplinas2019() {
    return this.lista_de_disciplinas2019;
  }

  public Vector<Disciplina> getLista_de_disciplinas2011() {
    return this.lista_de_disciplinas2011;
  }

  public Vector<Aluno> getLista_de_alunos() {
    return this.lista_de_alunos;
  }
}
