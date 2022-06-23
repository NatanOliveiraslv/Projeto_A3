package Telas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JDesktopPane;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.text.ParseException;
import java.awt.event.ActionEvent;

public class jfprincipal extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		//Alterar a aparencia
		try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException| javax.swing.UnsupportedLookAndFeelException ex) {
            System.err.println(ex);}
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					jfprincipal frame = new jfprincipal();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @throws ParseException 
	 */
	public jfprincipal() {
		setTitle("Projeto A3");
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		int x = 4000;
		int y = 4000;
		setBounds(0, 0, y, x);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JDesktopPane jdpprincipal = new JDesktopPane();
		jdpprincipal.setBounds(0, 0, x, y);
		contentPane.add(jdpprincipal);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, x, 22);
		
		JMenu mnNewMenu_2 = new JMenu("Aluno");
		menuBar.add(mnNewMenu_2);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("Cadastro de alunos");
		mnNewMenu_2.add(mntmNewMenuItem_1);
		mntmNewMenuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				jfcadastroAluno obj; //Declara um objeto
				try {
					obj = new jfcadastroAluno(); //Instacia o objeto
					jdpprincipal.add(obj); //Adiciona o objeto a tela princiapal
					obj.setVisible(true); //Torna ele vivsivel
				} catch (ParseException | ClassNotFoundException | IOException e1) {
					// TODO Bloco catch gerado automaticamente
					e1.printStackTrace();
				}
				
			}
		});
		
		JMenu mnNewMenu_2_1 = new JMenu("Professor");
		menuBar.add(mnNewMenu_2_1);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Cadastro de porfessor");
		mnNewMenu_2_1.add(mntmNewMenuItem);
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				jfcadastroProfessor obj; //Declara um objeto
				try {
					obj = new jfcadastroProfessor();  //Instacia o objeto
					jdpprincipal.add(obj); //Adiciona o objeto a tela princiapal
					obj.setVisible(true); //Torna ele vivsivel
				} catch (ParseException | ClassNotFoundException | IOException e1) {
					// TODO Bloco catch gerado automaticamente
					e1.printStackTrace();
				}
				
			}
		});
		
		JMenu mnNewMenu = new JMenu("Sala");
		menuBar.add(mnNewMenu);
		jdpprincipal.setLayout(null);
		
		JMenuItem mntmCadastroDeSala = new JMenuItem("Cadastro de Sala");
		mntmCadastroDeSala.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				jfcadastroSala obj; //Declara um objeto
				try {
					obj = new jfcadastroSala();  //Instacia o objeto
					jdpprincipal.add(obj); //Adiciona o objeto a tela princiapal
					obj.setVisible(true); //Torna ele vivsivel
				} catch (ParseException | ClassNotFoundException | IOException e1) {
					// TODO Bloco catch gerado automaticamente
					e1.printStackTrace();
				}
			}
		});
		mnNewMenu.add(mntmCadastroDeSala);
		jdpprincipal.add(menuBar);
		
		JMenu mnNewMenu_1 = new JMenu("Curso");
		menuBar.add(mnNewMenu_1);
		
		JMenuItem mntmNewMenuItem_2 = new JMenuItem("Cadastro de curso");
		mntmNewMenuItem_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				jfcadastroCurso obj; //Declara um objeto
				try {
					obj = new jfcadastroCurso();  //Instacia o objeto
					jdpprincipal.add(obj); //Adiciona o objeto a tela princiapal
					obj.setVisible(true); //Torna ele vivsivel
				} catch (ParseException | ClassNotFoundException | IOException e1) {
					// TODO Bloco catch gerado automaticamente
					e1.printStackTrace();
				}
			}
		});
		mnNewMenu_1.add(mntmNewMenuItem_2);
		
		JMenuItem mntmNewMenuItem_4 = new JMenuItem("Inserir e listar alunos");
		mntmNewMenuItem_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				jflistaCurso obj; //Declara um objeto
				try {
					obj = new jflistaCurso();  //Instacia o objeto
					jdpprincipal.add(obj); //Adiciona o objeto a tela princiapal
					obj.setVisible(true); //Torna ele vivsivel
				} catch (ParseException | ClassNotFoundException | IOException e1) {
					// TODO Bloco catch gerado automaticamente
					e1.printStackTrace();
				}
			}
		});
		mnNewMenu_1.add(mntmNewMenuItem_4);
		
	}
}
