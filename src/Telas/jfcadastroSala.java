package Telas;

import java.awt.EventQueue;
import java.text.ParseException;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JFormattedTextField;
import Sistema.Dados;
import Sistema.Sala;

import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;

public class jfcadastroSala extends JInternalFrame {

	private JTextField txtLocal;
	private JTextField txtCod_Sala;
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
	public jfcadastroSala() throws ParseException, FileNotFoundException, ClassNotFoundException, IOException {
		
		setTitle("Cadastro de sala");
		setResizable(true);
		setClosable(true);
		setMaximizable(true);
		setIconifiable(true);
		setBounds(100, 100, 552, 348);
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Local");
		lblNewLabel.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel.setBounds(25, 11, 381, 23);
		getContentPane().add(lblNewLabel);
		
		JLabel lblCpf_1 = new JLabel("Capacidade: (Somente números)");
		lblCpf_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblCpf_1.setBounds(25, 62, 381, 23);
		getContentPane().add(lblCpf_1);
		
		txtLocal = new JTextField();
		txtLocal.setBounds(25, 31, 267, 23);
		getContentPane().add(txtLocal);
		txtLocal.setColumns(10);
		
		JFormattedTextField txtCapacidade = new JFormattedTextField();
		txtCapacidade.setBounds(25, 81, 102, 23);
		getContentPane().add(txtCapacidade);
				
		JLabel lblNewLabel_1 = new JLabel("Cod. da Sala");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_1.setBounds(347, 11, 171, 23);
		getContentPane().add(lblNewLabel_1);
		
		txtCod_Sala = new JTextField();
		txtCod_Sala.setBackground(new Color(255, 255, 204));
		txtCod_Sala.setForeground(new Color(0, 0, 0));
		txtCod_Sala.setColumns(10);
		txtCod_Sala.setBounds(347, 31, 171, 23);
		getContentPane().add(txtCod_Sala);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 160, 508, 146);
		getContentPane().add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		tabela.addColumn("Codigo");
		tabela.addColumn("Local");
		tabela.addColumn("Capacidade");
		table.setModel(tabela);
		table.setAutoCreateRowSorter(true); // para ordenar as tabelas
		
		Dados dados = new Dados();
		
		tabela.setNumRows(0);	
		for(int i = 1; i <= dados.contaSala(); i++) {//Insere os dados do objeto da listaSala na tabela
			
			Sala p = dados.encontraSala(i);
			Object[] fila = {
					p.getCod_sala(),
					p.getLocal(),
					p.getCapacidade(),

			};
			tabela.addRow(fila);
		}
		
		JButton btSalvar = new JButton("Salvar");
		btSalvar.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				try {//caso o usuário insira uma letra onde so pode ser inserido numeros ou ocorra outro erro
					
				//declarações das variáveis 
				int cod_Sala = dados.contaSala() + 1; //recebe o tamnho da listaSala adicionando 1	 
				String Local = txtLocal.getText();
				String Capacidadex = txtCapacidade.getText();
				
				if(Local.equalsIgnoreCase("") || Capacidadex.equalsIgnoreCase("")) { //uma das casa estiver vazia retornara uma mensagem
					JOptionPane.showMessageDialog(null, "Erro: Preencha todos os dados!");}
				
				else { //caso não ocorra continuara o codigo
					
				int Capacidade = Integer.parseInt(Capacidadex); //passa String para int
		
				Sala sala= new Sala(cod_Sala, Local, Capacidade); //cria um no objeto ja passando parametros
				dados.addSala(sala);
				dados.persisteSala();//salva dentro do arquivo
				
				txtCod_Sala.setText("" + cod_Sala); //mostra para o usuário o cod. da Sala
				
				tabela.setNumRows(0);	
				for(int i = 1; i <= dados.contaSala(); i++) { //repete o mesmo processo da tabela anteriror, mas adicionado o objeto cadastrado
					
					Sala p = dados.encontraSala(i);
					Object[] fila = {
							p.getCod_sala(),
							p.getLocal(),
							p.getCapacidade(),

					};
					tabela.addRow(fila);
				}
				
				JOptionPane.showMessageDialog(null, "Sala cadastrada com sucesso!"); //apos tudo realizado mostra a que foi cadastrado
				

				}
			}catch(Exception erro) {JOptionPane.showMessageDialog(null, "Erro: Algum dado foi inserido de forma incorreta!");}
			}
		});
		btSalvar.setBounds(346, 70, 102, 34);
		getContentPane().add(btSalvar);
		
		JButton btLimpar = new JButton("Limpar");
		btLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//botão limpar limpa os campos
				txtCod_Sala.setText("");
				txtLocal.setText("");
				txtCapacidade.setText("");
			}
		});
		btLimpar.setBounds(346, 115, 102, 34);
		getContentPane().add(btLimpar);

	}
}
