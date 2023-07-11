package testekafka;

import java.util.Properties;
import java.util.Random;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.StringSerializer;

public class ProdutorSimples {
	
	private static Random random = new Random();
	public static Double inicialTemp = random.nextDouble(24,32);
	public static Sensor termometro = new Sensor("Termometro", inicialTemp);
	public static Double somaTemperatura = inicialTemp;

	public static void main(String[] args) throws InterruptedException {
		// Configuração das propriedades do produtor
		Properties props = new Properties();
        props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
        props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
        props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, SensorSerializer.class.getName());
        
        try(Producer <String,Sensor> producer = new KafkaProducer <>(props)){
        while(true) {
			// Atualiza o valor do termômetro com um novo valor aleatório entre 24 e 32
        	Double temperatura = random.nextDouble(24,32);
        	somaTemperatura = somaTemperatura + temperatura;
        	termometro.setValor(temperatura);
        	termometro.setMedia(somaTemperatura/termometro.getLeituras());
        	if(temperatura > termometro.getMaxValor()) {
        		termometro.setMaxValor(temperatura);
        	}
        	if(temperatura < termometro.getMinValor()) {
        		termometro.setMinValor(temperatura);
        	}
			// Cria um novo registro de produtor com o tópico "testejava" e o objeto Sensor
        	ProducerRecord <String,Sensor> record = new ProducerRecord<>("testejava", termometro);
			// Envia o registro para o Kafka
            producer.send(record);
			// Aguarda 2 segundos antes de enviar o próximo registro
            Thread.sleep(2000);
        }
        	
        }

	}

}
