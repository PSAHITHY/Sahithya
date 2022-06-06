package com.evehicleshowroom.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.evehicleshowroom.entity.Request;

public interface RequestRepository extends JpaRepository<Request,Integer>
{

}
