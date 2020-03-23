package view;

import java.awt.EventQueue;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import controller.PessoaController;

public class ViewPessoa extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField tfCpf;
	private JTextField tfNome;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ViewPessoa frame = new ViewPessoa();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public ViewPessoa() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("CPF:");
		lblNewLabel.setBounds(57, 75, 46, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Nome:");
		lblNewLabel_1.setBounds(57, 122, 46, 14);
		contentPane.add(lblNewLabel_1);
		
		tfCpf = new JTextField();
		tfCpf.setBounds(143, 72, 86, 20);
		contentPane.add(tfCpf);
		tfCpf.setColumns(10);
		
		tfNome = new JTextField();
		tfNome.setBounds(143, 119, 216, 20);
		contentPane.add(tfNome);
		tfNome.setColumns(10);
		
		JButton btEnviar = new JButton("Enviar");
		btEnviar.setBounds(171, 171, 89, 23);
		contentPane.add(btEnviar);
		
		ActionListener chamadaPessoa = new PessoaController(tfCpf, tfNome);
		btEnviar.addActionListener(chamadaPessoa);
		tfNome.addActionListener(chamadaPessoa);
	}
}
