import java.util.Vector;
import java.io.File;
public class teste {
    public static void main (String args[]){
        Arquivadora lista = new Arquivadora();
        Vector<Disciplina>  teste = new Vector<Disciplina>();
        teste = lista.getAluno().getBarreira();
        int n = teste.size();
        for(int i=0;i<n;i++)
        {
            System.out.println(teste.get(i));
        }
        /*File dir = new File(".");
        String[] children = dir.list();
        String nome= "TAP_historico.csv";
        if (children == null) {
            System.out.println("does not exist or is not a directory");
        } 
        else{
            for (int i = 0; i < children.length; i++) {
               if(children[i].equals(nome)) 
                System.out.println("achou");
            }
        }*/
    }
}
