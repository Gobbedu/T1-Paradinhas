import java.util.Vector;

public class Aluno{
    private String  GRR;
    private String  NOME;
    private Vector<Disciplinas_Cursadas> Historico = new Vector<Disciplinas_Cursadas> ();


    public Aluno() {
    }

    public Aluno(String GRR, String NOME, Vector<Disciplinas_Cursadas> Historico) {
        this.GRR = GRR;
        this.NOME = NOME;
        this.Historico = Historico;
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

    public String toString() {
        return "{" +
            " GRR='" + getGRR() + "'" +
            ", NOME='" + getNOME() + "'" +
            ", Disciplinas_Cursadas='" + getHistorico() + "'" +
            "}";
    }

}