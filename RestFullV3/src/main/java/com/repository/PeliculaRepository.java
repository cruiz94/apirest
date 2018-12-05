package com.repository;

import com.model.Pelicula;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("peliculaRepository")
public interface PeliculaRepository extends JpaRepository<Pelicula, Long> {

}
