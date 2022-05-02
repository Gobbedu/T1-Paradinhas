public class Disciplina{
  private String COD_CURSO;
  private String NUM_VERSAO;
  private String DESCR_ESTRUTURA;
  private String COD_DISCIPLINA;
  private String NOME_UNIDADE;
  private String NOME_DISCIPLINA;
  private String PERIODO_IDEAL;
  private String NUM_HORAS;
  private String TIPO_DISCIPLINA;
  private String CH_TOTAL;
  private String DESCR_SITUACAO;


  public Disciplina() {
  }

  public String getCOD_CURSO() {
    return this.COD_CURSO;
  }

  public void setCOD_CURSO(String COD_CURSO) {
    this.COD_CURSO = COD_CURSO;
  }

  public String getNUM_VERSAO() {
    return this.NUM_VERSAO;
  }

  public void setNUM_VERSAO(String NUM_VERSAO) {
    this.NUM_VERSAO = NUM_VERSAO;
  }

  public String getDESCR_ESTRUTURA() {
    return this.DESCR_ESTRUTURA;
  }

  public void setDESCR_ESTRUTURA(String DESCR_ESTRUTURA) {
    this.DESCR_ESTRUTURA = DESCR_ESTRUTURA;
  }

  public String getCOD_DISCIPLINA() {
    return this.COD_DISCIPLINA;
  }

  public void setCOD_DISCIPLINA(String COD_DISCIPLINA) {
    this.COD_DISCIPLINA = COD_DISCIPLINA;
  }

  public String getNOME_UNIDADE() {
    return this.NOME_UNIDADE;
  }

  public void setNOME_UNIDADE(String NOME_UNIDADE) {
    this.NOME_UNIDADE = NOME_UNIDADE;
  }

  public String getNOME_DISCIPLINA() {
    return this.NOME_DISCIPLINA;
  }

  public void setNOME_DISCIPLINA(String NOME_DISCIPLINA) {
    this.NOME_DISCIPLINA = NOME_DISCIPLINA;
  }

  public String getPERIODO_IDEAL() {
    return this.PERIODO_IDEAL;
  }

  public void setPERIODO_IDEAL(String PERIODO_IDEAL) {
    this.PERIODO_IDEAL = PERIODO_IDEAL;
  }

  public String getNUM_HORAS() {
    return this.NUM_HORAS;
  }

  public void setNUM_HORAS(String NUM_HORAS) {
    this.NUM_HORAS = NUM_HORAS;
  }

  public String getTIPO_DISCIPLINA() {
    return this.TIPO_DISCIPLINA;
  }

  public void setTIPO_DISCIPLINA(String TIPO_DISCIPLINA) {
    this.TIPO_DISCIPLINA = TIPO_DISCIPLINA;
  }

  public String getCH_TOTAL() {
    return this.CH_TOTAL;
  }

  public void setCH_TOTAL(String CH_TOTAL) {
    this.CH_TOTAL = CH_TOTAL;
  }

  public String getDESCR_SITUACAO() {
    return this.DESCR_SITUACAO;
  }

  public void setDESCR_SITUACAO(String DESCR_SITUACAO) {
    this.DESCR_SITUACAO = DESCR_SITUACAO;
  }

  public String toString() {
    return "{" +
      " COD_CURSO='" + getCOD_CURSO() + "'" +
      ", NUM_VERSAO='" + getNUM_VERSAO() + "'" +
      ", DESCR_ESTRUTURA='" + getDESCR_ESTRUTURA() + "'" +
      ", COD_DISCIPLINA='" + getCOD_DISCIPLINA() + "'" +
      ", NOME_UNIDADE='" + getNOME_UNIDADE() + "'" +
      ", NOME_DISCIPLINA='" + getNOME_DISCIPLINA() + "'" +
      ", PERIODO_IDEAL='" + getPERIODO_IDEAL() + "'" +
      ", NUM_HORAS='" + getNUM_HORAS() + "'" +
      ", TIPO_DISCIPLINA='" + getTIPO_DISCIPLINA() + "'" +
      ", CH_TOTAL='" + getCH_TOTAL() + "'" +
      ", DESCR_SITUACAO='" + getDESCR_SITUACAO() + "'" +
      "}";
  }









}
