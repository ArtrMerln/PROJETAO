package daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import models.Pessoa;

public class PessoaDAO {
	private Connection connection;

	public PessoaDAO() {
		connection = ConnectionFactory.getConnection();

	}
	public boolean inserir(Pessoa pessoa) {

		String sql = "insert into Pessoa (nome, cpf, endereco, email, estado, cidade, sexo, acao, tipoSangue) values (?,?,?,?,?,?,?,?,?)";

		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
		

			
			
				stmt.setString(1, pessoa.getNome());
				stmt.setString(2, pessoa.getCpf());
				stmt.setString(3, pessoa.getEndereco());
				stmt.setString(4, pessoa.getEmail());
				stmt.setString(5, pessoa.getEstado());
				stmt.setString(6, pessoa.getCidade());
				stmt.setString(7, pessoa.getSexo());
				stmt.setString(8, pessoa.getAcao());
				stmt.setString(9, pessoa.getTipoSangue());
				
							stmt.execute();
				stmt.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;

	}
	
	
	
	
	
	
}
