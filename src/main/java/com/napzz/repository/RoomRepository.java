package com.napzz.repository;

import javax.enterprise.context.ApplicationScoped;

import com.napzz.entity.room.Room;

import org.springframework.data.jpa.repository.JpaRepository;

@ApplicationScoped
public interface RoomRepository extends JpaRepository<Room, Integer>{

}
