package com.kaique.lojaVirtual.domain.kafka.mapper;

import com.kaique.avro.EmailAvro;
import com.kaique.lojaVirtual.domain.dto.EmailDTO;

public class Emailmapper {
	
	public static EmailAvro toAvro(EmailDTO dto) {
		return EmailAvro.newBuilder()
				.setTo(dto.getTo())
				.setBody(dto.getBody())
				.setSubject(dto.getSubject())
				.build();
	}
}
