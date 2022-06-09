package Sistema;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;



public class Main {
	
	
    public static void main(String[] args) throws FileNotFoundException, ClassNotFoundException, IOException { //declaraçoes de emissões
    	
    	Scanner input = new Scanner(System.in);
    	
        String nome, cpf,endereco, email, celular; //Variaveis para cadastrar uma pessoa
        
        int matriculaAluno = 0; //Variavel para cadastrar aluno
        
        int cod_funcionario = 0; //Variavel para cadastrar professor
        
        String nome_curso; float carga; String descricao; int cod_Curso = 0; //Variaveis para cadastrar um curso
        
        int opc = 0; // variavel que possibilita que o usuario escolha uma opção;
                
        Dados dados = new Dados();
        ;
        
       
        
        while(opc == 0){  //painel principal
        	
        	try {
        	System.out.printf("*********** SISTEMA ACADÊMICO **********\n\n");
        	System.out.printf(  "1 - Cadastrar aluno\n" + 
        						"2 - Cadastrar professor\n" + 
        						"3 - Cadastrar sala\n" +
        						"4 - Cadastrar curso\n" + 
        						"5 - Inserir aluno em um curso\n\n" +
        						"O que deseja fazer: ");
        	
        	opc = input.nextInt();
        	}catch(InputMismatchException exception) {System.out.print("ERRO: Insira apenas numeros!"); continue;}
        	
        	input.nextLine();
        	
        	
        	System.out.printf("\n****************************************\n\n");
        	
        	switch(opc) {
	        	case 1:
	        		do{ //Cadastra alunos
	                	
	                	matriculaAluno = dados.contaAluno() + 1;
	               
	        	        System.out.printf("Digite o nome do aluno: ");
	        	        nome = input.nextLine();
	        	       
	        	        System.out.printf("Digite o CPF do aluno: ");
	        	        cpf = input.nextLine();
	        	
	        	        System.out.printf("Digite o endereço do aluno: ");
	        	        endereco = input.nextLine();
	        	
	        	        System.out.printf("Digite o email do aluno: ");
	        	        email = input.nextLine();
	        	
	        	        System.out.printf("Digite o celular do aluno: ");
	        	        celular = input.nextLine();
	        	        
	        	        //instancia a classe aluno adicionado um novo aluno
	        	        Aluno aluno = new Aluno(nome,cpf,endereco,email,celular,matriculaAluno);
	        	        
	        	        //Utiliza o metodo addAluno do objeto dados para inserir um aluno
	        	        dados.addAluno(aluno); 
	        	        
	        	        System.out.println("\nConfirmando dados... \n" +  dados.encontraAluno(matriculaAluno).toString());
	        	       
	        	        //Faz a pergunta se usuário deseja inserir o aluno dentro de um curso
	        	        System.out.println("\nDeseja adicionar o aluno a algum curso, 1 - Sim, 2 - Não: "); 
	        	        opc = input.nextInt();
	        	        
	        	        if(opc == 1) { //Se o usuário inserir 1 irá inciar o if
	        	        	//caso o usuraio insira um cod. do curso (opc) de forma incorreta ou um curso que nao exista ira ser inserida uma mensagem de exceção
	        	        	try {
	        		        	System.out.print("\nDigite o codigo do curso: ");
	        		        	opc = input.nextInt();
	        		        	//Irá atráves do metodo insereAlunoCurso do objeto dados, inserir o aluno ao curso, passando paramentros como o objeto aluno e cod do curso
	        		        	dados.insereAlunoCurso(opc, aluno);
	        		        	System.out.print("\nAluno " + dados.encontraAluno(matriculaAluno).getNome() + " foi cadastrado no curso " + dados.encontraCurso(opc).getNome_curso() + "\n");
	        	        	}catch(ArrayIndexOutOfBoundsException exception) {
	        	        		System.out.print("\nCurso não encontrado...\n");
	        	        	}catch(NullPointerException exception) {
	        	        		System.out.print("\nCurso não encontrado...\n");
	        	        	}
	        	        }
	        	        
	        	        //pergunta se o usuário deseja continuar à cadastrar um novo aluno
	        	        System.out.println("\nDeseja cadastrar um novo aluno, 1 - Sim, 2 - Não: "); 
	        	        opc = input.nextInt();
	        	        
	        	        input.nextLine();
	        	        
	        	        System.out.printf("\n");
	        	        
	        	        
	        		}while(opc != 2); opc = 0; dados.persisteAluno(); break;
	        	
	        	case 2: 
	        		do{ //Cadastra professor
	            	
		            	cod_funcionario++;
		            
		    	        System.out.printf("Digite o nome do professor: ");
		    	        nome = input.nextLine();
		    	       
		    	        System.out.printf("Digite o CPF do professor: ");
		    	        cpf = input.nextLine();
		    	
		    	        System.out.printf("Digite o endereço do porfessor: ");
		    	        endereco = input.nextLine();
		    	
		    	        System.out.printf("Digite o email do professor: ");
		    	        email = input.nextLine();
		    	
		    	        System.out.printf("Digite o celular do professor: ");
		    	        celular = input.nextLine();
		    	        
		    	        Professor professor = new Professor(nome,cpf,endereco,email,celular, cod_funcionario);
		    	       
		    	        //Cadastra o professor dentro do vetor utilizando da variavel cod_funcionario para indetificar o array 
		    	        dados.addProfessor(professor); 
		    	        
		    	        //ira perguntar ao usuário se quer inserir um novo Professor
		    	        System.out.println("\nDeseja cadastrar um novo professor, 1 - Sim, 2 - Não: "); 
		    	        opc = input.nextInt();
		    	        
		    	        input.nextLine();
		    	        
		    	        System.out.printf("\n");
	            }while(opc != 2); opc = 0; break;
	            
	        	case 3: break;
	        
		        case 4: 
		        	do {
			        	try {
			        	cod_Curso++; 	
			        	System.out.printf("Digite o nome do curso: ");
			            nome_curso = input.nextLine();
			             
			            System.out.printf("Digite a carga horaria do curso: ");
			            carga = input.nextFloat();
			            input.nextLine();
			
			            System.out.printf("Digite a descricao do curso: ");
			            descricao = input.nextLine();
			              
			            System.out.printf("\n");
			            
			            Curso curso = new Curso(cod_Curso, nome_curso, carga, descricao);
			            //int cod_curso, String nome_curso, float carga, String descricao
			            dados.addCurso(curso); 
			              
			            System.out.printf(dados.encontraCurso(cod_Curso).toString());
			              
			            System.out.println("\n\nDeseja cadastrar outro curso, 1 - Sim, 2 - Não: ");
			            opc = input.nextInt();
			              
			            input.nextLine();
			        	}catch(InputMismatchException exception){
			        		System.out.println("\n\nERRO: Dados inseridos de forma incorreta!\n\n");
			        		input.nextLine();
			        		continue;
			        	}
			            System.out.printf("\n");
			        	}while(opc != 2); opc = 0; break;
			        
		        default: System.out.print("\n\nOPÇÃO INVÁLIDA!\n\n");
		        	
	        }//switch
        	        	
         	     	
     }//while principal
    
        
}//main
}//classe        	
        	
