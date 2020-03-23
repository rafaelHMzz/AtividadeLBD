package persistence;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Types;

import model.Pessoa;

public class PessoaDao {
	
	private Connection c;
	
	public PessoaDao() throws ClassNotFoundException, SQLException {
		GenericDao gDao = new GenericDao();
		c = gDao.getConnection();
	}

	public String pPessoa(Pessoa p) throws SQLException {
		String sql = "{CALL inserepessoa(?,?,?)}";
		CallableStatement cs = c.prepareCall(sql);
		cs.setString(1, p.getCpf());
		cs.setString(2, p.getNome());
		cs.registerOutParameter(3, Types.VARCHAR);
		cs.execute();
		String saida = cs.getString(3);
		cs.close();
		
		return saida;
	}
}
