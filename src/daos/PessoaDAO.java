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
		
		
			
				stmt.setString(1, pessoa.getNome());
				stmt.setString(2, pessoa.getCpf());
				stmt.setString(3, pessoa.getEndereco());
				stmt.setString(4, pessoa.getEmail());
				stmt.setString(5, pessoa.getEstado());
				stmt.setString(6, pessoa.getCidade());
				stmt.setString(7, pessoa.getSexo());
				stmt.setString(8, pessoa.getAcao());
				stmt.setString(9, pessoa.getTipoSangue());
				pessoa.setVinculoHospital(pessoa.getHospital().getId());
				stmt.setLong(10, pessoa.getVinculoHospital());
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
				pessoa.setCpf(rs.getString("cpf"));
				pessoa.setTipoSangue(rs.getString("tipoSangue"));
				pessoa.setEstado(rs.getString("estado"));
				pessoa.setNecessidade(rs.getString("necessidade"));
				pessoa.setVinculoHospital(rs.getLong("VinculoHospital"));
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
	
	public boolean pedirDoacao(Pessoa pessoa) {

		
			String sql = "update pessoa set necessidade=? where id=?;";
			try {
				PreparedStatement stmt = connection.prepareStatement(sql);
				stmt.setString(1, pessoa.getNecessidade());
			
			
				stmt.execute();
				stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
				return false;
			}
			return true;
	}
	
	public boolean LanceNecessariodapeticaodeDOACAO(Pessoa pessoa) {

		
		String sql = "update pessoa set necessidade=? where id=?;";
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setString(1, pessoa.getNecessidade());
			selectSanguById(pessoa);
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
}



public List<Pessoa> selectSanguById(Pessoa pessoa) {
	List<Pessoa> result = new ArrayList<>();

	try {
		PreparedStatement stmt = this.connection.prepareStatement("select tipoSangue from pessoa where id=?");
		ResultSet rs = stmt.executeQuery();
		
		
		stmt.setLong(1, pessoa.getId());
		System.out.println("id" + pessoa.getId());
		while (rs.next()) {
		
		
		
		pessoa.setTipoSangue(rs.getString("tipoSangue"));
		
		System.out.println(pessoa.getTipoSangue());
		//listaparaUsoDoCaralho(pessoa);
			
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



public Pessoa getById(Pessoa pessoa) {
	Pessoa result = null;

	try {
		PreparedStatement stmt = this.connection.prepareStatement("select tipoSangue from pessoa where id=?;");
		System.out.println("id"+ pessoa.getId());
		stmt.setLong(1, pessoa.getId());
		ResultSet rs = stmt.executeQuery();

		if (rs.next()) {
			// criando o objeto speaker
			result = new Pessoa();
			result.setNome(rs.getString("tipoSangue"));
			
		}
		System.out.println(rs.getString("tipoSangue"));
		//selectDePessoasPeloSangue(pessoa);
		LancerPadraoMaisNecessidade(pessoa);
		getListaSelect(pessoa);
		rs.close();
		stmt.close();
	} catch (SQLException e) {
		e.printStackTrace();
	}

	return result;
}
public boolean LancerPadraoMaisNecessidade(Pessoa pessoa) {

	
	String sql = "update pessoa set necessidade=? where id=?";
	try {
		PreparedStatement stmt = connection.prepareStatement(sql);
	
	System.out.println(pessoa.getNecessidade());
		stmt.setString(1, "1");
		stmt.setLong(2, pessoa.getId());
		stmt.execute();
		stmt.close();
	} catch (SQLException e) {
		e.printStackTrace();
		return false;
	}
	return true;
}
public List<Pessoa> listaparaUsoDoCaralho(Pessoa pessoa) {
	List<Pessoa> result = new ArrayList<>();

	try {
		PreparedStatement stmt = this.connection.prepareStatement("select * FROM PESSOA WHERE tipoSangue=?");
		ResultSet rs = stmt.executeQuery();
		
		
		stmt.setString(1, pessoa.getTipoSangue());
		
		
		
		while (rs.next()) {
			
			pessoa.setTipoSangue(rs.getString("tipoSangue"));
		
		
		LancerPadraoMais(pessoa);
			
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

public Pessoa selectDePessoasPeloSangue(Pessoa pessoa) {
	Pessoa result = null;

	try {
		PreparedStatement stmt = this.connection.prepareStatement("select * FROM PESSOA WHERE tipoSangue=?;");
		stmt.setString(1, pessoa.getTipoSangue());
		ResultSet rs = stmt.executeQuery();

		while (rs.next()) {
		
			result = new Pessoa();
			result.setId(rs.getLong("id"));
			result.setNome(rs.getString("nome"));
			System.out.println(rs.getString("nome"));
			System.out.println("o id"+ rs.getLong("id"));
			LancerPadraoMais(pessoa);

		}
		rs.close();
		stmt.close();
	} catch (SQLException e) {
		e.printStackTrace();
	}

	return result;
}
public List<Pessoa> getListaSelect(Pessoa pessoa) {
	List<Pessoa> result = new ArrayList<>();

	try {
		PreparedStatement stmt = this.connection.prepareStatement("select * FROM PESSOA WHERE tipoSangue=?;");
		ResultSet rs = stmt.executeQuery();

		while (rs.next()) {
			
		
			stmt.setString(1, pessoa.getTipoSangue());
			pessoa.setId(rs.getLong("id"));
			pessoa.setNome(rs.getString("nome"));
			pessoa.setEmail(rs.getString("email"));
			pessoa.setEndereco(rs.getString("endereco"));  
			pessoa.setAcao(rs.getString("acao"));
			pessoa.setCidade(rs.getString("sexo"));
			pessoa.setCpf(rs.getString("sexo"));
			pessoa.setTipoSangue(rs.getString("tipoSangue"));
			pessoa.setEstado(rs.getString("estado"));
			LancerPadraoMais(pessoa);
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
public boolean LancerPadraoMais(Pessoa pessoa) {

	
	String sql = "update pessoa set necessidade=? where id=?";
	try {
		PreparedStatement stmt = connection.prepareStatement(sql);
	
	System.out.println(pessoa.getNecessidade());
		stmt.setString(1, "1");
		stmt.setLong(2, pessoa.getId());
		stmt.execute();
		stmt.close();
	} catch (SQLException e) {
		e.printStackTrace();
		return false;
	}
	return true;
}
}
