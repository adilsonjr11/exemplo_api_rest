package com.consumer.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import com.consumer.dto.ConsumerDto;
import com.consumer.entities.Consumer;

@Transactional(readOnly = true)
public interface ConsumerRepository extends JpaRepository<ConsumerDto, String> {

	Consumer findByConsumer(String id);

	void salvarNome(String id, String name);

	void update(ConsumerDto consumerDto);

	List<Consumer> buscarPorConversationId(String id);
}
