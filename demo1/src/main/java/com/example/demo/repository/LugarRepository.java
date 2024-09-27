package com.example.demo.repository;

import com.example.demo.entity.Lugar;
import com.example.demo.entity.Viaje;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LugarRepository extends JpaRepository<Lugar, Integer> {
}

