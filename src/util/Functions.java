package util;

import java.io.File;

import java.io.FileWriter;
import java.io.IOException;
import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import entities.Conta;

public final class Functions {
	
	public static void printCSV(List<String[]> historico) {
		File csvFile = new File("operations.csv");
		try {
			
			String[][] employees = {
	                {"Man", "Sparkes", "msparkes0@springhow.com", "Engineering"},
	                {"Dulcinea", "Terzi", "dterzi1@springhow.com", "Engineering"},
	                {"Tamar", "Bedder", "tbedder2@springhow.com", "Legal"},
	                {"Vance", "Scouller", "vscouller3@springhow.com", "Sales"},
	                {"Gran", "Jagoe", "gjagoe4@springhow.com", "Business Development"}
	        };
			
			FileWriter fileWriter = new FileWriter(csvFile);
			//fileWriter.write("Teste");
			//fileWriter.write(line.toString());
			
			 for (String[] data : historico) { //trocar para employees para funcionar :( historico
		            StringBuilder line = new StringBuilder();
		            for (int i = 0; i < data.length; i++) { 	
		                line.append("\"");
		                line.append(data[i].replaceAll("\"","\"\""));
		                line.append("\"");
		                if (i != data.length - 1) {
		                    line.append(',');
		                }
		            }
		            line.append("\n");
		            fileWriter.write(line.toString());
		        }
			 	fileWriter.flush();
		        fileWriter.close();
		    }catch (IOException e) {
			// TODO Auto-generated catch block
				System.out.println("Não é possível exportar arquivo CSV!");
				e.printStackTrace();
		}
	}

	public static ZonedDateTime dataAgora() {
		Date data = new Date();
		Instant instant = data.toInstant() ;
		ZoneId z = ZoneId.of("America/Sao_Paulo" ) ;
		ZonedDateTime zdt = instant.atZone( z ) ;
		return zdt;
	}

	public static Conta retornaConta (List<Conta> contas, String proposito) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Entre com número de conta para "+proposito+" :");
		int numContaDeposito = sc.nextInt();
		Conta contaDeposito = contas.get(numContaDeposito-1);
		return contaDeposito;
	}
	
/*
	public static Conta criaConta (List<Conta> contas) {
		
		String nome = null;
		int agencia = 0;
		double limite = 0;
		
		try {
		Scanner sc = new Scanner(System.in);
		
		//System.out.println("Entre com o número da conta:");
		//int numero = sc.nextInt();
		System.out.println("Entre com o nome do titular da conta:");
		//sc.nextLine();
		nome = sc.nextLine();
		
		System.out.println("Entre com o numero da agência:");
		//sc.nextInt();
		agencia = sc.nextInt();
		
		System.out.println("Entre com o valor de limite da conta:");
		sc.nextLine();
		limite = sc.nextDouble();			
		
		sc.close();
		
		}catch(Exception e) {System.out.println("Erro durante input. Verifique se os dados entrados estão corretos.");}
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
		//Conta conta;		
		//conta = new Conta(contas.size()+1,agencia,nome,limite,);
		/*init teste array contas*/
		//contas.add(conta);
		/*Fim teste array contas*/
		
		
		//return conta;	
	
//}
}
