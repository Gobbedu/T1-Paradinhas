//import java.util.Vector;
//import java.io.File;
public class teste {
    public static void main (String args[]){
        Arquivadora lista = Arquivadora.getUnica("41561234");
        //System.out.println("Porcentagem de aprovacao="+teste.getPorc_aprovacao());
        //System.out.println("Reprovacoes por falta="+teste.getReprov_falta());
        System.out.println("PARES:");
        for(int i=0;i<lista.getDisciplinas_pares().size();i++)
            System.out.println(lista.getDisciplinas_pares().get(i).getPERIODO_IDEAL()+" "+lista.getDisciplinas_pares().get(i).getNOME_DISCIPLINA());
        System.out.println("IMPARES:");
        for(int i=0;i<lista.getDisciplinas_impares().size();i++)
            System.out.println(lista.getDisciplinas_impares().get(i).getPERIODO_IDEAL()+" "+lista.getDisciplinas_impares().get(i).getNOME_DISCIPLINA());
    
    }
}
