package Sistema;

import java.io.Serializable;

//Classe para instanciar alunos

public class Aluno extends Pessoa implements Serializable { //Sub-classe que extende da classe Pessoa

    private int matricula;

    public Aluno() { // construtor
    }

    public Aluno(String nome, String cpf, String endereco, String email, String celular, int matricula) { //cnstrutor
        super(nome, cpf, endereco, email, celular);
        this.matricula = matricula;
    }

    public int getMatricula() {
        return matricula;
    }

    public void setMatricula(int matricula) {
        this.matricula = matricula;
    }

    @Override
    public String toString() {
        return 	"\nNome: " + super.getNome() +
                "\nCPF: " + super.getCpf() +
                "\nEndereco: " + super.getEndereco() +
                "\nEemail: " + super.getEmail() + 
                "\nCelular: " + super.getCelular() +
                "\nMatricula: " + this.matricula + "\n";
    }
}
