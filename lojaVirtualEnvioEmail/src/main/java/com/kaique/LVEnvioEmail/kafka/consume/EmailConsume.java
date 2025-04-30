package com.kaique.LVEnvioEmail.kafka.consume;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.stereotype.Service;

import com.kaique.LVEnvioEmail.kafka.consume.mapper.EmailMapper;
import com.kaique.LVEnvioEmail.services.EmailService;
import com.kaique.avro.EmailAvro;

@Service
public class EmailConsume {
	
	@Autowired
	private EmailService emailService;

	@KafkaListener(topics = "${spring.kafka.topico-envia-email}", groupId = "${spring.kafka.consumer.group-id}")
	public void consomeBoleto(EmailAvro emailAvro ,  Acknowledgment ack) throws InterruptedException {
		  
		emailService.sendEmail(EmailMapper.converteAvroEmail(emailAvro));
		ack.acknowledge();
	}
}
