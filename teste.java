import java.util.Vector;

public class teste {
    public static void main (String args[]){
        Arquivadora lista = new Arquivadora();
        Vector<Disciplina>  teste = new Vector<Disciplina>();
        teste = lista.getAluno().getBarreira();
        int n = teste.size();
        for(int i = 0; i < n; i++){
            System.out.println(teste.get(i));
        }
    }
}
