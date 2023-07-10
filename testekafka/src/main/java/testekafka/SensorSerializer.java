package testekafka;

import org.apache.kafka.common.serialization.Serializer;

import com.fasterxml.jackson.databind.ObjectMapper;

public class SensorSerializer implements Serializer<Sensor>{

	@Override
	public byte[] serialize(String topic, Sensor data) {
		
		try {
			// Criar uma nova instância do ObjectMapper para converter o objeto do sensor em bytes
			return new ObjectMapper().writeValueAsBytes(data);
			// Use o ObjectMapper para gravar o objeto Sensor como bytes
		} catch (Exception e) {
			// Se ocorrer uma exceção durante a serialização, trate-a aqui
            // TODO: você pode implementar uma lógica personalizada de tratamento de exceções ou de registro
            // Por enquanto, a exceção é ignorada e null é retornado
			// TODO: handle exception
		}
		
		// If serialization fails, return null
		return null;
	}

	
}
