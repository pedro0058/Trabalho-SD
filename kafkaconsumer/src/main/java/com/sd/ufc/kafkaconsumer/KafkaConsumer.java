package com.sd.ufc.kafkaconsumer;

import org.springframework.stereotype.Service;
import org.springframework.kafka.annotation.KafkaListener;

@Service //indicando que é um componente Spring que fornece serviços de consumo Kafka.
public class KafkaConsumer {

	private Sensor leitura; //é usado para armazenar a última leitura recebida pelo consumidor.
	//private Sensor umidade;
	
	@KafkaListener(topics = "testejava", groupId = "grup-web", containerFactory = "sensorListener") //indicando que ele é um ouvinte de mensagens Kafka.
	public void consume (Sensor sensor ) { //Quando uma mensagem é recebida do tópico especificado, o método consume é invocado.
		//o método simplesmente imprime a mensagem no console e armazena a leitura na variável leitura
		System.out.println("Mensagem consumida: " + sensor);
		
		leitura = sensor;
	}
	
//	@KafkaListener(topics = "testejava2", groupId = "grup-web", containerFactory = "sensorListener") //indicando que ele é um ouvinte de mensagens Kafka.
//	public void consumeUmidade (Sensor sensor ) { //Quando uma mensagem é recebida do tópico especificado, o método consume é invocado.
//		//o método simplesmente imprime a mensagem no console e armazena a leitura na variável leitura
//		System.out.println("Mensagem consumida: " + sensor);
//		
//		umidade = sensor;
//	}
	
	public Sensor getLeitura() {
		return leitura; //retorna a última leitura armazenada pela classe.
	}
	
//	public Sensor getUmidade() {
//		return umidade;
//	}
	
}
