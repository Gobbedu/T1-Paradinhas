//import java.util.Vector;
//import java.io.File;
public class teste {
    public static void main (String args[]){
        Arquivadora lista = Arquivadora.getUnica();
        Aluno teste = lista.getAluno();
        System.out.println("Porcentagem de aprovacao="+teste.getPorc_aprovacao());
        System.out.println("Reprovacoes por falta="+teste.getReprov_falta());
        System.out.println("Reprovacoes por nota="+teste.getReprov_nota());
    }
}
