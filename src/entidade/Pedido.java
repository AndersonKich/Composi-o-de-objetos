package entidade;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import enuns.StatusPedido;

public class Pedido {

	
	private  SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
	private SimpleDateFormat sdf2 = new SimpleDateFormat("dd/MM/yyyy");
	
	private Date mometo;
	private StatusPedido status;
	
	private Cliente cliente;
	private List<ItensDoPedido>pedidos = new ArrayList<>();
	
	
	public Pedido() {
	
	}
	
	public Pedido(Date mometo, StatusPedido status, Cliente cliente) {
		
		this.mometo = mometo;
		this.status = status;
		this.cliente = cliente;
	}





	public Date getMometo() {
		return mometo;
	}


	public void setMometo(Date mometo) {
		this.mometo = mometo;
	}


	public StatusPedido getStatus() {
		return status;
	}


	public void setStatus(StatusPedido status) {
		this.status = status;
	}


	public Cliente getCliente() {
		return cliente;
	}


	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}


	public List<ItensDoPedido> getPedidos() {
		return pedidos;
	}

	public void addPedido(ItensDoPedido itens) {
		
		pedidos.add(itens);
		
	}
	
	public void removePedido(ItensDoPedido itens) {
		
		pedidos.remove(itens);
		
	}
	
	public double total() {
		double tot = 0;
		
		for(ItensDoPedido p : pedidos) {
			
			tot += p.subTotal();
		}
		
		return tot;
	}


	@Override
	public String toString() {
		
		StringBuilder sb = new StringBuilder();
		
		sb.append("Resumo do pedido: \n");
		sb.append("Momento: "+ sdf.format(mometo)+"\n");
		sb.append("Status: "+ status +"\n" );
		sb.append("Cliente: "+ cliente.getNome());
		sb.append(" ("+ sdf2.format(cliente.getNascimento())+")");
		sb.append(" - "+ cliente.getEmail()+ "\n");
		sb.append("Itens: \n");
		for(ItensDoPedido p : pedidos) {
			sb.append(p.getProduto().getNome()+",");
			sb.append(" $"+ p.getProduto().getPreco()+",");
			sb.append(" Quantidade: "+p.getQuantidade()+",");
			sb.append(" Subtotal: "+p.subTotal()+"\n");
		}
		
		sb.append("Preco total do pedido: "+String.format("%.2f", total()));
		
		return sb.toString();
		
		
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
}
