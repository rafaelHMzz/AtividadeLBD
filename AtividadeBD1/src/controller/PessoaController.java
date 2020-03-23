package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JOptionPane;
import javax.swing.JTextField;

import model.Pessoa;
import persistence.PessoaDao;

public class PessoaController implements ActionListener{
	
	private JTextField tfCpf;
	private JTextField tfNome;
	
	public PessoaController(JTextField tfCpf, JTextField tfNome) {
		this.tfCpf = tfCpf;
		this.tfNome = tfNome;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		try {
			inserePessoa();
		} catch (ClassNotFoundException | SQLException e1) {
			e1.printStackTrace();
		}
	}
	
	private void inserePessoa() throws ClassNotFoundException, SQLException {
		Pessoa p = new Pessoa();
		p.setCpf(tfCpf.getText());
		p.setNome(tfNome.getText());
		
		PessoaDao pDao = new PessoaDao();
		String saida = pDao.pPessoa(p);
		JOptionPane.showMessageDialog(null, saida, "MENSAGEM", JOptionPane.INFORMATION_MESSAGE);
	}

}
