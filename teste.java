import java.util.Vector;

//não estou conseguindo testar kkkkkk
public class teste {
    public static void main (String args[]){
        Arquivadora lista = new Arquivadora();
        Vector<Aluno> teste = lista.getLista_de_alunos();
        Aluno n = teste.get(1);
        int id = n.getHistorico().size();
        for(int i = 0; i < id; i++){
            System.out.println(n);
        }
    }
}
