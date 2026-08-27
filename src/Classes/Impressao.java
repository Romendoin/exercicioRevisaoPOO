package Classes;

import Interfaces.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Impressao implements Imprimivel {

    private final Publicavel publicacao;
    private final String codigo;
    private final LocalDate data;
    private static int contagem;
    private static final DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public Publicavel getPublicacao() {return publicacao;}

    public String getCodigo() {
        return codigo;
    }

    public LocalDate getData() {
        return data;
    }

    public Impressao(Publicavel publicacao) {
        this.publicacao = publicacao;
        Impressao.contagem += 1;
        if(this.publicacao instanceof Livro){
            this.codigo = 'L' + Integer.toString(Impressao.contagem);
        } else {
            this.codigo = 'R' + Integer.toString(Impressao.contagem);
        }
        this.data = LocalDate.now();
    }

    @Override
    public String toString() {

        return "Exemplar: " + this.codigo + "| Data impressao: "
            + this.data.format(fmt) + "\n" + this.publicacao.toString();
    }
}
