package Telas;

import java.awt.EventQueue;
import java.text.ParseException;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JTextField;

import Sistema.Aluno;
import Sistema.Curso;
import Sistema.Dados;

import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;

public class jflistaCurso extends JInternalFrame {
	private JTextField txtCod_curso;
	private JTable tbcurso;

	DefaultTableModel tabela = new DefaultTableModel();//modelo de curso
	DefaultTableModel tabela1 = new DefaultTableModel();//modelo de aluno
	
	private JTextField txtMatricula;
	private JTextField txtNome;
	private JTable tbaluno;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					jfcadastroAluno frame = new jfcadastroAluno();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
	}

	/**
	 * Create the frame.
	 * @return 
	 * @throws ParseException 
	 * @throws IOException 
	 * @throws ClassNotFoundException 
	 * @throws FileNotFoundException 
	 */
	public jflistaCurso() throws ParseException, FileNotFoundException, ClassNotFoundException, IOException {
		
		setTitle("Insere alunos e lista curso: ");
		setResizable(true);
		setClosable(true);
		setMaximizable(true);
		setIconifiable(true);
		setBounds(100, 100, 647, 582);
		getContentPane().setLayout(null);
				
		JLabel lblNewLabel_1 = new JLabel("Cod. do Curso");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_1.setBounds(10, 11, 171, 23);
		getContentPane().add(lblNewLabel_1);
		
		txtCod_curso = new JTextField();
		txtCod_curso.setBackground(new Color(255, 255, 204));
		txtCod_curso.setForeground(new Color(0, 0, 0));
		txtCod_curso.setColumns(10);
		txtCod_curso.setBounds(10, 31, 295, 23);
		getContentPane().add(txtCod_curso);
		
		JScrollPane scrollPane = new JScrollPane(); //Para curso
		scrollPane.setBounds(10, 219, 603, 48);
		getContentPane().add(scrollPane);
		
		JScrollPane scrollPane_1 = new JScrollPane(); //Para alunno
		scrollPane_1.setBounds(10, 302, 603, 224);
		getContentPane().add(scrollPane_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Dados do curso:");
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_1_1.setBounds(10, 199, 171, 23);
		getContentPane().add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Alunos do curso:");
		lblNewLabel_1_1_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_1_1_1.setBounds(10, 271, 171, 23);
		getContentPane().add(lblNewLabel_1_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("Inserir aluno ao curso: (Mátricula)");
		lblNewLabel_1_2.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_1_2.setBounds(10, 65, 171, 23);
		getContentPane().add(lblNewLabel_1_2);
		
		txtMatricula = new JTextField();
		txtMatricula.setBounds(10, 85, 295, 23);
		getContentPane().add(txtMatricula);
		txtMatricula.setColumns(10);
		
		txtNome = new JTextField();
		txtNome.setColumns(10);
		txtNome.setBounds(10, 139, 295, 23);
		getContentPane().add(txtNome);
		
		JLabel lblNewLabel_1_2_1 = new JLabel("Nome do aluno:");
		lblNewLabel_1_2_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_1_2_1.setBounds(10, 119, 171, 23);
		getContentPane().add(lblNewLabel_1_2_1);
		
		tbaluno = new JTable();
		scrollPane_1.setViewportView(tbaluno);
		tabela1.addColumn("Matrícula");
		tabela1.addColumn("Nome");
		tbaluno.setModel(tabela1);
		tbaluno.setAutoCreateRowSorter(true);  // para ordenar as tabelas

		tbcurso = new JTable(); //cria os campos da tabela
		scrollPane.setViewportView(tbcurso);
		tabela.addColumn("Codigo");
		tabela.addColumn("Nome");
		tabela.addColumn("Carga horária");
		tabela.addColumn("Descrição");
		tabela.addColumn("Sala");
		tabela.addColumn("Professor");
		tbcurso.setModel(tabela);
		tbcurso.setAutoCreateRowSorter(true); // para ordenar as tabelas
		
		Dados dados = new Dados(); //instancia Dados 
		
		JButton btnNewButton = new JButton("Listar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {//caso o usuário insira uma letra onde so pode ser inserido numeros ou ocorra outro erro
					
					String cod_cursox = txtCod_curso.getText(); //apenas para receber o valor digitado no campo
					
					if(cod_cursox.equalsIgnoreCase("")) {JOptionPane.showMessageDialog(null, "Erro: Insira o codigo do curso!");}
					
					else {
					
					int cod_curso = Integer.parseInt(cod_cursox);//passa o valor digitado em inteiro para curso
					
					tabela.setNumRows(0); //Insere dados da tabela digittada atraves do codigo do curso
						Curso p = dados.encontraCurso(cod_curso);
						Object[] fila = {
								p.getCod_curso(),
								p.getNome_curso(),
								p.getCarga(),
								p.getDescricao(),
								p.localSala(),
								p.getProfessorDoCurso(),
						};
						tabela.addRow(fila);
						
					tabela1.setNumRows(0); //passa o valor digitado em inteiro para aluno
						for(int i = 1; i <= p.contaAlunosCurso(); i++) {
							Aluno a = p.EncontraAlunoDoCurso(i);
							Object[] fila1 = {
									a.getMatricula(),
									a.getNome(),
							};
							tabela1.addRow(fila1);
						}//for
						
					}//else
										
				}catch(Exception erro) {JOptionPane.showMessageDialog(null, "Erro: Algum dado foi inserido de forma incorreta!");} //do try
			}
		});
		btnNewButton.setBounds(488, 31, 125, 40);
		getContentPane().add(btnNewButton);
		
		JButton btnMatricular = new JButton("Matricular");
		btnMatricular.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {//caso o usuário insira uma letra onde so pode ser inserido numeros ou ocorra outro erro
				String cod_cursox = txtCod_curso.getText(); //apenas para receber o valor digitado no campo
				String matriculax = txtMatricula.getText();
				
				if(cod_cursox.equalsIgnoreCase("") || matriculax.equalsIgnoreCase("")) {JOptionPane.showMessageDialog(null, "Erro: Insira o codigo do curso!");}
				
				else {
					
				int cod_curso = Integer.parseInt(cod_cursox);//passa o valor digitado em inteiro
				int matricula = Integer.parseInt(matriculax);//passa o valor digitado em inteiro
				Curso p = dados.encontraCurso(cod_curso); //cria um objeto curso apartir do resultado de encontraCuro dentro de dados
				
				p.addAluno(dados.encontraAluno(matricula)); 
				txtNome.setText(dados.encontraAluno(matricula).getNome());
				
				tabela.setNumRows(0); //Insere dados da tabela digittada atraves do codigo do curso
				Object[] fila = {
						p.getCod_curso(),
						p.getNome_curso(),
						p.getCarga(),
						p.getDescricao(),
						p.localSala(),
						p.getProfessorDoCurso(),
				};
				tabela.addRow(fila);
				
				tabela1.setNumRows(0); //passa o valor digitado em inteiro para aluno
				for(int i = 1; i <= p.contaAlunosCurso(); i++) {
					Aluno a = p.EncontraAlunoDoCurso(i);
					Object[] fila1 = {
							a.getMatricula(),
							a.getNome(),
					};
					tabela1.addRow(fila1);
				}//for
				
				dados.persisteCurso();
				
				}//else
				
				}catch(Exception erro) {JOptionPane.showMessageDialog(null, "Erro: Algum dado foi inserido de forma incorreta!");} //do try
			}
		});
		btnMatricular.setBounds(488, 119, 125, 40);
		getContentPane().add(btnMatricular);
		
			
	}
}
