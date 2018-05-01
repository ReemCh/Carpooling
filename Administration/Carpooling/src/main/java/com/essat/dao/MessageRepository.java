package com.essat.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.essat.entities.Message;

public interface MessageRepository extends JpaRepository<Message,Long> {

}
