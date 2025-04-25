package com.kaique.lojaVirtual.domain.kafka.producer;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import com.kaique.avro.EmailAvro;

@Component
public class EmailProducer {

	@Value("${spring.kafka.topico-envia-email}")
	public String topico;
	private final KafkaTemplate<String, EmailAvro> kafkaTemplate;

    public EmailProducer(KafkaTemplate<String, EmailAvro> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }
    
    public void enviarMensagem(EmailAvro emailAvro) {
        kafkaTemplate.send(topico , emailAvro);
    }

}
