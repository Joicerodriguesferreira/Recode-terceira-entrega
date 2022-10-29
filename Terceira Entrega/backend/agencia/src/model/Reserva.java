package agenciaViagens;
import java.util.ArrayList;
import java.util.Date;


public class Reserva {

	private int id;
	private Date data;
	private String Destino;
	private Cliente cliente;
	
	

	public Reserva(int id, Date data, Destino destino Cliente cliente) {

		this.id = id;
		this.data = data;
		this.destino = destino;
		this.cliente = cliente;

	}

	public Reserva() {

	}

	public int getId() {
		return this.id;
	}
	
	public void setId(int id) {
		this.id = id;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}
	public String getDestino() {
		return destino;
	}

	public void setDestino(Destino destino) {
		this.destino = destino;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double cvalor {
		this.valor = valor;
	}
	
	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	


	public void mostrarReserva() {
	for (ItemReserva item : itens) {
		System.out.println("Id: " + item.getId() + " QTD: " + item.getQuantidade() + " Valor: " + item.getValor());

	}

}

	
}
