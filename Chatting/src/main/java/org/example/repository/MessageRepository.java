package org.example.repository;

import org.example.entity.ChatMessage;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface MessageRepository extends MongoRepository<ChatMessage,Long> {
    public List<ChatMessage> findAllByRoomId(Long roomId);
}
