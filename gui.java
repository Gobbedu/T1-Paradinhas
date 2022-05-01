import java.awt.*;
import java.awt.event.*;
import java.util.List;
import javax.swing.*;
import javax.swing.table.*;
import java.util.*;
import java.io.*;
import javax.swing.border.Border;
import javax.swing.BoxLayout;
class gui {

    public static void TamanhoColunasHistorico(TableColumnModel columnModel){
        columnModel.getColumn(0).setPreferredWidth(380);
        columnModel.getColumn(0).setMaxWidth(380);
        columnModel.getColumn(1).setPreferredWidth(60);
        columnModel.getColumn(1).setMaxWidth(60);
        columnModel.getColumn(2).setPreferredWidth(60);
        columnModel.getColumn(2).setMaxWidth(60);
        columnModel.getColumn(3).setPreferredWidth(200);
        columnModel.getColumn(3).setMaxWidth(200);
    }
    public static void TabelaHistorico(Arquivadora lista,DefaultTableModel model){
        for(int i=0;i<lista.getAluno().getHistorico().size();i++){
            String materia=lista.getAluno().getHistorico().get(i).getNOME_ATIV_CURRIC();
            String periodoCursado=lista.getAluno().getHistorico().get(i).getSITUACAO_ITEM();
            String MEDIA_FINAL=lista.getAluno().getHistorico().get(i).getMEDIA_FINAL();
            String Situacao=lista.getAluno().getHistorico().get(i).getSITUACAO();
            String[] data={materia,periodoCursado,MEDIA_FINAL,Situacao};
            model.addRow(data);                    
        }
    }
    public static void TamanhoColunasBarreira(TableColumnModel columnModel){
        columnModel.getColumn(0).setPreferredWidth(380);
        columnModel.getColumn(0).setMaxWidth(380);
        columnModel.getColumn(1).setPreferredWidth(50);
        columnModel.getColumn(1).setMaxWidth(50);
    }

    public static void TabelaBarreira(Arquivadora lista,DefaultTableModel model){
        for(int i=0;i<lista.getAluno().getBarreira().size();i++){
            String materiaBarreira=lista.getAluno().getBarreira().get(i).getNOME_DISCIPLINA();
            String periodoIdeal=lista.getAluno().getBarreira().get(i).getPERIODO_IDEAL();

            String[] dataBarreira={materiaBarreira,periodoIdeal};
            model.addRow(dataBarreira);                    
        }
    }
    

    public static void janela(String grr)
    {
        Arquivadora lista = Arquivadora.getUnica();
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH); 
        frame.setSize(1920,1020);
    
        String nomeAluno=lista.getAluno().getNOME();
        JLabel header= new JLabel("<html>"+nomeAluno+"<br/>GRR:&emsp;"+grr+"<html>");
        frame.getContentPane().add(BorderLayout.NORTH, header);

        String[] ColunasHistorico = {"Materias cursadas","Periodo","Nota","Situação"};
        DefaultTableModel modelHistorico = new DefaultTableModel(ColunasHistorico,0){
            @Override
            public boolean isCellEditable(int row, int column) {
            //Torna a tabela nao editavel
            return false;
            }
        };
        JTable tableHistorico = new JTable(modelHistorico);
        TableColumnModel columnModel = tableHistorico.getColumnModel();
        TamanhoColunasHistorico(columnModel);
        TabelaHistorico(lista, modelHistorico);
        
        JScrollPane scrollPane = new JScrollPane(tableHistorico,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        frame.getContentPane().add(BorderLayout.CENTER,scrollPane);
        
        //
        String[] ColunasBarreira = {"Matérias a Cursar na Barreira","Periodo"};
        DefaultTableModel modelBarreira = new DefaultTableModel(ColunasBarreira,0){
            @Override
            public boolean isCellEditable(int row, int column) {
            //Torna a tabela nao editavel
            return false;
            }
        };
        JTable tableBarreira = new JTable(modelBarreira);
            TableColumnModel columnModelBarreira = tableBarreira.getColumnModel();
            TabelaBarreira(lista, modelBarreira);
            TamanhoColunasBarreira(columnModelBarreira);
            
        JPanel panel =new JPanel(new BorderLayout());
            JScrollPane scrollPane2 = new JScrollPane(tableBarreira,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
            JPanel panel2 =new JPanel();
                JLabel Aprovacao = new JLabel("<html>Percentual de aprovacao no ultimo periodo: <html>");
                /*Funcao para calcular essa merda */
                JLabel Falta = new JLabel("<html><br/>Reprovacoes por falta no ultimo periodo:<html>");
                /*Funcao para calcular essa outra merda */
                panel2.add(Aprovacao);
                panel2.add(Falta);
            panel.add(scrollPane2,BorderLayout.WEST);
            panel.add(panel2,BorderLayout.CENTER);

        frame.getContentPane().add(BorderLayout.SOUTH,panel);


        frame.setVisible(true);

        
    
    
    }


    /*PRONTO(ACHO KKK)*/
    public static void principal(){
        
        File dir = new File("dados");
        String[] children = dir.list();
        
        /*Cria o frame e define propriedades */
        JFrame frame = new JFrame("Quebra de Barreira");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setResizable(false);
        frame.setSize(420,300);

        /*Cria o painel de inserção do GRR */
        JPanel panel = new JPanel(); // the panel is not visible in output
        JLabel label = new JLabel("Digite o seu GRR");
        JTextField tf = new JTextField(8); // accepts upto 10 characters
        JButton send = new JButton("Enviar");
        panel.add(label); // Components Added using Flow Layout
        panel.add(tf);
        panel.add(send);
        JLabel Mensagem  = new JLabel("<html>&emsp;Digite seu GRR para acessar o seu perfil no sistema e<br/>&emsp;&emsp;&emsp;construir seu pedido de quebra de barreira<html> ");

        /*Add tudo ao frame */
        frame.getContentPane().add(BorderLayout.CENTER, Mensagem);
        frame.getContentPane().add(BorderLayout.SOUTH, panel);
        frame.setLocationRelativeTo(null);
        frame.getRootPane().setDefaultButton(send);
        frame.setVisible(true);
        
        /*Receber o GRR do usuario */
        send.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String grr=tf.getText();
                for (int i = 0; i < children.length; i++) {
                    if(children[i].equals(grr+"_historico.csv")) {
                        frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
                        janela(grr);
                    }
                }
                label.setText("GRR não encontrado");
            }          
         });
    }
    public static void main(String args[]) {
        //principal();         
        janela("20206686");
    }
}