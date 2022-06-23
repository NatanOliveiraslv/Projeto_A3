package Telas;

import java.awt.EventQueue;
import java.text.ParseException;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JFormattedTextField;
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

public class jfcadastroCurso extends JInternalFrame {

	private JTextField txtNome;
	private JTextField txtCod_curso;
	private JTable table;

	DefaultTableModel tabela = new DefaultTableModel();
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
	public jfcadastroCurso() throws ParseException, FileNotFoundException, ClassNotFoundException, IOException {
		
		setTitle("Cadastro de curso");
		setResizable(true);
		setClosable(true);
		setMaximizable(true);
		setIconifiable(true);
		setBounds(100, 100, 669, 592);
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Nome do curso: ");
		lblNewLabel.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel.setBounds(25, 11, 381, 23);
		getContentPane().add(lblNewLabel);
		
		JLabel lblCpf = new JLabel("Sala do curso: (codigo)");
		lblCpf.setHorizontalAlignment(SwingConstants.LEFT);
		lblCpf.setBounds(25, 107, 381, 23);
		getContentPane().add(lblCpf);
		
		JLabel lblCpf_1 = new JLabel("Carga horária:");
		lblCpf_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblCpf_1.setBounds(25, 62, 381, 23);
		getContentPane().add(lblCpf_1);
		
		JLabel lblEmail = new JLabel("Professor do curso: (codigo)");
		lblEmail.setHorizontalAlignment(SwingConstants.LEFT);
		lblEmail.setBounds(25, 158, 381, 23);
		getContentPane().add(lblEmail);
		
		JLabel lblCelular = new JLabel("Descrição:");
		lblCelular.setHorizontalAlignment(SwingConstants.LEFT);
		lblCelular.setBounds(25, 211, 381, 23);
		getContentPane().add(lblCelular);
		
		txtNome = new JTextField();
		txtNome.setBounds(25, 31, 381, 23);
		getContentPane().add(txtNome);
		txtNome.setColumns(10);
		
		JFormattedTextField txtDescricao = new JFormattedTextField();
		txtDescricao.setToolTipText("");
		txtDescricao.setBounds(25, 231, 381, 80);
		getContentPane().add(txtDescricao);
				
		JLabel lblNewLabel_1 = new JLabel("Cod. do Curso");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_1.setBounds(457, 11, 171, 23);
		getContentPane().add(lblNewLabel_1);
		
		txtCod_curso = new JTextField();
		txtCod_curso.setBackground(new Color(255, 255, 204));
		txtCod_curso.setForeground(new Color(0, 0, 0));
		txtCod_curso.setColumns(10);
		txtCod_curso.setBounds(457, 31, 171, 23);
		getContentPane().add(txtCod_curso);
		
		JFormattedTextField txtfSala = new JFormattedTextField();
		txtfSala.setBounds(25, 128, 123, 20);
		getContentPane().add(txtfSala);
		
		JFormattedTextField txtfProfessor = new JFormattedTextField();
		txtfProfessor.setBounds(25, 180, 123, 20);
		getContentPane().add(txtfProfessor);

		JFormattedTextField txtfCarga = new JFormattedTextField();
		txtfCarga.setBounds(25, 82, 123, 20);
		getContentPane().add(txtfCarga);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(25, 331, 603, 204);
		getContentPane().add(scrollPane);
		
		table = new JTable(); //cria os campos da tabela
		scrollPane.setViewportView(table);
		tabela.addColumn("Codigo");
		tabela.addColumn("Nome");
		tabela.addColumn("Carga horária");
		tabela.addColumn("Descrição");
		tabela.addColumn("Sala");
		tabela.addColumn("Professor");
		table.setModel(tabela);
		table.setAutoCreateRowSorter(true); // para ordenar as tabelas
		
		Dados dados = new Dados(); //instancia Dados 
		
		tabela.setNumRows(0); //insere dados dentro da tabela	
		for(int i = 1; i <= dados.contaCurso(); i++) { //encquento for menor que o tamanho da arraylist listacurso
			
			Curso p = dados.encontraCurso(i);
			Object[] fila = {
					p.getCod_curso(),
					p.getNome_curso(),
					p.getCarga(),
					p.getDescricao(),
					p.localSala(),
					p.getProfessorDoCurso(),
			};
			tabela.addRow(fila);
		}
		
		
		JButton btSalvar = new JButton("Salvar");
		btSalvar.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				try {//caso o usuário insira uma letra onde so pode ser inserido numeros ou ocorra outro erro
					
				int cod_curso = dados.contaCurso() + 1;
				
				String nome = txtNome.getText();
				String cargax = txtfCarga.getText(); //recebe o valor em string 
				String salax = txtfSala.getText(); //recebe o valor em string 
				String professorx = txtfProfessor.getText(); //recebe o valor em string 
				String descricao = txtDescricao.getText();
				
				
				//caso um campo nao seja preenchido
				if(nome.equalsIgnoreCase("") || cargax.equalsIgnoreCase("") || salax.equalsIgnoreCase("") || professorx.equalsIgnoreCase("") || descricao.equalsIgnoreCase("")) {
					JOptionPane.showMessageDialog(null, "Erro: Preencha todos os dados!");} 
				
				else {
					
				int carga = Integer.parseInt(cargax); //passa String para float
				int sala = Integer.parseInt(salax); //passa String para int		
				int professor = Integer.parseInt(professorx); //passa String para int
				
				//caso o usuário insira uma sala que nao exista
				if(dados.encontraSala(sala) == null) {JOptionPane.showMessageDialog(null, "Erro: Sala não encontrada!");}
				//caso o usuário insira um professor que nao exista
				if(dados.encontraProfessor(professor) == null) {JOptionPane.showMessageDialog(null, "Erro: Professor não encontrado!");}
				
				txtCod_curso.setText("" + cod_curso); // apenas para mostar o codigo do curso
				
				//instancia o curso
				Curso curso = new Curso(cod_curso, nome, carga, descricao, dados.encontraSala(sala), dados.encontraProfessor(professor).getNome());
				dados.addCurso(curso); //adiciona o cuso a lista
				
				dados.persisteCurso();
				
				tabela.setNumRows(0); //repete o mesmo processo da tabela anteriror, mas adicionado o objeto cadastrado
				for(int i = 1; i <= dados.contaCurso(); i++) {
					
					Curso p = dados.encontraCurso(i);
					Object[] fila = {
							p.getCod_curso(),
							p.getNome_curso(),
							p.getCarga(),
							p.getDescricao(),
							p.localSala(),
							p.getProfessorDoCurso(),
					};
					tabela.addRow(fila);} 
				
				JOptionPane.showMessageDialog(null, "Curso cadastrado com sucesso!");
				

				}
				
				}catch(Exception erro) {JOptionPane.showMessageDialog(null, "Erro: Algum dado foi inserido de forma incorreta!");} //do try
			}
		});		
		btSalvar.setBounds(470, 114, 129, 50);
		getContentPane().add(btSalvar);

		
		JButton btLimpar = new JButton("Limpar");
		btLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//lipa todos os  campos
				txtCod_curso.setText("");
				txtNome.setText("");
				txtfCarga.setText("");
				txtfSala.setText("");
				txtfProfessor.setText("");
				txtDescricao.setText("");
			}
		});
		btLimpar.setBounds(470, 204, 129, 50);
		getContentPane().add(btLimpar);
		
	}
}
