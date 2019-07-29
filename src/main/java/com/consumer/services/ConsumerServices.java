package com.consumer.services;

import java.util.List;

import com.consumer.dto.ConsumerDto;
import com.consumer.entities.Consumer;

public interface ConsumerServices {

	Consumer buscarPorConsumer(String id);

	void salvarNome(String id, String name);

	void update(ConsumerDto consumerDto);

	List<Consumer> buscarPorConversationId(String id);
	
}
