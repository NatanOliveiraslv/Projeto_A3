package PersisteArquivo;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class Serializador {

	public static void gravar(String nomeArq, ArrayList<Object> lista) {
	 //instancia "arq" para manipular o arquivo a ser criado...
    File arq = new File(nomeArq);
    try{
        arq.delete();
        arq.createNewFile();

        //Associa objOutput ao um fluxo de saída de bytes...
        ObjectOutputStream objOutput = new ObjectOutputStream(new FileOutputStream(arq));
        //Método para transferir os dados da "lista" para o arquivo binário...
        objOutput.writeObject(lista);
        //fecha o fluxo de saída...
        objOutput.close();

    }catch(IOException erro) {
        System.out.printf("Erro: %s", erro.getMessage());
    }
    
}
	
	public static ArrayList<Object> ler(String nomeArq)
			throws FileNotFoundException, IOException, ClassNotFoundException{
		ArrayList<Object> lista = new ArrayList<>();
        try {
            //abre o arquivo para operações...
            File arq = new File(nomeArq);
            if (arq.exists()) {
               //Associa objInput ao um fluxo de entrada de bytes...
               ObjectInputStream objInput = new ObjectInputStream(new FileInputStream(arq));
               //desserializa e recupera os objetos do arquivo binário na forma de ArrayList
               lista = (ArrayList<Object>)objInput.readObject();
               //fecha o fluxo de entrada...
               objInput.close();
            }
        } catch(IOException erro1) {
            System.out.printf("Erro: %s", erro1.getMessage());
        } catch(ClassNotFoundException erro2) {
            System.out.printf("Erro: %s", erro2.getMessage());
        }

        return(lista);
	}
}
