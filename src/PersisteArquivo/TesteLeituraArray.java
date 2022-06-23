package PersisteArquivo;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

public class TesteLeituraArray {
	
	public static void main(String[] args) throws FileNotFoundException, ClassNotFoundException, IOException {
		
		ArrayList<Object> listaPessoa;
		listaPessoa = Serializador.ler("ListaCurso.dat");
		
		for(Object p : listaPessoa) {
			System.out.println(p);
		}
	}

}
