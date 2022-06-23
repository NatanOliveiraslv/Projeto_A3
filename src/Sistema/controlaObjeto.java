package Sistema;

public interface controlaObjeto {

	//Adiciona aluno ao listaAluno
    public void addAluno(Aluno aluno);
    //Adiciona Professor ao listaProfessor
    public void addProfessor(Professor professor);
    //Adiciona sala ao listaSala
    public void addSala(Sala sala);
    //Adiciona Curso ao listaCurso
    public void addCurso(Curso curso);
    
    //Encontra Aluno atraves da matricula inserida
    public Aluno encontraAluno(int matricula);
    //Encontra professor atraves do cod. do funcionario
    public Professor encontraProfessor(int cod_funcionario);
    //Encontra sala atraves do cod. da sala
    public Sala encontraSala(int cod_sala);
    //Encontra o curso atraves do cod. do curso
    public Curso encontraCurso(int cod_curso);
    
    //Retorna o total de objetos do listaAluno
    public int contaAluno();
    //Retorna o total de objetos do listaProfessor
    public int contaProfessor();
    //Retorna o total de objetos do listaSala
    public int contaSala();
    //Retorns o total de objetos do listaCurso
    public int contaCurso();
}