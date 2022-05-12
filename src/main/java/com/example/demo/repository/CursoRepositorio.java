package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.modelo.Curso;

public interface CursoRepositorio extends JpaRepository<Curso, Integer> {

}
