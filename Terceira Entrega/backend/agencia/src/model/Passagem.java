package agenciaViagens;

public class Passagem {

	private int id;
	private String data;
	private String destino;
	private double quantidade;

	public Passagem(int id, String data, String destino, String quantidade, double valor) {
		super();
		this.id = id;
		this.data = data
		this.destino = destino;
		this.quantidade = quantidade;
		this.valor = valor;
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getData() {
		return this.data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public String getDestino() {
		return this.destino;
	}

	public void setDestino(String destino) {
		this.destino = destino;
	}

	public String getquantidade() {
		return this.quantidade;
	}

	public void setquantidade(String quantidade) {
		this.quantidade = quantidade;

	}


	public double getvalor() {
		return this.valor;
	}

	public void setValor(double valor) {
		this.valor = valor;

	}
@Override
	public String toString() {
		return "Passagem [id_passagem=" + id_passagem+ ", data=" + data + ", destino=" + destino + ", quantidade=" + quantidade + ",valor=" + valor "]";
	}
	
	
	@Override
	public int hashCode() {
		return Objects.hash(id_passagem, data, destino, quantidade, valor);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Aluno other = (Aluno) obj;
		return id_passagem == other.id_passagem && data == other.data && Objects.equals(destino, other.destino)
				&& Objects.equals(quantidade, other.quantidade) && Objects.equals(valor, other.valor);
	}

}