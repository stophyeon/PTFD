package org.example.repository;

import org.example.entity.ChattingRoom;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

@Repository
public interface ChatRoomRepository extends JpaRepository<ChattingRoom,Long> {
    public ChattingRoom findByRoomId(Long roomId);
}
