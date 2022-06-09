package Telas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class TelaCadastroAluno {

	private JFrame frame;
	private JTextField txtNome;
	private JTextField txtCPF;
	private JTextField txtEndereco;
	private JTextField txtEmail;
	private JTextField txtCelular;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaCadastroAluno window = new TelaCadastroAluno();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public TelaCadastroAluno() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 390, 444);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNome = new JLabel("Nome:");
		lblNome.setVerticalAlignment(SwingConstants.TOP);
		lblNome.setFont(new Font("Arial", Font.PLAIN, 14));
		lblNome.setBounds(20, 23, 49, 24);
		frame.getContentPane().add(lblNome);
		
		JLabel lblCpf = new JLabel("CPF: ");
		lblCpf.setVerticalAlignment(SwingConstants.TOP);
		lblCpf.setFont(new Font("Arial", Font.PLAIN, 14));
		lblCpf.setBounds(20, 70, 49, 24);
		frame.getContentPane().add(lblCpf);
		
		JLabel lblEndereo = new JLabel("Endereço: ");
		lblEndereo.setVerticalAlignment(SwingConstants.TOP);
		lblEndereo.setFont(new Font("Arial", Font.PLAIN, 14));
		lblEndereo.setBounds(20, 117, 69, 24);
		frame.getContentPane().add(lblEndereo);
		
		JLabel lblEmail = new JLabel("Email: ");
		lblEmail.setVerticalAlignment(SwingConstants.TOP);
		lblEmail.setFont(new Font("Arial", Font.PLAIN, 14));
		lblEmail.setBounds(20, 164, 49, 24);
		frame.getContentPane().add(lblEmail);
		
		JLabel lblCelular = new JLabel("Celular: ");
		lblCelular.setVerticalAlignment(SwingConstants.TOP);
		lblCelular.setFont(new Font("Arial", Font.PLAIN, 14));
		lblCelular.setBounds(20, 211, 69, 24);
		frame.getContentPane().add(lblCelular);
		
		txtNome = new JTextField();
		txtNome.setBounds(95, 23, 211, 20);
		frame.getContentPane().add(txtNome);
		txtNome.setColumns(10);
		
		txtCPF = new JTextField();
		txtCPF.setColumns(10);
		txtCPF.setBounds(95, 69, 211, 20);
		frame.getContentPane().add(txtCPF);
		
		txtEndereco = new JTextField();
		txtEndereco.setColumns(10);
		txtEndereco.setBounds(95, 115, 211, 20);
		frame.getContentPane().add(txtEndereco);
		
		txtEmail = new JTextField();
		txtEmail.setColumns(10);
		txtEmail.setBounds(95, 161, 211, 20);
		frame.getContentPane().add(txtEmail);
		
		txtCelular = new JTextField();
		txtCelular.setColumns(10);
		txtCelular.setBounds(95, 207, 211, 20);
		frame.getContentPane().add(txtCelular);
		
		JButton btCadastrar = new JButton("Cadastrar");
		btCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				System.out.print("teste");
			}
		});
		btCadastrar.setBounds(126, 284, 122, 44);
		frame.getContentPane().add(btCadastrar);
	}
}
