package com.sd.ufc.kafkaconsumer;

import java.util.HashMap;
import java.util.Map;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;

@EnableKafka
@Configuration
public class KafkaConfig {
	
	@Bean
	public ConsumerFactory <String, Sensor> consumerFactory()  {
		// Configuração do consumidor
		Map<String, Object> config = new HashMap<>();
		
		config.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
		config.put(ConsumerConfig.GROUP_ID_CONFIG, "grupo-web");
		config.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getCanonicalName());
		config.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, SensorDeserializer.class.getName());
		
		// Criação e retorno da fábrica de consumidores
		return new DefaultKafkaConsumerFactory<String, Sensor>(config, new StringDeserializer(), new SensorDeserializer());
	}
	
	@Bean
	public ConcurrentKafkaListenerContainerFactory sensorListener() {
		// Configuração da fábrica de containers de ouvintes Kafka
		ConcurrentKafkaListenerContainerFactory <String, Sensor> factory = new ConcurrentKafkaListenerContainerFactory<>();
		factory.setConsumerFactory(consumerFactory());
		
		return factory;
		}
	
}
