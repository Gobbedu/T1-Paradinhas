import java.util.Vector;

public class Solicitacao {
    
    
    public static void GeraDisc_Solicitadas(Vector<Disciplina> solicitadas,Vector<String>nomes,Vector<Disciplina>lista,Vector<Integer>prioridade){
        for(int i=0;i<nomes.size();i++){
          for (int j=0;j<lista.size();j++){
            Disciplina conferir = new Disciplina();
            conferir=lista.get(j);
            if(nomes.get(i).equals(conferir.getNOME_DISCIPLINA())){
              solicitadas.add(conferir);
            }
          }
        }
      }

    public static void GeraArquivo(Vector <Disciplina> solicitadas, ){

    }


}
