import java.awt.*;
import java.awt.event.*;
import java.util.List;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import java.util.*;
import java.io.*;
import javax.swing.border.Border;
class gui {
    public static void janela(String grr)
    {
        //Border borda = BorderFactory.createLineBorder(Color.BLUE, 5);
        Arquivadora lista = Arquivadora.getUnica();
        lista.getAluno().setNOME("sei la porra");
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH); 
        frame.setSize(1920,1020);
    
        String nomeAluno=lista.getAluno().getNOME();
        JLabel nomeLabel= new JLabel("<html>"+nomeAluno+"<br/>GRR:&emsp;"+grr+"<html>");
        frame.getContentPane().add(BorderLayout.NORTH, nomeLabel);

       


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
        principal();         
    }
}