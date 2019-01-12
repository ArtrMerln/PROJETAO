package daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import models.Hospital;

public class HospitalDAO {
	private Connection connection;


public HospitalDAO()
{
	connection = ConnectionFactory.getConnection();
}


public boolean inserir(Hospital hospital) {
	
	
	String sql = "insert into hospital (nome, cnpj, endereco, email, estado, cidade) values (?,?,?,?,?,?)";

	try {
		PreparedStatement stmt = connection.prepareStatement(sql);
	

		
		
			stmt.setString(1, hospital.getNome());
			stmt.setString(2, hospital.getCnpj());
			stmt.setString(3, hospital.getEndereco());
			stmt.setString(4, hospital.getEmail());
			stmt.setString(5, hospital.getEstado());
			stmt.setString(6, hospital.getCidade());
		
						stmt.execute();
			stmt.close();
		
	} catch (SQLException e) {
		e.printStackTrace();
		return false;
	}
	return true;

}

public List<Hospital> getLista() {
	List<Hospital> result = new ArrayList<>();

	try {
		PreparedStatement stmt = this.connection.prepareStatement("select * from hospital;");
		ResultSet rs = stmt.executeQuery();

		while (rs.next()) {
			// criando o objeto Contato
			Hospital hospital = new Hospital();
			hospital.setId(rs.getLong("id"));
			hospital.setNome(rs.getString("nome"));
			hospital.setEmail(rs.getString("email"));
		    hospital.setEndereco(rs.getString("endereco"));
  
		    hospital.setCidade(rs.getString("cidade"));
		    hospital.setCnpj(rs.getString("cnpj"));
		    
		    
		    
		    
			result.add(hospital);
		}
		rs.close();
		stmt.close();
	} catch (SQLException e) {
		e.printStackTrace();
	}

	return result;
}

	
	
	
	
	
}
















































