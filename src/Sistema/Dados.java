package Sistema;


import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

import PersisteArquivo.Serializador;


public class Dados implements controlaObjeto{
	
    ArrayList<Object> listaAluno; //Um vetor de alunos do tipo Aluno
    ArrayList<Object> listaProfessor; //Um vetor de professores do tipo Professor
    ArrayList<Object> listaSala;
    ArrayList<Object> listaCurso; //Um vetor de cursos do tipo Curso
    
    
    public Dados() throws FileNotFoundException, ClassNotFoundException, IOException {
    	listaAluno = Serializador.ler("ListaAluno.dat");
    	listaProfessor = Serializador.ler("ListaProfessor.dat");
    	listaSala = Serializador.ler("ListaSala.dat");
    	listaCurso = Serializador.ler("ListaCurso.dat");
	}
    
	//Adiciona aluno ao listaAluno
    public void addAluno(Aluno aluno) {
    	listaAluno.add(aluno);}
    //Adiciona Professor ao listaProfessor
    public void addProfessor(Professor professor) {
    	listaProfessor.add(professor);}
    //Adiciona sala ao listaSala
    public void addSala(Sala sala) {
    	listaSala.add(sala);
    }
    //Adiciona Curso ao listaCurso
    public void addCurso(Curso curso) {
    	listaCurso.add(curso);}
    
    //Encontra Aluno atraves da matricula inserida
    public Aluno encontraAluno(int matricula) {
    	for(Object a : listaAluno) {
    		if(((Aluno) a).getMatricula() == matricula){
    			return (Aluno) a;
    		}
    	}
		return null;
    }
    //Encontra professor atraves do cod. do funcionario
    public Professor encontraProfessor(int cod_funcionario) {
    	for(Object a : listaProfessor) {
    		if(((Professor) a).getCod_funcionario() == cod_funcionario){
    			return (Professor) a;
    		}
    	}
		return null;
    }
    //Encontra sala atraves do cod. da sala
    public Sala encontraSala(int cod_sala) {
    	for(Object a : listaSala) {
    		if(((Sala) a).getCod_sala() == cod_sala){
    			return (Sala) a;
    		}
    	}
		return null;
    }
    //Encontra o curso atraves do cod. do curso
    public Curso encontraCurso(int cod_curso) {
    	for(Object a : listaCurso) {
    		if(((Curso) a).getCod_curso() == cod_curso){
    			return (Curso) a;
    		}
    	}
		return null;
    }
    
    //Insere um aluno ao um curso
    public void insereAlunoCurso(int cod_curso, Aluno aluno) {
    	for(Object a : listaCurso) {
    		if(((Curso) a).getCod_curso() == cod_curso){
    			((Curso) a).addAluno(aluno);}
    	}
    }
    
    //grava o Array listaAluno em arquivo
    public void persisteAluno() {
    	Serializador.gravar("ListaAluno.dat", listaAluno);
    }
    //grava o Arra listaProfesso em arquivo
    public void persisteProfessor() {
    	Serializador.gravar("ListaProfessor.dat", listaProfessor);
    }
    //grava o Arra listaSala em arquivo
    public void persisteSala() {
    	Serializador.gravar("ListaSala.dat", listaSala);
    }
    //grava o Array listaCurso em arquivo
    public void persisteCurso() {
    	Serializador.gravar("ListaCurso.dat", listaCurso);
    }
    
    //Retorna o total de objetos do listaAluno
    public int contaAluno() {
    	return listaAluno.size();
    }
    //Retorna o total de objetos do listaProfessor
    public int contaProfessor() {
    	return listaProfessor.size();
    }
    //Retorna o total de objetos do listaSala
    public int contaSala() {
    	return listaSala.size();
    }
    //Retorns o total de objetos do listaCurso
    public int contaCurso() {
    	return listaCurso.size();
    }
}
