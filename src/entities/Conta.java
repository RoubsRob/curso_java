package entities;

import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Date;

public class Conta {
	private int numeroConta;
	private String titularConta;
	private double saldoConta;
	private double limiteConta;
	
	public Conta() {
	}
/*
	public Conta(int numeroConta, String titularConta, double depositoInicial) {
		this.numeroConta = numeroConta;
		this.titularConta = titularConta;
		depositoConta(depositoInicial);
		setLimiteConta(0);
	}
	*/
	public Conta(int numeroConta, String titularConta) {
		this.numeroConta = numeroConta;
		this.titularConta = titularConta;
		depositoConta(0);
		setLimiteConta(0);
	}
	public Conta(int numeroConta, String titularConta, double limiteConta) {
		this.numeroConta = numeroConta;
		this.titularConta = titularConta;
		this.limiteConta = limiteConta;
		depositoConta(0);
	}
	public int getNumeroConta() {
		return numeroConta;
	}
	
	public void setNumeroConta(int numeroConta) {
		this.numeroConta = numeroConta;
	}

	public String getTitularConta() {
		return titularConta;
	}
	public void setTitularConta(String titularConta) {
		this.titularConta = titularConta;
	}

	public double getSaldoConta() {
		return saldoConta;
	}

	public void depositoConta(double deposito) {
		saldoConta += deposito;
		System.out.println("Valor depositado com sucesso!"+"\n");
	}
	
	public void saqueConta(double saque) {
		if ((saldoConta - saque)< limiteConta) {
			System.out.println("Não é possível ficar abaixo do limite da conta!");
		}else {
			saldoConta = saldoConta - saque /*- 5.00*/;
			System.out.println("Valor sacado com sucesso!");
		}
	}
	
	public void transferenciaContas(double valor, Conta contaDestino, Conta contaOrigem) {
		Date data = new Date();
		Instant instant = data.toInstant() ;
		ZoneId z = ZoneId.of("America/Sao_Paulo" ) ;
		ZonedDateTime zdt = instant.atZone( z ) ;
		
		if(zdt.getHour() < 6 || zdt.getHour() > 18) {
			System.out.println("Não é possível realizar transferências entre 18:00 e 6:00!");
		}else {
			contaDestino.depositoConta(valor);
			contaOrigem.saqueConta(valor);
		}
	}
	
	public double getLimiteConta() {
		return limiteConta;
	}

	public void setLimiteConta(double limiteConta) {
		this.limiteConta = limiteConta;
	}

	@Override
	public String toString() {
		return "Conta  " + numeroConta + ", Titular:" + titularConta + ", Saldo: $" + saldoConta;
	}
	
	

}
