package com.consumer.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.consumer.dto.ConsumerDto;
import com.consumer.entities.Consumer;
import com.consumer.repositories.ConsumerRepository;
import com.consumer.services.ConsumerServices;

@Service
public class ConsumerServiceImpl implements ConsumerServices {
	
	@Autowired
	private ConsumerRepository consumerRepository;
	
	public Consumer buscarPorConsumer(String id) {
		return this.consumerRepository.findByConsumer(id);
	}

	@Override
	public void salvarNome(String id, String name) {				
		this.consumerRepository.salvarNome(id, name);
	}

	@Override
	public void update(ConsumerDto consumerDto) {
		this.consumerRepository.update(consumerDto);
	}

	@Override
	public List<Consumer> buscarPorConversationId(String id) {
		return consumerRepository.buscarPorConversationId(id);
	}

}
