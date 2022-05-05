import java.util.Vector;


public class Arquivadora {
  
  private static Arquivadora InstanciaSingleton;
  private Vector<Disciplina> lista_de_disciplinas2019;
  private Vector<Disciplina> disciplinas_pares;
  private Vector<Disciplina> disciplinas_impares;
  private Vector<Disciplina> disciplinas_barreira;
  private Vector<Disciplina> disciplinas_solicitadas;
  private Aluno aluno;

  private Arquivadora(String grr) {
    this.lista_de_disciplinas2019 = Leitura_Disciplinas.leDisciplinas("TAP_Disciplinas_2019.csv");
    this.aluno = Leitura_Disciplinas.leAluno(grr+"_historico.csv");
    this.disciplinas_barreira = Leitura_Disciplinas.geraBarreira(this.lista_de_disciplinas2019);
    this.disciplinas_pares = Leitura_Disciplinas.geraDisc_pares(this.lista_de_disciplinas2019, this.aluno.getHistorico());
    this.disciplinas_impares = Leitura_Disciplinas.geraDisc_impares(this.lista_de_disciplinas2019, this.aluno.getHistorico());
    this.aluno.setBarreira(Leitura_Disciplinas.geraBarreira_Aluno(this.disciplinas_barreira, this.aluno.getHistorico()));
    Leitura_Disciplinas.geraDados_semestre(this.aluno);
    disciplinas_solicitadas=new Vector<Disciplina>();
  }

  public static Arquivadora getUnica(String grr){
    if(InstanciaSingleton==null){
      InstanciaSingleton = new Arquivadora(grr);
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

  public Vector<Disciplina> getDisciplinas_pares(){
    return this.disciplinas_pares;
  }

  public Vector<Disciplina> getDisciplinas_impares(){
    return this.disciplinas_impares;
  }
  
  public Vector<Disciplina> getDisciplinas_solicitas(){
    return this.disciplinas_solicitadas;
  }

  public void GeraPedido(Vector<String> nomes,Vector<Integer> prioridades){
    Solicitacao.GeraDisc_Solicitadas(this.disciplinas_solicitadas, nomes,this.lista_de_disciplinas2019);
    Solicitacao.GeraArquivo(nomes, prioridades,this.aluno);
    this.disciplinas_solicitadas.clear();
  }
}
