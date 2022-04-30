import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;
class gui {
    private static int numero;
    public static void janela(String grr)
    {
        Arquivadora lista = new Arquivadora(grr);
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

    public static void principal(){
        File dir = new File("dados");
        String[] children = dir.list();
        
        JFrame frame = new JFrame("Chat Frame");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH); 
        //Creating the panel at bottom and adding components
        JPanel panel = new JPanel(); // the panel is not visible in output
        JLabel label = new JLabel("Enter Text" + vetor.get(0));
        JTextField tf = new JTextField(8); // accepts upto 10 characters
        JButton send = new JButton("Send");
        JButton reset = new JButton("Reset");
        panel.add(label); // Components Added using Flow Layout
        panel.add(tf);
        panel.add(send);
        panel.add(reset);

        // Text Area at the Center
        JTextArea ta = new JTextArea();

        //Adding Components to the frame.
        frame.getContentPane().add(BorderLayout.SOUTH, panel);
        frame.getContentPane().add(BorderLayout.CENTER, ta);
        frame.setVisible(true);

        if (children == null) {
            System.out.println("does not exist or is not a directory");
        } 
        else{
            for (int i = 0; i < children.length; i++) {
               if(children[i].equals(nome)) 
                System.out.println("achou");
            }
        }

        send.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String grr=tf.getText();
                if (existe(grr+"_historico.csv"))
                    return true;
                else
                    return false;
                if(grr.equals("20206686"))
                {
                    frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
                    janela("GRR"+grr);
                
                }
                else
                    label.setText("senha errada");
            }          
         });
    }
    public static void main(String args[]) {
        numero=0;
        principal();         
        //janela("batata");
    }
}