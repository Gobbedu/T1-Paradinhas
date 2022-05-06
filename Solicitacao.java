import java.util.Vector;
import java.io.IOException;
import java.io.PrintWriter;

public class Solicitacao {
 
 
    public static void GeraDisc_Solicitadas(Vector<Disciplina> solicitadas,Vector<String>nomes,Vector<Disciplina>lista){
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

    public static void GeraArquivo(Vector <String> solicitadas,Vector<Integer> prioridades,Aluno aluno) {
        try{
            PrintWriter writer = new PrintWriter("./dados/saida.txt");
            writer.write("                              PEDIDO DE QUEBRA DE REQUISITOS / BARREIRA\n");
            writer.write("Este formulário serve para encaminhamento de pedido ao colegiado do curso para a quebra de requisitos da barreira dos três períodos iniciais, conforme previsto na definição do currículo do curso.Deve ser entregue na secretaria do curso, no prazo indicado pela coordenação. Se houver dificuldades entre em contato com a secretaria. ALUNO: anexe histórico escolar atualizado nas duas versões(integralização e por semestre). A secretaria não se responsabilizará pela emissão.\n\n");
            writer.write("Nome: "+aluno.getNOME()+"  ");
            writer.write("GRR: "+aluno.getGRR()+"\n");
            writer.write("Curso: "+aluno.getHistorico().get(0).getNOME_CURSO()+"    ");
            writer.write("É formando? ( ) Sim ( ) Não\n");
            writer.write("( )Barreira ( ) Requisito     Telefone:_______________ Email:_________________________\n\n");
            writer.write("1. Disciplinas que faltam aprovar na barreira:\n");
            int tamanho=aluno.getBarreira().size();
            for(int i=0;i<tamanho;i++){
                writer.write(aluno.getBarreira().get(i).getNOME_DISCIPLINA()+"\n");
            }            
            writer.write("\n2. Tem condições de se matricular nesta disciplina, sem colisão de horários com as disciplinas faltantes,possuindo condições de finalizar as atividades formativas complementares seguindo as regras vigentes do seu curso? (   ) Sim (   ) Não\n");
            writer.write("3. Disciplinas Solicitadas:\n\n");
            for(int i=0;i<solicitadas.size();i++){
               writer.write(solicitadas.get(i)+"    Prioridade:"+prioridades.get(i)+"\n");
            }
            writer.write("\n4. Justifique seu pedido:\n");
            writer.write("_____________________________________________________________________________________________________\n");
            writer.write("_____________________________________________________________________________________________________\n");
            writer.write("_____________________________________________________________________________________________________\n");
            writer.write("_____________________________________________________________________________________________________\n");
            writer.write("_____________________________________________________________________________________________________\n");
            writer.write("_____________________________________________________________________________________________________\n");
            writer.write("_____________________________________________________________________________________________________\n");
            writer.write("_____________________________________________________________________________________________________\n");
            writer.write("\nData do Pedido: ___________________________________________________\n");
            writer.write("\n\n\n\n\n\n                                  ______________________________________\n");
            writer.write("                                          Assinatura do aluno");       
            writer.close();
        }catch(IOException e){
            System.out.println("Erro ao escrever o arquivo");
            e.printStackTrace();
        }
    }

}
