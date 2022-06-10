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
            
        String local; int capacidade; int cod_sala; //Variaveis para cadastrar uma sala
        
        String nome_curso; float carga; String descricao; int cod_Curso = 0;  //Variaveis para cadastrar um curso
        
        Curso x; //Apennas para facilitar na inserção de alunos no curso
        
        int opc = 0; // variavel que possibilita que o usuario escolha uma opção;
                
        Dados dados = new Dados();
        
        
        while(opc == 0){  //painel principal
        	
        	try {
        	System.out.printf("--------------- SISTEMA ACADÊMICO ---------------\n\n");
        	System.out.printf(  "|  1 - Cadastrar aluno      | \n" + 
        						"|  2 - Cadastrar professor  | \n" + 
        						"|  3 - Cadastrar sala       | \n" +
        						"|  4 - curso                | \n\n" + 

        						"O que deseja fazer: ");
        	
        	opc = input.nextInt();
        	
        	}catch(InputMismatchException exception){
	        	System.out.println("\nERRO: Insira apenas numeros!\n");
	        	input.nextLine();
	        	continue;}
        	
        	input.nextLine();

        	System.out.printf("\n-------------------------------------------------\n\n");
        	
        	
        	
        	
        	//Cadastra alunos
        	switch(opc) {
	        	case 1:
	        		do{ 
	                	
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
	        	       
	        	       
//	        	        System.out.println("\nDeseja adicionar o aluno a algum curso, 1 - Sim, 2 - Não: "); 
//	        	        opc = input.nextInt();
//	        	        
//	        	        if(opc == 1) { //Se o usuário inserir 1 irá inciar o if
//	        	        	//caso o usuraio insira um cod. do curso (opc) de forma incorreta ou um curso que nao exista ira ser inserida uma mensagem de exceção
//	        	        	try {
//	        		        	System.out.print("\nDigite o codigo do curso: ");
//	        		        	opc = input.nextInt();
//	        		        	//Irá atráves do metodo insereAlunoCurso do objeto dados, inserir o aluno ao curso, passando paramentros como o objeto aluno e cod do curso
//	        		        	dados.insereAlunoCurso(opc, aluno);
//	        		        	System.out.print("\nAluno " + dados.encontraAluno(matriculaAluno).getNome() + " foi cadastrado no curso " + dados.encontraCurso(opc).getNome_curso() + "\n");
//	        	        	}catch(ArrayIndexOutOfBoundsException exception) {
//	        	        		System.out.print("\nCurso não encontrado...\n");
//	        	        	}catch(NullPointerException exception) {
//	        	        		System.out.print("\nCurso não encontrado...\n");
//	        	        	}
//	        	        }
	        	        
	        	        System.out.println("\n********************** OBS **********************\n");
		    	        System.out.println("Caso não queira mais cadastrar, "
		    	        				 + "\nNÃO ENCERRE O PROGRAMA"
		    	        				 + "\ndigite 2 para parar o cadastro e salvar os "
		    	        				 + "\ndados cadastrados.");
		    	        System.out.println("\n*************************************************\n");
		    	        
		    	        do {System.out.println("Opção inválida");
		    	        
		    	        try {
		    	        //pergunta se o usuário deseja continuar à cadastrar um novo aluno
	        	        System.out.println("\nDeseja cadastrar um novo aluno: \n"
	        	        					+ "\n|  1 - Sim "
	        	        					+ "\n|  2 - Não "
	        	        					+ "\n"); 
	        	        
	        	        opc = input.nextInt();
	        	        input.nextLine();
	        	        
	        	        }catch(InputMismatchException exception){
	        	        	System.out.println("\nERRO: Insira apenas numeros!\n");
	        	        	input.nextLine();
	        	        	opc = 3;
	        	        	continue;
	        	        	}
	        	        
	        	        }while(opc != 1 && opc != 2);
		    	        
	        	        System.out.printf("\n");
	        	        
	        	        
	        		}while(opc == 1); opc = 0; dados.persisteAluno(); System.out.println("Dados salvos com SUCESSO!\n"); break; 
	        		//cadstro de aluno
	        	
	        	
	        	
	        	//Cadastra professor
	        	case 2: 
	        		do{ 
	            	
		            	cod_funcionario = dados.contaProfessor() + 1;
		            
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
		    	        
		    	        System.out.println("\nConfirmando dados... \n" +  dados.encontraProfessor(cod_funcionario).toString());
		    	        
		    	        System.out.println("\n********************** OBS **********************\n");
		    	        System.out.println("Caso não queira mais cadastrar, "
		    	        				 + "\nNÃO ENCERRE O PROGRAMA,"
		    	        				 + "\ndigite 2 para parar o cadastro e salvar os "
		    	        				 + "\ndados cadastrados.");
		    	        System.out.println("\n*************************************************\n");
		    	        
		    	        try {
	        	        //pergunta se o usuário deseja continuar à cadastrar um novo aluno
	        	        System.out.println("\nDeseja cadastrar um novo professor: \n"
	        	        					+ "\n|  1 - Sim "
	        	        					+ "\n|  2 - Não "
	        	        					+ "\n"); 
	        	        opc = input.nextInt();
	        	        
		    	        }catch(InputMismatchException exception){
	        	        	System.out.println("\nERRO: Insira apenas numeros!\n");
	        	        	input.nextLine();
	        	        	continue;}
		    	        
		    	        input.nextLine();
		    	        
		    	        System.out.printf("\n");
		    	        
	            }while(opc == 1); opc = 0; dados.persisteProfessor(); System.out.println("Dados salvos com SUCESSO!\n"); break;
	            //cadastra professor
	            
	            
	            
	            
	        	case 3: 
	        		do{ //Cadastra sala
		            	
		            	cod_sala = dados.contaSala() + 1;
		            
		    	        System.out.printf("Digite o local da sala: ");
		    	        local = input.nextLine();
		    	       
		    	        System.out.printf("Digite a capacidade de alunos da sala: ");
		    	        capacidade = input.nextInt();
		    	        
		    	        Sala sala = new Sala(cod_sala, local, capacidade);
		    	       
		    	        //Cadastra o professor dentro do vetor utilizando da variavel cod_funcionario para indetificar o array 
		    	        dados.addSala(sala); 
		    	        
		    	        System.out.println("\nConfirmando dados... \n" +  dados.encontraSala(cod_sala).toString());
		    	        
		    	        //ira perguntar ao usuário se quer inserir um novo Professor
		    	        System.out.println("\n********************** OBS **********************\n");
		    	        System.out.println("Caso não queira mais cadastrar, "
		    	        				 + "\nNÃO ENCERRE O PROGRAMA"
		    	        				 + "\ndigite 2 para parar o cadastro e salvar os "
		    	        				 + "\ndados cadastrados.");
		    	        System.out.println("\n*************************************************\n");
		    	        
	        	        //pergunta se o usuário deseja continuar à cadastrar um novo aluno
	        	        System.out.println("\nDeseja cadastrar uma nova sala: \n"
	        	        					+ "\n|  1 - Sim "
	        	        					+ "\n|  2 - Não "
	        	        					+ "\n"); 
		    	        opc = input.nextInt();
		    	        
		    	        input.nextLine();
		    	        
		    	        System.out.printf("\n");
		    	        
	            }while(opc == 1); opc = 0; dados.persisteSala(); System.out.println("Dados salvos com SUCESSO!\n"); break;
	        	//cadastra sala
	            
	            
	        
		        case 4: 
		        	do {
		        		System.out.println( "|  1 - Cadastrar curso\n"
 	        							  + "|  2 - Inserir aluno em curso\n"
 	        							  + "|  0 - Sair\n"); 
		        		opc = input.nextInt();
		    	        
		    	        input.nextLine();
		    	        
		    	        switch(opc) {
		    	        
		    	        	case 0: System.out.print("\nSaindo...\n\n"); opc = 0; break;
		    	        	
		    	        	case 1: //cadsatro de curso 	
		    	        			do {
		    	        			try {
		    			        	cod_Curso = dados.contaCurso() + 1; 	
		    			        	System.out.printf("Digite o nome do curso: ");
		    			            nome_curso = input.nextLine();
		    			             
		    			            System.out.printf("Digite a carga horaria do curso: ");
		    			            carga = input.nextFloat();
		    			            input.nextLine();
		    			
		    			            System.out.printf("Digite a descricao do curso: ");
		    			            descricao = input.nextLine();
		    			            
		    			            System.out.printf("Digite o código da sala: ");
		    			            cod_sala = input.nextInt();
		    			            input.nextLine();
		    			            
		    			            System.out.printf("Digite o código do professor: ");
		    			            cod_funcionario = input.nextInt();
		    			            input.nextLine();
		    			              
		    			            System.out.printf("\n");
		    			            
		    			            Curso curso = new Curso(cod_Curso, nome_curso, carga, descricao, dados.encontraSala(cod_sala), dados.encontraProfessor(cod_funcionario));
		    			            //int cod_curso, String nome_curso, float carga, String descricao
		    			            dados.addCurso(curso); 
		    			              
		    			            System.out.printf(dados.encontraCurso(cod_Curso).toString());
		    			              
		    			            //ira perguntar ao usuário se quer inserir um novo Professor
		    		    	        System.out.println("\n********************** OBS **********************\n");
		    		    	        System.out.println("Caso não queira mais cadastrar, "
		    		    	        				 + "\nNÃO ENCERRE O PROGRAMA"
		    		    	        				 + "\ndigite 2 para parar o cadastro e salvar os "
		    		    	        				 + "\ndados cadastrados.");
		    		    	        System.out.println("\n*************************************************\n");
		    		    	        
		    	        	        //pergunta se o usuário deseja continuar à cadastrar um novo aluno
		    	        	        System.out.println("\nDeseja cadastrar uma nova sala: \n"
		    	        	        					+ "\n|  1 - Sim "
		    	        	        					+ "\n|  2 - Não "
		    	        	        					+ "\n"); 
		    		    	        opc = input.nextInt();
		    		    	        
		    		    	        input.nextLine();
		    		    	        
		    		    	        System.out.printf("\n");
		    		    	        
		    			        	}catch(InputMismatchException exception){
		    			        		System.out.println("\n\nERRO: Dados inseridos de forma incorreta!\n\n");
		    			        		input.nextLine();
		    			        		continue;
		    			        	}
		    	        			
		    			            
		    	        			}while(opc == 1); dados.persisteCurso(); opc = 1; break;//cadastro do curso
		    	        			
		    	        			
		    	        		
		    	        	case 2:
		    	        		//insere alunos ao curso
		    	        		//Pergunta ao usuário qual o codigo do curso que deseja cadastrar
		    	        		do {
		    	        			System.out.println("\nDigite o codigo do curso: ");
		    	        			cod_Curso = input.nextInt();
		    	        			input.nextLine();
		    	        			
		    	        			x = dados.encontraCurso(cod_Curso); //armazena em x o curso encontrado
		    	        			
		    	        			do{ //pergunta ao usuaário a matricula do aluno que deseja inserir no curso
		    	        				System.out.println("\nDigite o codigo do aluno, 0 para encerrar: ");
		    	        				matriculaAluno = input.nextInt();
		    	        				//Se a matricula inserida pelo usário nao possuir nenhum cadastro ira avisar na tela
		    	        				if(dados.encontraAluno(matriculaAluno) == null) { if (matriculaAluno != 0) {System.out.println("\nMatricula do aluno não encontrada!");}}
		    	        				else{x.addAluno(dados.encontraAluno(matriculaAluno));}
		    	        				
		    	        			}while (matriculaAluno != 0);
		    	        	
		    	        		}while(opc == 1); opc = 1; break;//insere aluno ao curso
		    	            
		    	        	default: System.out.println("\nOpção inválida! \n"); opc = 1;
		    	        		
		    	        	}//switch do caso 4
			        	
			    }while(opc == 1); opc = 0; break; //while do caso 4
			        
		        
		        default: System.out.print("OPÇÃO INVÁLIDA!\n\n"); opc = 0; //efault do switch principal
		        	
	        }//switch
        	        	
         	     	
     }//while principal
    
        
}//main
}//classe        	
        	
