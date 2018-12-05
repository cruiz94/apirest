package com.controller;

import com.exception.ResourceNotFoundException;
import com.model.Pelicula;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.repository.PeliculaRepository;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class PeliculaController {


    @Autowired
    private PeliculaRepository peliculaRepository;

    @GetMapping("/peliculas")
    public List<Pelicula> getAllPeliculas() {
        return peliculaRepository.findAll();
    }

    @PostMapping("/peliculas")
    public Pelicula createPelicula(@RequestBody Pelicula pelicula) {
        return peliculaRepository.save(pelicula);
    }

    @GetMapping("/peliculas/{id}")
    public Pelicula getPeliculaById(@PathVariable(value = "id") Long idPelicula) {
        return peliculaRepository.findById(idPelicula)
                .orElseThrow(() -> new ResourceNotFoundException("Note", "id", idPelicula));
    }

    @PutMapping("/peliculas/{id}")
    public Pelicula updatePelicula(@PathVariable(value = "id") Long idPelicula,
                           @Valid @RequestBody Pelicula peliculaDetalles) {

        Pelicula pelicula = peliculaRepository.findById(idPelicula)
                .orElseThrow(() -> new ResourceNotFoundException("Note", "id", idPelicula));

        pelicula.setTitulo(peliculaDetalles.getTitulo());
        pelicula.setSinopsis(peliculaDetalles.getSinopsis());
        pelicula.setFechaEstreno(peliculaDetalles.getFechaEstreno());
        pelicula.setPoster(peliculaDetalles.getPoster());
        pelicula.setReseña(peliculaDetalles.getReseña());

        Pelicula updatedPelicula = peliculaRepository.save(pelicula);
        return updatedPelicula;
    }

    @DeleteMapping("/peliculas/{id}")
    public ResponseEntity<?> deletePelicula(@PathVariable(value = "id") Long idPelicula) {
        Pelicula pelicula = peliculaRepository.findById(idPelicula)
                .orElseThrow(() -> new ResourceNotFoundException("Pelicula", "id", idPelicula));

        peliculaRepository.delete(pelicula);

        return ResponseEntity.ok().build();
    }
}
