package Telas;

import java.awt.EventQueue;
import java.text.ParseException;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JFormattedTextField;
import javax.swing.text.MaskFormatter;

import Sistema.Dados;
import Sistema.Professor;

import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;

public class jfcadastroProfessor extends JInternalFrame {

	private JTextField txtNome;
	private JTextField txtEndereco;
	private JTextField txtEmail;
	private JTextField txtCod_funcionario;
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
	public jfcadastroProfessor() throws ParseException, FileNotFoundException, ClassNotFoundException, IOException {
		
		setTitle("Cadastro de porfessores");
		setResizable(true);
		setClosable(true);
		setMaximizable(true);
		setIconifiable(true);
		setBounds(100, 100, 669, 592);
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Nome: ");
		lblNewLabel.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel.setBounds(25, 11, 381, 23);
		getContentPane().add(lblNewLabel);
		
		JLabel lblCpf = new JLabel("Endereço: ");
		lblCpf.setHorizontalAlignment(SwingConstants.LEFT);
		lblCpf.setBounds(25, 107, 381, 23);
		getContentPane().add(lblCpf);
		
		JLabel lblCpf_1 = new JLabel("CPF: ");
		lblCpf_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblCpf_1.setBounds(25, 62, 381, 23);
		getContentPane().add(lblCpf_1);
		
		JLabel lblEmail = new JLabel("Email: ");
		lblEmail.setHorizontalAlignment(SwingConstants.LEFT);
		lblEmail.setBounds(25, 158, 381, 23);
		getContentPane().add(lblEmail);
		
		JLabel lblCelular = new JLabel("Celular: ");
		lblCelular.setHorizontalAlignment(SwingConstants.LEFT);
		lblCelular.setBounds(25, 211, 381, 23);
		getContentPane().add(lblCelular);
		
		txtNome = new JTextField();
		txtNome.setBounds(25, 31, 381, 23);
		getContentPane().add(txtNome);
		txtNome.setColumns(10);
		
		JFormattedTextField txtCpf = new JFormattedTextField();
		MaskFormatter maskCpf = new MaskFormatter("###.###.###-##");
		maskCpf.install(txtCpf);
		txtCpf.setBounds(25, 81, 381, 23);
		getContentPane().add(txtCpf);
		
		JFormattedTextField txtCelular = new JFormattedTextField();
		MaskFormatter maskCel = new MaskFormatter("(##) # ####-####");
		maskCel.install(txtCelular);
		txtCelular.setBounds(25, 231, 381, 23);
		getContentPane().add(txtCelular);
		
		txtEndereco = new JTextField();
		txtEndereco.setBounds(25, 127, 381, 23);
		getContentPane().add(txtEndereco);
		txtEndereco.setColumns(10);
		
		txtEmail = new JTextField();
		txtEmail.setColumns(10);
		txtEmail.setBounds(25, 180, 381, 23);
		getContentPane().add(txtEmail);
				
		JLabel lblNewLabel_1 = new JLabel("Cod. funcionário");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_1.setBounds(457, 11, 171, 23);
		getContentPane().add(lblNewLabel_1);
		
		txtCod_funcionario = new JTextField();
		txtCod_funcionario.setBackground(new Color(255, 255, 204));
		txtCod_funcionario.setForeground(new Color(0, 0, 0));
		txtCod_funcionario.setColumns(10);
		txtCod_funcionario.setBounds(457, 31, 171, 23);
		getContentPane().add(txtCod_funcionario);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(25, 293, 603, 242);
		getContentPane().add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		tabela.addColumn("Codigo");
		tabela.addColumn("Nome");
		tabela.addColumn("CPF");
		tabela.addColumn("Ebdereco");
		tabela.addColumn("Email");
		tabela.addColumn("Celular");
		table.setModel(tabela);
		table.setAutoCreateRowSorter(true);  // para ordenar as tabelas
		
		Dados dados = new Dados();
		
		tabela.setNumRows(0);	
		for(int i = 1; i <= dados.contaProfessor(); i++) {
			
			Professor p = dados.encontraProfessor(i);
			Object[] fila = {
					p.getCod_funcionario(),
					p.getNome(),
					p.getCpf(),
					p.getEndereco(),
					p.getEmail(),
					p.getCelular(),
			};
			tabela.addRow(fila);
		}
		
		JButton btSalvar = new JButton("Salvar");
		btSalvar.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				int cod_Professor = dados.contaProfessor() + 1;
				
				String nome = txtNome.getText();
				String cpf = txtCpf.getText();
				String endereco = txtEndereco.getText();
				String email = txtEmail.getText();
				String celular = txtCelular.getText();
				txtCod_funcionario.setText("" + cod_Professor);
				
				if(nome.equalsIgnoreCase("") || cpf.equalsIgnoreCase("   .   .   -  ") || endereco.equalsIgnoreCase("") || email.equalsIgnoreCase("") || celular.equalsIgnoreCase("(  )       -    ")) {
					JOptionPane.showMessageDialog(null, "Erro: Preencha todos os dados!");}
				
				else {
				
				Professor professor = new Professor(nome,cpf,endereco,email,celular,cod_Professor);
				dados.addProfessor(professor);
				dados.persisteProfessor();
				
				tabela.setNumRows(0);	
				for(int i = 1; i <= dados.contaProfessor(); i++) {
					
					Professor p = dados.encontraProfessor(i);
					Object[] fila = {
							p.getCod_funcionario(),
							p.getNome(),
							p.getCpf(),
							p.getEndereco(),
							p.getEmail(),
							p.getCelular(),
					};
					tabela.addRow(fila);
				}
				
				JOptionPane.showMessageDialog(null, "Professor cadastrado com sucesso!");
				

				}
			}
		});
		btSalvar.setBounds(470, 114, 129, 50);
		getContentPane().add(btSalvar);
		
		JButton btLimpar = new JButton("Limpar");
		btLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				txtCod_funcionario.setText("");
				txtNome.setText("");
				txtCpf.setText("");
				txtEndereco.setText("");
				txtEmail.setText("");
				txtCelular.setText("");
			}
		});
		btLimpar.setBounds(470, 204, 129, 50);
		getContentPane().add(btLimpar);

	}
}
