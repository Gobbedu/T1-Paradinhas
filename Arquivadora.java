import java.util.Vector;

//Classe que serve como controle do programa. Chama outros métodos e armazena as informações com objetos das classes
public class Arquivadora {
  
  private static Arquivadora InstanciaSingleton;
  private Vector<Disciplina> lista_de_disciplinas2019;
  private Vector<Disciplina> disciplinas_pares;       //Disciplinas pares pós barreira ofertadas
  private Vector<Disciplina> disciplinas_impares;     //Disciplinas impares pós barreira ofertadas
  private Vector<Disciplina> disciplinas_barreira;
  private Vector<Disciplina> disciplinas_solicitadas;
  private Aluno aluno;

  //Construtor da classe, chama métodos de outras classes para acessar os dados e construir os atributos
  private Arquivadora(String grr) {
    this.lista_de_disciplinas2019 = Leitura_Disciplinas.leDisciplinas("TAP_Disciplinas_2019.csv");
    this.aluno = Leitura_Disciplinas.leAluno(grr+"_historico.csv");     //Inicializa o aluno preenchendo o histórico e outras informações
    this.disciplinas_barreira = Leitura_Disciplinas.geraBarreira(this.lista_de_disciplinas2019);
    this.disciplinas_pares = Leitura_Disciplinas.geraDisc_pares(this.lista_de_disciplinas2019, this.aluno.getHistorico());
    this.disciplinas_impares = Leitura_Disciplinas.geraDisc_impares(this.lista_de_disciplinas2019, this.aluno.getHistorico());
    this.aluno.setBarreira(Leitura_Disciplinas.geraBarreira_Aluno(this.disciplinas_barreira, this.aluno.getHistorico()));
    Leitura_Disciplinas.geraDados_semestre(this.aluno);
    disciplinas_solicitadas=new Vector<Disciplina>();
  }

  //Implementação do padrão singleton, garante que a classe seja iniciada apenas uma vez na execução
  public static Arquivadora getUnica(String grr){
    if(InstanciaSingleton==null){
      InstanciaSingleton = new Arquivadora(grr);
    }
    return InstanciaSingleton;      
  }

  //Métodos para acessar os atributos privados da classe
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
