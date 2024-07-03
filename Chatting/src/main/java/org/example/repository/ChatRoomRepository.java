package org.example.repository;

import org.example.entity.ChattingRoom;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChatRoomRepository extends MongoRepository<ChattingRoom,Long> {
    public ChattingRoom findByRoomId(Long roomId);
}
