package logistica;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import entidade.Cliente;
import entidade.ItensDoPedido;
import entidade.Pedido;
import entidade.Produto;
import enuns.StatusPedido;

public class Programa {

	public static void main(String[] args) throws ParseException {
		
		SimpleDateFormat sdf2 = new SimpleDateFormat("dd/MM/yyyy");
		Locale.setDefault(Locale.US);
		Scanner teclado = new Scanner(System.in);
		
		System.out.println("Dados do cliente: ");
		System.out.print("Nome: ");
		String nome = teclado.nextLine();
		System.out.print("Email: ");
		String email = teclado.nextLine();
		System.out.print("Data de nascimento (DD/MM/YYYY): ");
		Date data = sdf2.parse(teclado.next());
		System.out.println("Entre com os dados do pedido:");
		System.out.print("Staus: ");
		StatusPedido status = StatusPedido.valueOf(teclado.next());
		
		Pedido P = new Pedido(new Date(),status,new Cliente(nome, email, data));
		
		System.out.print("Quantos itens para esse pedido? ");
		int n = teclado.nextInt();
		
		for(int i = 1;i <= n;i++) {
			System.out.println("Dados do #"+i+" item: ");
			System.out.print("Nome do produto: ");
			teclado.nextLine();//Limpar o buffer
			String nomeP = teclado.nextLine();
			System.out.print("Preço do produto: ");
			double preco = teclado.nextDouble();
			System.out.print("Quantidade: ");
			int quantia = teclado.nextInt();
			
			ItensDoPedido item = new ItensDoPedido(quantia, preco, new Produto(nomeP, preco));
			P.addPedido(item);
			
			
		}
		
		System.out.println(P);
		
		
		
	}

}
