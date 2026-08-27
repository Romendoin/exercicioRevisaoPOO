package Classes;

import java.time.LocalDate;
import java.time.Year;
import java.util.Arrays;
import java.util.Objects;

public class Livro extends Publicacao{

    private int paginas;
    private String[] autores;

    public Livro(String titulo, LocalDate data, int paginas, String... autores) {
        super(titulo, data);
        this.paginas = paginas;
        this.autores = autores;
    }

    public int getPaginas() {
        return paginas;
    }

    public String[] getAutores() {
        return autores;
    }

    @Override
    public int hashCode() {
        return Objects.hash(paginas, Arrays.hashCode(autores));
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Livro livro)) return false;
        return this.getTitulo().equalsIgnoreCase(livro.getTitulo())
                && Objects.deepEquals(autores, livro.autores) && this.paginas == livro.paginas;
    }

    @Override
    public String toString() {
        //String strAutores =

        return "Livro: "
                + this.getTitulo() + " (" + Year.from(getData()) + ')'
                + " - " + this.paginas + " paginas - Autores: " + ((this.autores.length == 0) ? "Sem autor" : String.join(", ", this.autores));
    }
}
