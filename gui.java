import java.awt.*;
import java.awt.event.*;
import java.util.List;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import java.util.*;
import java.io.*;

class gui {
    public static void janela(String grr)
    {
        Arquivadora lista = new Arquivadora();
        JFrame frame = new JFrame(grr);
        frame.setLayout(null);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH); 
        frame.setSize(1920,1020);
        String texto=lista.getAluno().getNOME();
        JLabel batata = new JLabel(texto);
        batata.setBounds(50,40,2000,10);
        
        frame.add(batata);
        frame.setVisible(true);
        List<String> columns = new ArrayList<String>();
        List<String[]> values = new ArrayList<String[]>();

        columns.add("col1");
        //columns.add("col2");
        //columns.add("col3");

        for (int i = 0; i < 100; i++) {
            values.add(new String[] {lista.getAluno().getNOME()});
        }

        TableModel tableModel = new DefaultTableModel(values.toArray(new Object[][] {}), columns.toArray());
        JTable table = new JTable(tableModel);
        table.setSize(5000, 1000);

        JPanel panel2 = new JPanel();
        panel2.add(table);
        frame.getContentPane().add(BorderLayout.CENTER, panel2);
        frame.setVisible(true);
        //frame.getContentPane().add(BorderLayout.CENTER, panel);
        /*JLabel label = new JLabel("batata");
        JTextField tf = new JTextField(8); // accepts upto 10 characters
        JButton send = new JButton("Send");
        JButton reset = new JButton("Reset");
        panel.add(label); // Components Added using Flow Layout
        panel.add(tf);
        panel.add(send);
        panel.add(reset);
        JTextArea ta = new JTextArea();
        ta.setSize(200,100);*/

        //Adding Components to the frame.
        /*frame.getContentPane().add(BorderLayout.CENTER, ta);
        frame.getContentPane().add(BorderLayout.SOUTH, panel);*/
        


        /*reset.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                    frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
                    principal();
                }          
         });*/
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
                        janela("GRR"+grr);
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