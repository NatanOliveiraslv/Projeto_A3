package Sistema;

import java.io.Serializable;

public class Professor extends Pessoa implements Serializable{

    private int cod_funcionario;

    public Professor() {
    }

    public Professor(String nome, String cpf, String endereco, String email, String celular, int cod_funcionario) {
        super(nome, cpf, endereco, email, celular);
        this.cod_funcionario = cod_funcionario;
    }

    public int getCod_funcionario() {
        return cod_funcionario;
    }

    public void setCod_funcionario(int cod_funcionario) {
        this.cod_funcionario = cod_funcionario;
    }
    
    @Override
    public String toString() {
        return 	"\nNome: " + super.getNome() +
                "\nCPF: " + super.getCpf() +
                "\nEndereco: " + super.getEndereco() +
                "\nEemail: " + super.getEmail() + 
                "\nCelular: " + super.getCelular() +
                "\nCod. funcionário: " + this.cod_funcionario + "\n";
    }
}
