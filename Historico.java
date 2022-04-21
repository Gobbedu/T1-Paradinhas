import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class Historico {
    
    public static void leArquivo() throws FileNotFoundException{
        String nome;
        String GRR;
        Scanner arquivo = new Scanner(new File("TAP_historico.csv"));
        arquivo.useDelimiter(";");
        arquivo.nextLine();
        arquivo.nextLine();
        GRR=arquivo.next();
        nome=arquivo.next();
        System.out.print("Nome: "+nome+" GRR: "+GRR);
        arquivo.close();

    
}
