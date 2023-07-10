package testekafka;

import java.time.Duration;
import java.util.Arrays;
import java.util.Properties;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.common.serialization.StringDeserializer;

public class ConsumidorSimples {

	public static void main(String[] args) {
		// Configuração das propriedades do consumidor
		Properties props = new Properties();
        
        props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
        props.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());
        props.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, SensorDeserializer.class.getName());
        props.put(ConsumerConfig.GROUP_ID_CONFIG, "testejava-g1");
        props.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, "latest");
        
        try(KafkaConsumer <String,Sensor> consumer = new KafkaConsumer <>(props)){
			// Inscreve o consumidor no tópico "testejava"
            consumer.subscribe(Arrays.asList("testejava"));
            
            while(true){
				// Realiza a leitura de registros do Kafka durante 100 milissegundos
                ConsumerRecords <String,Sensor> records = consumer.poll(Duration.ofMillis(100));
                
				// Processa os registros lidos
                for(ConsumerRecord<String, Sensor>  record : records){
                    System.out.println(record.toString());
                }
                
                
            }
            
        }

	}

}
