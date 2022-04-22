import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;

class gui {
    private static int numero;
    public static void janela()
    {
        JFrame frame = new JFrame("Chat Frame");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH); 
        JPanel panel = new JPanel(); // the panel is not visible in output
        JLabel label = new JLabel("Enter Text");
        JTextField tf = new JTextField(8); // accepts upto 10 characters
        JButton send = new JButton("Send");
        JButton reset = new JButton("Reset");
        panel.add(label); // Components Added using Flow Layout
        panel.add(tf);
        panel.add(send);
        panel.add(reset);


        //Adding Components to the frame.
        frame.getContentPane().add(BorderLayout.CENTER, panel);
        frame.setVisible(true);


        reset.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                    frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
                    principal();
                }          
         });
    }

    public static void principal(){
        JFrame frame = new JFrame("Chat Frame");
        Vector<Integer> vetor =new Vector<Integer>();
        numero++;
        vetor.add(numero);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH); 
        //Creating the MenuBar and adding components
        JMenuBar mb = new JMenuBar();
        JMenu m1 = new JMenu("FILE");
        JMenu m2 = new JMenu("Help");
        mb.add(m1);
        mb.add(m2);
        JMenuItem m11 = new JMenuItem("Open");
        JMenuItem m22 = new JMenuItem("Save as");
        m1.add(m11);
        m1.add(m22);

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
        frame.getContentPane().add(BorderLayout.NORTH, mb);
        frame.getContentPane().add(BorderLayout.CENTER, ta);
        frame.setVisible(true);



        send.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String grr=tf.getText();
                if(grr.equals("20206686"))
                {
                    frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
                    janela();
                }
                else
                    label.setText("senha errada");
            }          
         });
    }
    public static void main(String args[]) {
        numero=0;
        principal();         
    }
}