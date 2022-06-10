package Sistema;

import java.io.Serializable;

public class Sala implements Serializable{

    private int cod_sala;
    private String local;
    private int capacidade;
    
    
    public Sala() {
	}

	public Sala(int cod_sala, String local, int capacidade) { //contrutor
		super();
		this.cod_sala = cod_sala;
		this.local = local;
		this.capacidade = capacidade;
	}

	public int getCod_sala() {
        return cod_sala;
    }

    public void setCod_sala(int num_sala) {
        this.cod_sala = num_sala;
    }

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    public int getCapacidade() {
        return capacidade;
    }

    public void setCapacidade(int capacidade) {
        this.capacidade = capacidade;
    }

	@Override
	public String toString() {
		return "\nCod. da sala: " + cod_sala + "\nlocal: " + local + "\nCapacidade: " + capacidade;
	}
    
    
}
