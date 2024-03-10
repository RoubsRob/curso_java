package application;

import util.Functions;
import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import java.util.Scanner;

import entities.Conta;

public class Program {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		
		List<Conta> contas = new ArrayList<>();
		
		List<String[]> historico = new ArrayList<>();

		int opt2 = 10;
		
		while (opt2 != 8) {
			System.out.println("Digite:"+"\n"+"[1] Para cadastrar uma nova conta"+"\n"+"[2] Para fazer um depósito"+"\n"+
		"[3] Para fazer um saque"+"\n"+"[4] Para alterar o limite"+"\n"
					+"[5] Para fazer uma transferência"+"\n"
		+"[6] Para exportar o histórico de transações"+"\n"
		+"[7] Para verificar o saldo"+"\n"+"[8] Para encerrar o sistema");
			opt2 = sc.nextInt();
			switch (opt2) {
			case 1://cadastro de conta			
				Conta conta;
				
				//System.out.println("Entre com o número da conta:");
				//int numero = sc.nextInt();
				
				System.out.println("Entre com o nome do titular da conta:");
				sc.nextLine();
				String nome = sc.nextLine();
				
				System.out.println("Entre com o valor de limite da conta:");
				double limite = sc.nextDouble();			
				/*				
				System.out.println("Digite:"+"\n"+"[1] Para fazer um depósito"+"\n"+"[2] Para criar a conta sem depósito");
				int opt = sc.nextInt();
				
				if (opt == 1) {
					System.out.println("Entre com o valor do depósito inicial:");
					double deposito = sc.nextDouble();			
					conta = new Conta(numero,nome,deposito);
				}else {
					conta = new Conta(numero,nome);
				}*/
						
				conta = new Conta(contas.size()+1,nome,limite);
				/*init teste array contas*/
				contas.add(conta);
				/*Fim teste array contas*/
				
				System.out.println("total de contas:"+contas.size());
				//System.out.println("Conta criada com sucesso!");
				//System.out.println("Detalhes da conta:"+conta);
				Date data = new Date();
				Instant instant = data.toInstant() ;
				ZoneId z = ZoneId.of("America/Sao_Paulo" ) ;
				ZonedDateTime zdt = instant.atZone( z ) ;
				
				historico.add(new String[]{ zdt+"Conta criada! Cliente: "+nome+"\n" });
				
				break;
				
			case 2://deposito em conta
				try {
					System.out.println("Entre com número de conta para o depósito:");
					int numContaDeposito = sc.nextInt();
					Conta contaDeposito = contas.get(numContaDeposito-1);
					System.out.println("Entre com valor para o depósito:");
					double deposito = sc.nextDouble();
					contaDeposito.depositoConta(deposito);
					historico.add(new String[]{"Deposito realizado no valor de : "+deposito+"\n" });

				}catch(IndexOutOfBoundsException e) {
					System.out.println("Conta inválida!");
					//System.out.println("Conta inválida!"+"\n"+"A partir do menu selecione uma operação novamente.");
					break;
				}

				//System.out.println("Valor depositado com sucesso!"+"\n");
				//System.out.println("Detalhes da conta:"+conta);
				

				
				break;
			case 3://saque de conta
				try {
					System.out.println("Entre com número de conta para o saque:");
					int numContaSaque = sc.nextInt();
					Conta contaSaque = contas.get(numContaSaque-1);			
					System.out.println("Entre com valor para o saque:");
					double saque = sc.nextDouble();
					contaSaque.saqueConta(saque);
					historico.add(new String[]{"Saque realizado no valor de : "+saque+"\n" });

				}catch(IndexOutOfBoundsException e) {
					System.out.println("Conta inválida!");
					break;
				}
				//System.out.println("Valor sacado com sucesso!"+"\n");
				//System.out.println("Detalhes da conta:"+conta);
			
				break;
			case 4:
				try {
					System.out.println("Entre com número de conta para alterar limite:");
					int numContaLimite = sc.nextInt();
					Conta contaLimite = contas.get(numContaLimite-1);			
					System.out.println("Entre com novo limite:");
					double limiteNovo = sc.nextDouble();
					contaLimite.setLimiteConta(limiteNovo);
					System.out.println("O novo limite da conta é:"+contaLimite.getLimiteConta());
					historico.add(new String[]{"Limite alterado para o valor de : "+limiteNovo+"\n" });

				}catch(IndexOutOfBoundsException e) {
					System.out.println("Conta inválida!");
					break;
				}
				break;
			case 5://transferencia entre contas
				System.out.println("Entre com número de conta de origem:");
				int numContaOrigem = sc.nextInt();
				Conta contaOrigem = contas.get(numContaOrigem-1);
				System.out.println("Entre com número de conta de destino:");
				int numContaDestino = sc.nextInt();
				Conta contaDestino = contas.get(numContaDestino-1);
				
				System.out.println("Entre com valor para transferencia:");
				double valorTransferencia = sc.nextDouble();
				contaOrigem.transferenciaContas(valorTransferencia,contaDestino,contaOrigem);
				System.out.println("Valor transferido com sucesso!"+"\n");
				//System.out.println("Detalhes da conta:"+conta);
				
				historico.add(new String[]{"Valor de : "+valorTransferencia+" transferido para a conta "+contaDestino+" de conta "+contaOrigem+"\n" });
				break;
			case 6:
				Functions.printCSV(historico);
				historico.add(new String[]{"Historico solicitado "+"\n" });

				//public void givenDataArray_whenConvertToCSV_thenOutputCreated() throws IOException {
				
				break;
			case 7:
				System.out.println("Entre com número de conta para visualizar o saldo:");
				int numContaSaldo = sc.nextInt();
				Conta contaSaldo = contas.get(numContaSaldo-1);
				//contaSaldo.getSaldoConta();
				System.out.println("Valor em conta:"+contaSaldo.getSaldoConta()+"\n");
				//System.out.println("Detalhes da conta:"+conta);
				historico.add(new String[]{"Saldo visualizado "+"\n" });

				break;
			case 8:
				System.out.println("Obrigada por utilizar!");
				break;				
			default:
				System.out.println("Opção inválida!");
			}
		}
		
		sc.close();

	}

}
