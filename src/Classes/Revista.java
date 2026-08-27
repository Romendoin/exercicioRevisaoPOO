package Classes;

import java.time.LocalDate;
import java.time.Month;
import java.time.Year;
import java.util.Objects;

public class Revista extends Publicacao{
    private int edicao;
    private String editora;

    public Revista(String titulo, LocalDate data, int edicao, String editora) {
        super(titulo, data);
        this.edicao = edicao;
        this.editora = editora;
    }

    public int getEdicao() {
        return edicao;
    }

    public String getEditora() {
        return editora;
    }

    @Override
    public int hashCode() {
        return Objects.hash(edicao, editora);
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Revista revista)) return false;
        return this.getTitulo().equalsIgnoreCase(revista.getTitulo())
                && edicao == revista.edicao
                && Objects.equals(editora, revista.editora);
    }

    @Override
    public String toString() {
        return "Revista: "
                + this.getTitulo() + " (" + Month.from(this.getData()) + "/"
                + Year.from(this.getData()) + ") - editora " + this.getEditora()
                + " - edicao n:" + this.getEdicao();


    }
}
