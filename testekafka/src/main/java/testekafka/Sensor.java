package testekafka;

import java.util.UUID;  //biblioteca para gerar um ID único para o sesnor

//classe do sensor com gets e sets e toString
public class Sensor {
	
	private String id;
	private String nome;
	private Double valor;
	private Double maxValor;
	private Double minValor;
	
	public Sensor() {
		this.id = UUID.randomUUID().toString();
	}
	
	public Sensor(String nome, Double valor) {
		super();
		this.nome = nome;
		this.valor = valor;
		this.maxValor = valor;
		this.minValor = valor;
		this.id = UUID.randomUUID().toString(); //gerando id único para o sensor
	}

	public String getNome() {
		return nome;
	}
	
	public String getId() {
		return id;
	}
	
	@Override
	public String toString() {
		return "Sensor [id=" + id + ", nome=" + nome + ", valor=" + valor + ", maxValor=" + maxValor + ", minValor=" + minValor + "]";
	}

	public Double getValor() {
		return valor;
	}
	
	public Double getMaxValor() {
		return maxValor;
	}
	
	public Double getMinValor() {
		return minValor;
	}
	
	//método usado para modificar o valor do sensor e pegar o menor e meior vaalor já registrado
	public void setValor(double valor) {
		this.valor = valor;
		
		if(valor > this.maxValor) {
			this.maxValor = valor;
		}
		if(valor < minValor) {
			this.minValor = valor;
		}
	}
		

}