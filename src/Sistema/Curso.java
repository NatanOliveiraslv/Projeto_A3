package Sistema;

import java.io.Serializable;
import java.util.ArrayList;

import javax.swing.JOptionPane;

public class Curso implements Serializable{

    private int cod_curso;
    private String nome_curso;
    private float carga = 0;
    private String descricao;
    ArrayList<Aluno> listaAlunosDoCurso;  
    private Sala salaDoCurso; //Insiro um objeto sala, pois necessito do metodo que me retorna a capacidade da sala
    private String professorDoCurso;

  //Quando realizada uma instancia da classe curso, seá criada uma nova ArrayList contedno a lista de alunos do curso
    public Curso() { //construturo sem parametros
    	this.listaAlunosDoCurso = new ArrayList<>();
    }
    
    public Curso(int cod_curso, String nome_curso, float carga, String descricao, Sala sala, String professor) { //construtor com parametros
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

    //sala
    public Sala getSalaDoCurso() {
		return salaDoCurso;
	}

	public void setSalaDoCurso(Sala salaDoCurso) {
		this.salaDoCurso = salaDoCurso;
	}

	public String localSala() {
		return salaDoCurso.getLocal();
	}
	
	
	public String getProfessorDoCurso() {
		return professorDoCurso;
	}

	public void setProfessorDoCurso(String professorDoCurso) {
		this.professorDoCurso = professorDoCurso;
	}

	//Adiciona o aluno ao listaAlunosDoCruso
    public boolean addAluno(Aluno aluno) { 
    	if(listaAlunosDoCurso.size() < salaDoCurso.getCapacidade()) {
    		this.listaAlunosDoCurso.add(aluno);
    		return false;
    	}else {JOptionPane.showMessageDialog(null, "O limite de alunos foi atingido!"); return true;}
    }
	//retorna o total de alunos dentro de listaAlunosCurso
    public int contaAlunosCurso() {
    	return listaAlunosDoCurso.size();
    }
    //Encontra aluno
    public Aluno EncontraAlunoDoCurso(int matricula) {    	
    	for(Aluno c : listaAlunosDoCurso){
    		if(c.getMatricula() == matricula) {
    			return c;
    		}
    	}
    	return null;
    }
    
    @Override
    public String toString() {
		return nome_curso;
	}

    
}
