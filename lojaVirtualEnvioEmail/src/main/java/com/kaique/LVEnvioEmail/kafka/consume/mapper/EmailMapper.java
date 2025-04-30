package com.kaique.LVEnvioEmail.kafka.consume.mapper;

import com.kaique.LVEnvioEmail.dto.EmailDTO;
import com.kaique.avro.EmailAvro;

public class EmailMapper {

	public static EmailDTO converteAvroEmail(EmailAvro avro) {
		EmailDTO emailDTO = new EmailDTO();
		emailDTO.setTo(avro.getTo().toString());
		emailDTO.setSubject(avro.getSubject().toString());
		emailDTO.setBody(avro.getBody().toString());

		return emailDTO;
	}
}
