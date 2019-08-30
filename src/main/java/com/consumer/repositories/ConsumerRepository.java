package com.consumer.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import com.consumer.dto.ConsumerDto;
import com.consumer.entities.Consumer;

@Transactional(readOnly = true)
public interface ConsumerRepository extends JpaRepository<ConsumerDto, String> {
	
	//TODO implementar a query que busca pelo id 
	Consumer findByConsumer(String id);
	
	//TODO implementar a query que salva o id e nome
	void salvarNome(String id, String name);
	
	//TODO implementar a query que atualiza o dado
	void update(ConsumerDto consumerDto);

	//TODO implementar a query lista todos os registro
	List<Consumer> buscarPorConversationId(String conversationId);
}
