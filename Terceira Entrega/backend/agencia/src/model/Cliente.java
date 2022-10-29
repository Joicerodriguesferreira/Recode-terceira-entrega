package agenciaViagens;


public class Cliente {

	private int id;
	private String cpf;
	private String nome;
	private String telefone;
	private String dataNascimento;
	

	public Cliente(int id, String cpf, String nome, String telefone, String dataNascimento) {

		this.id = id;
		this.cpf = cpf;
		this.nome = nome;
		this.telefone = telefone;
		this.dataNascimento = dataNascimento;


	}

	public Cliente() {

	}

	public String getCpf() {
		return this.cpf;
	}

	public void setCpf(String meuCpf) {
		this.cpf = meuCpf;
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCpf() {
		return this.cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getTelefone() {
		return this.telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getDataNascimento() {
		return this.dataNascimento;
	}

	public void setDataNascimento(String dataNascimento) {
		this.dataNascimento = dataNascimento;
	}


	//public void AdicionaCliente(Cliente cliente) {
	//	cliente.add(cliente);
	//}
	
	//public void RemoveCliente(Cliente cliente) {
	//	cliente.remove(cliente);
	//}


	public void verificarCpf(String meuCpf) {
		// código
	}
@Override
	public String toString() {
		return "Cliente [id_cliente=" + id_cliente + ", nome=" + nome + ", cpf=" + cpf + ", telefone=" + telefone + ",dataNascimento " + dataNascimento];
	}
	
	
	@Override
	public int hashCode() {
		return Objects.hash(id_cliente, cpf, telefone, dataNascimento);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cliente other = (Cliente) obj;
		return id_cliente == other.id_cliente && cpf == other.cpf && Objects.equals(nome, other.nome)
				&& Objects.equals(telefone, other.stelefone) && Objects.equals(tdataNascimento, other.dataNascimento);
	}
}
