package testekafka;

import java.util.UUID;  //biblioteca para gerar um ID único para o sesnor

//classe do sensor com gets e sets e toString
public class Sensor {
	
	private String id;
	private String nome;
	private Double valor;
	private Double maxValor;
	private Double minValor;
	private Double media;
	private int leituras;
	
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
		this.leituras = 1;
		this.media = valor;
	}

	public String getNome() {
		return nome;
	}
	
	public String getId() {
		return id;
	}
	
	@Override
	public String toString() {
		return "Sensor [id=" + id + ", nome=" + nome + ", valor=" + valor + ", maxValor=" + maxValor + ", minValor="
				+ minValor + ", media=" + media + ", leituras=" + leituras + "]";
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
	public void setValor(Double valor) {
		this.valor = valor;
		leituras = leituras + 1;
	}
	
	public void setMaxValor(Double valor) {
		this.maxValor = valor;
	}
	
	public void setMinValor(Double valor) {
		this.minValor = valor;
	}

	public int getLeituras() {
		return leituras;
	}

	public Double getMedia() {
		return media;
	}
	
	public void setMedia(Double media) {
		this.media = media;
	}

}
