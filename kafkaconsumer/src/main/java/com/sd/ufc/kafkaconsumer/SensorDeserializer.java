package com.sd.ufc.kafkaconsumer;

import org.apache.kafka.common.serialization.Deserializer;

import com.fasterxml.jackson.databind.ObjectMapper;

public class SensorDeserializer implements Deserializer<Sensor>{

	@Override
	public Sensor deserialize(String topic, byte[] data) {
		
		try {
			// Cria uma nova instância de ObjectMapper para converter os bytes em objeto Sensor
			return new ObjectMapper().readValue(data, Sensor.class);
			// Utiliza o ObjectMapper para ler os bytes e converter em um objeto Sensor
		} catch (Exception e) {
			// Se ocorrer uma exceção durante a desserialização, trata-a aqui
			// TODO: Você pode implementar uma lógica de tratamento de exceção personalizada ou registro de logs
			// Por enquanto, a exceção é ignorada e retorna null
			// TODO: handle exception
		}
		
		// Se a desserialização falhar, retorna null
		return null;
	}
	
	

}
