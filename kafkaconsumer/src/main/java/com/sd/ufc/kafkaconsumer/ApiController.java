package com.sd.ufc.kafkaconsumer;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
@RequestMapping("/api/leituras")
public class ApiController {
	
	private final KafkaConsumer kafkaconsumer;
	
	public ApiController(KafkaConsumer kafkaConsumer) {
		// Injeção de dependência do KafkaConsumer no construtor
		this.kafkaconsumer = kafkaConsumer;
		
	}
	
	@GetMapping
	public Sensor getLeitura() {
		// Retorna a última leitura armazenada pelo KafkaConsumer
		return kafkaconsumer.getLeitura();
	}
	
//	@GetMapping
//	public Sensor getUmidade() {
//		// Retorna a última leitura armazenada pelo KafkaConsumer
//		return kafkaconsumer.getUmidade();
//	}
	
}
