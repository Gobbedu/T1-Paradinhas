import java.util.Vector;
//import java.util.prefs.BackingStoreException;

public class Aluno{
    private String  GRR;
    private String  NOME;
    private Vector<Disciplinas_Cursadas> Historico = new Vector<Disciplinas_Cursadas> ();
    private Vector<Disciplina> barreira = new Vector<Disciplina> ();


    public Aluno() {
    }

    public Aluno(String GRR, String NOME, Vector<Disciplinas_Cursadas> Historico, Vector<Disciplina> barreira){
        this.GRR = GRR;
        this.NOME = NOME;
        this.Historico = Historico;
        this.barreira = barreira;
    }

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

    public String toString() {
        return "{" +
            " GRR='" + getGRR() + "'" +
            ", NOME='" + getNOME() + "'" +
            ", Historico='" + getHistorico() + "'" +
            ", barreira='" + getBarreira() + "'" +
            "}";
    }

}