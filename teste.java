import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Vector;
import java.io.File;
import java.io.FileNotFoundException;

public class teste {
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
    public static void main(String[] args){
        try{
            leArquivo();
        }
        catch(IOException e){System.out.println("DEU MERDA");}
    }
}
