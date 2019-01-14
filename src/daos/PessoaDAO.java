package daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import models.Hospital;
import models.Pessoa;

public class PessoaDAO {
	private Connection connection;

	public PessoaDAO() {
		connection = ConnectionFactory.getConnection();

	}
	public boolean inserir(Pessoa pessoa) {

		String sql = "insert into Pessoa (nome, cpf, endereco, email, estado, cidade, sexo, acao, tipoSangue, vinculoHospital) values (?,?,?,?,?,?,?,?,?,?)";

		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
		
Hospital hosp = new Hospital();			
			
				stmt.setString(1, pessoa.getNome());
				stmt.setString(2, pessoa.getCpf());
				stmt.setString(3, pessoa.getEndereco());
				stmt.setString(4, pessoa.getEmail());
				stmt.setString(5, pessoa.getEstado());
				stmt.setString(6, pessoa.getCidade());
				stmt.setString(7, pessoa.getSexo());
				stmt.setString(8, pessoa.getAcao());
				stmt.setString(9, pessoa.getTipoSangue());
				stmt.setLong(10, hosp.getId());
							stmt.execute();
				stmt.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;

	}
	
	public List<Pessoa> getLista() {
		List<Pessoa> result = new ArrayList<>();

		try {
			PreparedStatement stmt = this.connection.prepareStatement("select * from pessoa;");
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				
				Pessoa pessoa = new Pessoa();
				pessoa.setId(rs.getLong("id"));
				pessoa.setNome(rs.getString("nome"));
				pessoa.setEmail(rs.getString("email"));
				pessoa.setEndereco(rs.getString("endereco"));
				pessoa.setAcao(rs.getString("acao"));
				pessoa.setCidade(rs.getString("sexo"));
				pessoa.setCpf(rs.getString("sexo"));
				pessoa.setTipoSangue(rs.getString("tipoSangue"));
				pessoa.setEstado(rs.getString("estado"));
				
				// adicionando o objeto 
				result.add(pessoa);
			}
			rs.close();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return result;
	}
	
	
	
	
}
