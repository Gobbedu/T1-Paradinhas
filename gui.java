import java.awt.*;
import java.awt.event.*;
import java.util.List;
import javax.swing.*;
import javax.swing.table.*;
import java.util.*;
import java.io.*;
import javax.swing.border.Border;
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
    
    public static void TamanhoColunasOfertadas(TableColumnModel columnModel){
        columnModel.getColumn(0).setPreferredWidth(380);
        columnModel.getColumn(0).setMaxWidth(380);
        columnModel.getColumn(1).setPreferredWidth(60);
        columnModel.getColumn(1).setMaxWidth(60);
        columnModel.getColumn(2).setPreferredWidth(80);
        columnModel.getColumn(2).setMaxWidth(80);
    }
    public static void TabelaOfertadas(Arquivadora lista,DefaultTableModel model,int periodo_atual){
        if(periodo_atual==2){
            for(int i=0;i<lista.getDisciplinas_pares().size();i++){
                String materia=lista.getDisciplinas_pares().get(i).getNOME_DISCIPLINA();
                String periodo=lista.getDisciplinas_pares().get(i).getPERIODO_IDEAL();
                Object[] data={materia,periodo,Boolean.FALSE,0};
                model.addRow(data);                    
            }
        }
        else{
            for(int i=0;i<lista.getDisciplinas_impares().size();i++){
                String materia=lista.getDisciplinas_impares().get(i).getNOME_DISCIPLINA();
                String periodo=lista.getDisciplinas_impares().get(i).getPERIODO_IDEAL();
                Object[] data={materia,periodo,Boolean.FALSE,0  };
                model.addRow(data);                    
            }
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
        Arquivadora lista = Arquivadora.getUnica(grr);
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH); 
        frame.setSize(1920,1020);
        /*CABEÇALHO BEGIN */
        String nomeAluno=lista.getAluno().getNOME();
        JLabel header= new JLabel("<html>"+nomeAluno+"<br/>GRR:&emsp;"+grr+"<html>");
        frame.getContentPane().add(BorderLayout.NORTH, header);
        /*CABEÇALHO END*/

        JPanel Tabelas= new JPanel(new BorderLayout());
            /*TABELA DE HISTORICO BEGIN */
            String[] ColunasHistorico = {"Materias cursadas","Periodo","Nota","Situação"};
            DefaultTableModel modelHistorico = new DefaultTableModel(ColunasHistorico,0){
                @Override
                public boolean isCellEditable(int row, int column) {
                //Torna a tabela nao editavel
                return false;
                }
            };
            JTable tableHistorico = new JTable(modelHistorico);
            TableColumnModel columnModelHistorico = tableHistorico.getColumnModel();
            TamanhoColunasHistorico(columnModelHistorico);
            TabelaHistorico(lista, modelHistorico);
            
            JScrollPane scrollPaneHistorico = new JScrollPane(tableHistorico,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
            Tabelas.add(scrollPaneHistorico,BorderLayout.CENTER);
            /*TABELA DE HISTORICO END */

            /*TABELA DE OFERTADAS BEGIN */
            JPanel panelOfertadas = new JPanel(new BorderLayout());
            String[] ColunasOfertadas = {"Materias Ofertadas","Periodo","Requerir","Prioridade(Ordem crescente)"};
            DefaultTableModel modelOfertadas = new DefaultTableModel(ColunasOfertadas,0){
                @Override
                public boolean isCellEditable(int row, int column) {
                    switch(column){
                        case 2:
                        case 3:
                            return true;
                        default:
                            return false;    
                    }
                }
            };
            JTable tableOfertadas= new JTable(modelOfertadas){
                @Override
                public Class getColumnClass(int column){
                    switch(column){
                        case 0:
                            return String.class;
                        case 1:
                            return String.class;
                        case 2:
                            return Boolean.class;
                        case 3:
                            return Integer.class;
                        default:
                            return String.class;
                    }
                }
            };
            
            TableColumnModel columnModelOfertadas = tableOfertadas.getColumnModel();
            TamanhoColunasOfertadas(columnModelOfertadas);
            TabelaOfertadas(lista, modelOfertadas,lista.getAluno().getPeriodo_atual());
            
            JScrollPane scrollPaneOfertadas = new JScrollPane(tableOfertadas,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
            JButton enviar=new JButton("Gerar pedido:");
            panelOfertadas.add(scrollPaneOfertadas,BorderLayout.CENTER);
            panelOfertadas.add(enviar,BorderLayout.SOUTH);
            scrollPaneOfertadas.setPreferredSize(new Dimension(750,500));
            Tabelas.add(panelOfertadas,BorderLayout.EAST);
            /*TABELA DE OFERTADAS END */
        frame.getContentPane().add(BorderLayout.CENTER,Tabelas);
        



        /*TABELA DE BARREIRA BEGIN */
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
            JPanel panel2 =new JPanel(new BorderLayout());
                JScrollPane scrollPaneBarreiras = new JScrollPane(tableBarreira,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
                scrollPaneBarreiras.setPreferredSize(new Dimension(450,200));
                Double Aprovacao=lista.getAluno().getPorc_aprovacao();
                int Falta=lista.getAluno().getReprov_falta();
                JLabel Percentuais = new JLabel("<html>Percentual de aprovacao no ultimo periodo:"+Aprovacao+ "<br/><br/>Reprovacoes por falta no ultimo periodo:"+Falta+"<html>");
                panel2.add(scrollPaneBarreiras,BorderLayout.NORTH);
                panel2.add(Percentuais,BorderLayout.CENTER);
            
            int materias;
                if(Aprovacao>66)
                    materias=5;
                else
                {
                    if(Aprovacao<50)
                        materias=3;
                    else
                        materias=4;
                }
            JLabel avisos= new JLabel("<html>É obrigatoria a matrícula na maior quantidade possível de disciplinas dentro da barreira!<br/>Máximo de matérias com base no seu desempenho="+materias+"<html>");
            enviar.addActionListener(new ActionListener(){

                @Override
                public void actionPerformed(ActionEvent e) {
                    Vector<String> disciplinas = new Vector<String>();
                    Vector<Integer> prioridades = new Vector<Integer>();
                    for (int i=0;i<tableOfertadas.getRowCount();i++){
                        String nome= (String) tableOfertadas.getValueAt(i,0);
                        Boolean marcado=(Boolean) tableOfertadas.getValueAt(i,2);
                        if(marcado){
                            disciplinas.add(nome);
                            Integer prioridade=(Integer)tableOfertadas.getValueAt(i,3);
                            prioridades.add(prioridade);
                        }
                    }
                    if(disciplinas.size()!=0)
                    {
                        lista.GeraPedido(disciplinas,prioridades);
                        JFrame confirmacao= new JFrame("Confirmacao");
                        confirmacao.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                        confirmacao.setResizable(false);
                        confirmacao.setSize(420,300);
                        JLabel confirmado= new JLabel("Seu pedido foi gerado e se encontra no diretório 'dados'");
                        JButton butao=new JButton("OK");
                        confirmacao.getContentPane().add(BorderLayout.CENTER,confirmado);
                        confirmacao.getContentPane().add(BorderLayout.SOUTH,butao);
                        confirmacao.setLocationRelativeTo(null);
                        confirmacao.setVisible(true);
                        butao.addActionListener(new ActionListener() {
                            public void actionPerformed(ActionEvent e) {
                                confirmacao.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
                            }          
                         });
                    }
                }
            });
        
        panel.add(avisos,BorderLayout.CENTER);
        panel.add(panel2,BorderLayout.WEST);
        frame.getContentPane().add(BorderLayout.SOUTH,panel);
        /*TABELA DE BARREIRA END */
        
        frame.setVisible(true);
    }

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
        principal();         
    }
}