package org.example.repository;

import org.example.entity.Message;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MessageRepository extends MongoRepository<Message,Long> {
    public List<Message> findAllByRoomId(Long roomId);
}
