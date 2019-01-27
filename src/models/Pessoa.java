package models;

public class Pessoa {

	TipoS a = new TipoS();
	
	
	 Long id;
	String nome;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	String cpf;
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public String getCidade() {
		return cidade;
	}
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	public String getSexo() {
		return sexo;
	}
	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
	public String getAcao() {
		return acao;
	}
	public void setAcao(String acao) {
		this.acao = acao;
	}
	public String getTipoSangue() {
		return tipoSangue;
	}
	public void setTipoSangue(String tipoSangue) {
		this.tipoSangue = tipoSangue;
	}
	String endereco;
	String email;
	String estado;
	String cidade;
	String sexo;
	String acao;
	String tipoSangue;
	
	Hospital hospital;
	String padrao;
	
	
	public String getPadrao() {
		return padrao;
	}
	public void setPadrao(String padrao) {
		this.padrao = padrao;
	}
	public Hospital getHospital() {
		return hospital;
	}
	public TipoS getA() {
		return a;
	}
	public void setA(TipoS a) {
		this.a = a;
	}
	public String getNecessidade() {
		return necessidade;
	}
	public void setNecessidade(String necessidade) {
		this.necessidade = necessidade;
	}
	public void setHospital(Hospital hospital) {
		this.hospital = hospital;
	}
	Long vinculoHospital;
	public Long getVinculoHospital() {
			return vinculoHospital;
		}
		public void setVinculoHospital(Long vinculoHospital) {
			this.vinculoHospital = vinculoHospital;
		}
		
		String necessidade;
		
		
}
