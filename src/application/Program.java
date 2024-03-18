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
import entities.enums.TiposConta;

public class Program {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		
		List<Conta> contasAg1 = new ArrayList<>();
		List<Conta> contasAg2 = new ArrayList<>();
		
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
				
				
				try{
				Conta conta;
				
				System.out.println("Entre com o nome do titular da conta:");
				sc.nextLine();
				String nome = sc.nextLine();
				
				System.out.println("Entre com o numero da agência:");
				int agencia = sc.nextInt();
				
				System.out.println("Entre com o valor de limite da conta:");
				double limite = sc.nextDouble();	
				
				System.out.println("Entre com 1 para criar uma conta poupança ou 2 para conta de Débito:");
				int tipoConta = sc.nextInt();
				while (tipoConta != 1 && tipoConta != 2) {
					System.out.println("Entre com 1 para criar uma conta poupança ou 2 para conta de Débito:");
					tipoConta = sc.nextInt();
				}
				
				TiposConta contaTipo = TiposConta.POUPANCA;
				
				if (tipoConta == 1) {
					contaTipo = TiposConta.POUPANCA;
				}else if (tipoConta == 2) {
					contaTipo = TiposConta.DEBITO;
				}
						
				if (agencia == 1) {
					conta = new Conta(contasAg1.size()+1,agencia,nome,limite,contaTipo);					
					contasAg1.add(conta);
					historico.add(new String[]{ Functions.dataAgora()+" Conta criada! Cliente: "+conta.getTitularConta()+" Seu número de conta é "+contasAg1.size()+" Agência: "+agencia+"\n" });
					System.out.println("Conta criada! Cliente: "+conta.getTitularConta()+" Seu número de conta é "+contasAg1.size()+" Agência: "+agencia+"\n");
				}else if (agencia == 2) {
					conta = new Conta(contasAg2.size()+1,agencia,nome,limite,contaTipo);					
					contasAg2.add(conta);
					historico.add(new String[]{ Functions.dataAgora()+" Conta criada! Cliente: "+" Seu número de conta é "+contasAg1.size()+" Agência: "+agencia+"\n" });
					System.out.println("Conta criada! Cliente: "+conta.getTitularConta()+" Seu número de conta é "+contasAg1.size()+" Agência: "+agencia+"\n");				
				}else {
					System.out.println("Agencias suportadas: 1 e 2.");
				}

				}catch(Exception e) {System.out.println("Erro durante input. Verifique se os dados entrados estão corretos.");break;}
				
				
				//Tentando componentizar
				//Conta conta = Functions.criaConta(contas);
				//contas.add(conta);
				
				//System.out.println("total de contas:"+contas.size());
				
				break;
				
			case 2://deposito em conta
				try {
					System.out.println("Entre com número de conta para o depósito:");
					int numContaDeposito = sc.nextInt();
					
					System.out.println("Entre com o numero da agência:");
					//sc.nextInt();
					int agencia = sc.nextInt();
					
					if (agencia == 1) {
						Conta contaDeposito = contasAg1.get(numContaDeposito-1);
						System.out.println("Entre com valor para o depósito:");
						double deposito = sc.nextDouble();
						contaDeposito.depositoConta(deposito);
						historico.add(new String[]{Functions.dataAgora()+" Deposito realizado no valor de : "+deposito+"\n" });
					}else if (agencia == 2) {
						Conta contaDeposito = contasAg2.get(numContaDeposito-1);
						System.out.println("Entre com valor para o depósito:");
						double deposito = sc.nextDouble();
						contaDeposito.depositoConta(deposito);
						historico.add(new String[]{Functions.dataAgora()+" Deposito realizado no valor de : "+deposito+"\n" });
					}else {
						System.out.println("Agencias suportadas: 1 e 2.");
					}
					

				}catch(IndexOutOfBoundsException e) {
					System.out.println("Conta inválida!");
					//System.out.println("Conta inválida!"+"\n"+"A partir do menu selecione uma operação novamente.");
					break;
				}
				break;
			case 3://saque de conta
				try {
					System.out.println("Entre com número de conta para o saque:");
					int numContaSaque = sc.nextInt();
					
					System.out.println("Entre com o numero da agência:");
					//sc.nextInt();
					int agencia = sc.nextInt();
					
					if (agencia == 1) {
						Conta contaSaque = contasAg1.get(numContaSaque-1);			
						System.out.println("Entre com valor para o saque:");
						double saque = sc.nextDouble();
						contaSaque.saqueConta(saque);
						historico.add(new String[]{Functions.dataAgora()+" Saque realizado no valor de : "+saque+"\n" });

					}else if (agencia == 2) {
						Conta contaSaque = contasAg2.get(numContaSaque-1);			
						System.out.println("Entre com valor para o saque:");
						double saque = sc.nextDouble();
						contaSaque.saqueConta(saque);
						historico.add(new String[]{Functions.dataAgora()+" Saque realizado no valor de : "+saque+"\n" });

					}else {
						System.out.println("Agencias suportadas: 1 e 2.");
					}
					
					
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
					
					System.out.println("Entre com o numero da agência:");
					//sc.nextInt();
					int agencia = sc.nextInt();
					
					if (agencia == 1) {
						Conta contaLimite = contasAg1.get(numContaLimite-1);			
						System.out.println("Entre com novo limite:");
						double limiteNovo = sc.nextDouble();
						contaLimite.setLimiteConta(limiteNovo);
						System.out.println("O novo limite da conta é:"+contaLimite.getLimiteConta());
						historico.add(new String[]{Functions.dataAgora()+" Limite alterado para o valor de : "+limiteNovo+"\n" });
					}else if (agencia == 2) {
						Conta contaLimite = contasAg2.get(numContaLimite-1);			
						System.out.println("Entre com novo limite:");
						double limiteNovo = sc.nextDouble();
						contaLimite.setLimiteConta(limiteNovo);
						System.out.println("O novo limite da conta é:"+contaLimite.getLimiteConta());
						historico.add(new String[]{Functions.dataAgora()+" Limite alterado para o valor de : "+limiteNovo+"\n" });

					}else {
						System.out.println("Agencias suportadas: 1 e 2.");
					}
					
					

				}catch(IndexOutOfBoundsException e) {
					System.out.println("Conta inválida!");
					break;
				}
				break;
			case 5://transferencia entre contas
				System.out.println("Entre com número de conta de origem:");
				int numContaOrigem = sc.nextInt();
				
				System.out.println("Entre com o numero da agência:");
				//sc.nextInt();
				int agencia = sc.nextInt();
				
				if (agencia == 1) {
					Conta contaOrigem = contasAg1.get(numContaOrigem-1);
					System.out.println("Entre com número de conta de destino:");
					int numContaDestino = sc.nextInt();
					Conta contaDestino = contasAg1.get(numContaDestino-1);
					
					System.out.println("Entre com valor para transferencia:");
					double valorTransferencia = sc.nextDouble();
					contaOrigem.transferenciaContas(valorTransferencia,contaDestino,contaOrigem);
					System.out.println("Valor transferido com sucesso!"+"\n");
					//System.out.println("Detalhes da conta:"+conta);
					
					historico.add(new String[]{Functions.dataAgora()+"Valor de : "+valorTransferencia+" transferido para a conta "+contaDestino+" de conta "+contaOrigem+"\n" });
					
				}else if (agencia == 2) {
					Conta contaOrigem = contasAg2.get(numContaOrigem-1);
					System.out.println("Entre com número de conta de destino:");
					int numContaDestino = sc.nextInt();
					Conta contaDestino = contasAg2.get(numContaDestino-1);
					
					System.out.println("Entre com valor para transferencia:");
					double valorTransferencia = sc.nextDouble();
					contaOrigem.transferenciaContas(valorTransferencia,contaDestino,contaOrigem);
					System.out.println("Valor transferido com sucesso!"+"\n");
					//System.out.println("Detalhes da conta:"+conta);
					
					historico.add(new String[]{Functions.dataAgora()+"Valor de : "+valorTransferencia+" transferido para a conta "+contaDestino+" de conta "+contaOrigem+"\n" });
					
				}else {
					System.out.println("Agencias suportadas: 1 e 2.");
				}
				
				
				break;
			case 6:
				Functions.printCSV(historico);
				historico.add(new String[]{Functions.dataAgora()+" Historico solicitado "+"\n" });

				//public void givenDataArray_whenConvertToCSV_thenOutputCreated() throws IOException {
				
				break;
			case 7:
				System.out.println("Entre com número de conta para visualizar o saldo:");
				int numContaSaldo = sc.nextInt();
				
				System.out.println("Entre com o numero da agência:");
				//sc.nextInt();
				int agenciaSaldo = sc.nextInt();
				
				if (agenciaSaldo == 1) {
					Conta contaSaldo = contasAg1.get(numContaSaldo-1);
					//contaSaldo.getSaldoConta();
					System.out.println("Valor em conta:"+contaSaldo.getSaldoConta()+"\n");
					//System.out.println("Detalhes da conta:"+conta);
					historico.add(new String[]{Functions.dataAgora()+" Saldo visualizado "+"\n" });
				}else if (agenciaSaldo == 2) {
					Conta contaSaldo = contasAg2.get(numContaSaldo-1);
					//contaSaldo.getSaldoConta();
					System.out.println("Valor em conta:"+contaSaldo.getSaldoConta()+"\n");
					//System.out.println("Detalhes da conta:"+conta);
					historico.add(new String[]{Functions.dataAgora()+" Saldo visualizado "+"\n" });
				}else {
					System.out.println("Agencias suportadas: 1 e 2.");
				}
				
				

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
