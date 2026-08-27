package Classes;

import Interfaces.Publicavel;

import java.time.LocalDate;

public abstract class Publicacao implements Publicavel {
    private final String titulo;
    private final LocalDate data;

    public Publicacao(String titulo, LocalDate data) {
        this.titulo = titulo;
        this.data = data;
    }

    public String getTitulo() {
        return titulo;
    }

    public LocalDate getData() {
        return data;
    }
}
