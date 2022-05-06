import java.util.Vector;

//Classe que armazena o tipo Aluno e contém todas as informações
//do aluno coletadas no histórico
public class Aluno{
    private String  GRR;
    private String  NOME;
    private Vector<Disciplinas_Cursadas> Historico;
    private Vector<Disciplina> barreira;                //Armazena as disciplinas que faltam cursar na barreira
    private double porc_aprovacao;                      //Taxa de aprovação do último semestre       
    private int reprov_falta;   
    private int periodo_atual;      

    //Construtor
    public Aluno() {
    }

    //Metodos get e set para acessar atributos privados da classe
    public String getGRR() {
        return this.GRR;
    }

    public void setGRR(String GRR) {
        this.GRR = GRR;
    }

    public String getNOME() {
        return this.NOME;
    }

    public void setNOME(String NOME) {
        this.NOME = NOME;
    }

    public Vector<Disciplinas_Cursadas> getHistorico() {
        return this.Historico;
    }

    public void setHistorico(Vector<Disciplinas_Cursadas> Historico) {
        this.Historico = Historico;
    }

    public Vector<Disciplina> getBarreira() {
        return this.barreira;
    }

    public void setBarreira(Vector<Disciplina> barreira) {
        this.barreira = barreira;
    }

    public double getPorc_aprovacao() {
        return this.porc_aprovacao;
    }

    public void setPorc_aprovacao(double porc_aprovacao) {
        this.porc_aprovacao = porc_aprovacao;
    }

    public int getReprov_falta() {
        return this.reprov_falta;
    }

    public void setReprov_falta(int reprov_falta) {
        this.reprov_falta = reprov_falta;
    }

    public int getPeriodo_atual() {
        return this.periodo_atual;
    }

    public void setPeriodo_atual(int periodo_atual) {
        this.periodo_atual = periodo_atual;
    }

    //Trasforma as saídas em strings bem comportadas
    public String toString() {
        return "{" +
            " GRR='" + getGRR() + "'" +
            ", NOME='" + getNOME() + "'" +
            ", Historico='" + getHistorico() + "'" +
            ", barreira='" + getBarreira() + "'" +
            ", Porc_aprovacao='" + getPorc_aprovacao() + "'" +
            ", Reprov_falta='" + getReprov_falta() + "'" +
            ", Periodo_Atual='" + getPeriodo_atual() + "'" +

            "}";
    }

}