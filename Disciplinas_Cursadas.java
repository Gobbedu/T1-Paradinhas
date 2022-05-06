//Classe que armazena as informaçẽos de uma disciplina
public class Disciplinas_Cursadas{
    private String  COD_CURSO;
    private String  NOME_CURSO;
    private String  NUM_VERSAO;
    private String  ANO;
    private String  MEDIA_FINAL;
    private String  SITUACAO_ITEM;
    private String  PERIODO;
    private String  SITUACAO;
    private String  COD_ATIV_CURRIC;
    private String  NOME_ATIV_CURRIC;
    private String  CH_TOTAL;
    private String  DESCR_ESTRUTURA;
    private String  FREQUENCIA;
    private String  SIGLA;  

    //Construtor da classe
    public Disciplinas_Cursadas() {
    }

    //Métodos get e set para acesso de atributos
    public String getCOD_CURSO() {
        return this.COD_CURSO;
    }

    public void setCOD_CURSO(String COD_CURSO) {
        this.COD_CURSO = COD_CURSO;
    }

    public String getNOME_CURSO() {
        return this.NOME_CURSO;
    }

    public void setNOME_CURSO(String NOME_CURSO) {
        this.NOME_CURSO = NOME_CURSO;
    }

    public String getNUM_VERSAO() {
        return this.NUM_VERSAO;
    }

    public void setNUM_VERSAO(String NUM_VERSAO) {
        this.NUM_VERSAO = NUM_VERSAO;
    }

    public String getANO() {
        return this.ANO;
    }

    public void setANO(String ANO) {
        this.ANO = ANO;
    }

    public String getMEDIA_FINAL() {
        return this.MEDIA_FINAL;
    }

    public void setMEDIA_FINAL(String MEDIA_FINAL) {
        this.MEDIA_FINAL = MEDIA_FINAL;
    }

    public String getSITUACAO_ITEM() {
        return this.SITUACAO_ITEM;
    }

    public void setSITUACAO_ITEM(String SITUACAO_ITEM) {
        this.SITUACAO_ITEM = SITUACAO_ITEM;
    }

    public String getPERIODO() {
        return this.PERIODO;
    }

    public void setPERIODO(String PERIODO) {
        this.PERIODO = PERIODO;
    }

    public String getSITUACAO() {
        return this.SITUACAO;
    }

    public void setSITUACAO(String SITUACAO) {
        this.SITUACAO = SITUACAO;
    }

    public String getCOD_ATIV_CURRIC() {
        return this.COD_ATIV_CURRIC;
    }

    public void setCOD_ATIV_CURRIC(String COD_ATIV_CURRIC) {
        this.COD_ATIV_CURRIC = COD_ATIV_CURRIC;
    }

    public String getNOME_ATIV_CURRIC() {
        return this.NOME_ATIV_CURRIC;
    }

    public void setNOME_ATIV_CURRIC(String NOME_ATIV_CURRIC) {
        this.NOME_ATIV_CURRIC = NOME_ATIV_CURRIC;
    }

    public String getCH_TOTAL() {
        return this.CH_TOTAL;
    }

    public void setCH_TOTAL(String CH_TOTAL) {
        this.CH_TOTAL = CH_TOTAL;
    }

    public String getDESCR_ESTRUTURA() {
        return this.DESCR_ESTRUTURA;
    }

    public void setDESCR_ESTRUTURA(String DESCR_ESTRUTURA) {
        this.DESCR_ESTRUTURA = DESCR_ESTRUTURA;
    }

    public String getFREQUENCIA() {
        return this.FREQUENCIA;
    }

    public void setFREQUENCIA(String FREQUENCIA) {
        this.FREQUENCIA = FREQUENCIA;
    }

    public String getSIGLA() {
        return this.SIGLA;
    }

    public void setSIGLA(String SIGLA) {
        this.SIGLA = SIGLA;
    }

    public String toString() {
        return "{" +
            " COD_CURSO='" + getCOD_CURSO() + "'" +
            ", NOME_CURSO='" + getNOME_CURSO() + "'" +
            ", NUM_VERSAO='" + getNUM_VERSAO() + "'" +
            ", ANO='" + getANO() + "'" +
            ", MEDIA_FINAL='" + getMEDIA_FINAL() + "'" +
            ", SITUACAO_ITEM='" + getSITUACAO_ITEM() + "'" +
            ", PERIODO='" + getPERIODO() + "'" +
            ", SITUACAO='" + getSITUACAO() + "'" +
            ", COD_ATIV_CURRIC='" + getCOD_ATIV_CURRIC() + "'" +
            ", NOME_ATIV_CURRIC='" + getNOME_ATIV_CURRIC() + "'" +
            ", CH_TOTAL='" + getCH_TOTAL() + "'" +
            ", DESCR_ESTRUTURA='" + getDESCR_ESTRUTURA() + "'" +
            ", FREQUENCIA='" + getFREQUENCIA() + "'" +
            ", SIGLA='" + getSIGLA() + "'" +
            "}";
    }
}
