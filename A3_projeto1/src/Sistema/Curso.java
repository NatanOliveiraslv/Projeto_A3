package Sistema;

import java.io.Serializable;
import java.util.ArrayList;

public class Curso implements Serializable{

    private int cod_curso;
    private String nome_curso;
    private float carga = 0;
    private String descricao;
    ArrayList<Aluno> listaAlunosDoCurso;  
    private Sala salaDoCurso;
    private Professor professorDoCurso;

  //Quando realizada uma instancia da classe curso, seá criada uma nova ArrayList contedno a lista de alunos do curso
    public Curso() { //construturo sem parametros
    	this.listaAlunosDoCurso = new ArrayList<>();
    }
    
    public Curso(int cod_curso, String nome_curso, float carga, String descricao, Sala sala, Professor professor) { //construtor com parametros
        this.cod_curso = cod_curso;
        this.nome_curso = nome_curso;
        this.carga = carga;
        this.descricao = descricao;
        this.salaDoCurso = sala;
        this.professorDoCurso = professor;
        this.listaAlunosDoCurso = new ArrayList<>();
        
    }

    public int getCod_curso() {
        return cod_curso;
    }

    public void setCod_curso(int cod_curso) {
        this.cod_curso = cod_curso;
    }

    public String getNome_curso() {
        return nome_curso;
    }

    public void setNome_curso(String nome_curso) {
        this.nome_curso = nome_curso;
    }

    public float getCarga() {
        return carga;
    }

    public void setCarga(float carga) {
        this.carga = carga;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Sala getSalaDoCurso() {
		return salaDoCurso;
	}

	public void setSalaDoCurso(Sala salaDoCurso) {
		this.salaDoCurso = salaDoCurso;
	}

	public Professor getProfessorDoCurso() {
		return professorDoCurso;
	}

	public void setProfessorDoCurso(Professor professorDoCurso) {
		this.professorDoCurso = professorDoCurso;
	}

	//Adiciona o aluno ao listaAlunosDoCruso
    public void addAluno(Aluno aluno) { 
    	if(listaAlunosDoCurso.size() < salaDoCurso.getCapacidade()) {
    		this.listaAlunosDoCurso.add(aluno);
    	}else {System.out.println("O limite da capacidade de alunos do curso foi atingido!");}	
    }

    public void listaAlunos() {
    	System.out.println("Lista de alunos: ");
    	
    	for(Aluno c : listaAlunosDoCurso){
    		System.out.print("Matricula: " + c.getMatricula() + " Nome: " + c.getNome() );
    	}
    }
	
    @Override
	public String toString() {
		return "Cod. do curso: " + cod_curso + 
				"\nNome do curso: " + nome_curso + 
				"\nCarga horária: " + carga + 
				"\nDescrição: " + descricao + 
				"\nSala: " + salaDoCurso.getLocal() +
				"\nProfessor: " + professorDoCurso.getNome();
	}

    
}
