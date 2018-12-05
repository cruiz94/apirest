package com.model;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name="pelicula")
@EntityListeners(AuditingEntityListener.class)
public class Pelicula implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idPelicula;
    @Column(name = "titulo", nullable = false)
    private String titulo;
    @Column(name = "sinopsis", nullable = false)
    private String sinopsis;
    @Column(name = "poster", nullable = false)
    private String poster;
    @Column(name = "reseña", nullable = false)
    private String reseña;
    @Temporal(TemporalType.DATE)
    @Column(name = "fechaEstreno", nullable = false)
    private Date fechaEstreno;

    public Pelicula(){}

    public Pelicula(String titulo, String sinopsis, String poster, String reseña, Date fechaEstreno) {
        this.titulo = titulo;
        this.sinopsis = sinopsis;
        this.poster = poster;
        this.reseña = reseña;
        this.fechaEstreno = fechaEstreno;
    }


    public long getIdPelicula() {
        return idPelicula;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }


    public String getSinopsis() {
        return sinopsis;
    }

    public void setSinopsis(String sinopsis) {
        this.sinopsis = sinopsis;
    }


    public String getPoster() {
        return poster;
    }

    public void setPoster(String poster) {
        this.poster = poster;
    }


    public String getReseña() {
        return reseña;
    }

    public void setReseña(String reseña) {
        this.reseña = reseña;
    }


    public Date getFechaEstreno() {
        return fechaEstreno;
    }

    public void setFechaEstreno(Date fechaEstreno) {
        this.fechaEstreno = fechaEstreno;
    }

    @Override
    public String toString() {
        return "Pelicula{" +
                "idPelicula=" + idPelicula +
                ", titulo='" + titulo + '\'' +
                ", sinopsis='" + sinopsis + '\'' +
                ", poster='" + poster + '\'' +
                ", reseña='" + reseña + '\'' +
                ", fechaEstreno=" + fechaEstreno +
                '}';
    }
}
