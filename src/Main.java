import Classes.*;
import Interfaces.Imprimivel;
import java.time.LocalDate;

void main() {
    System.out.println("========================================");
    System.out.println("   TESTE - SISTEMA LIVRARIA");
    System.out.println("========================================\n");

    // --- Criando publicacoes ---
    Livro livro1 = new Livro("O Pequeno Principe", LocalDate.of(1943, 4, 6), 96, "Antoine de Saint-Exupery");
    Livro livro2 = new Livro("Java: Como Programar", LocalDate.of(2018, 1, 1), 928, "Deitel", "Franscisco", "Carlos");
    Livro livro3 = new Livro("O Pequeno Principe", LocalDate.of(1943, 4, 6), 96, "Antoine de Saint-Exupery"); // igual a livro1
    Livro livro4 = new Livro("Clean Code", LocalDate.of(2008, 8, 1), 464, "Robert C. Martin");

    Revista revista1 = new Revista("National Geographic", LocalDate.of(2021, 3, 1), 15, "Pamimi");
    Revista revista2 = new Revista("Acao Games", LocalDate.of(1991, 5, 1), 1, "Editora Azul");
    Revista revista3 = new Revista("Acao Games", LocalDate.of(1993, 6, 1), 37, "Editora Azul"); // mesma revista2 mas edições diferentes
    Revista revista4 = new Revista("Acao Games", LocalDate.of(1991, 5, 1), 1, "Editora Azul"); //igual a revista2

    System.out.println("--- toString das publicacoes ---");
    System.out.println(livro1);
    System.out.println(livro2);
    System.out.println(revista1);
    System.out.println(revista2);
    System.out.println();

    // --- Testando equals ---
    System.out.println("--- Testes de equals ---");
    System.out.println("livro1.equals(livro3) [mesmo livro]: " + livro1.equals(livro3));           // true
    System.out.println("livro1.equals(livro2) [livros diferentes]: " + livro1.equals(livro2));       // false
    System.out.println("revista2.equals(revista4) [mesma revista]: " + revista2.equals(revista4));           // true
    System.out.println("revista1.equals(revista2) [revistas diferentes]: " + revista1.equals(revista2));     // false
    System.out.println("livro1.equals(revista1) [tipos diferentes]: " + livro1.equals(revista1));       // false
    System.out.println("revista2.equals(revista3) [mesma revista, edicoes diferentes]: " + revista2.equals(revista3)); //false

    System.out.println();

    // --- Criando livraria ---
    Livraria livraria = new Livraria("Livraria Estrela");
    System.out.println("Livraria: " + livraria.getNome());
    System.out.println();

    // --- Adicionando ao estoque ---
    System.out.println("--- Adicionando ao estoque ---");
    livraria.addEstoque(livro1);                    // 1 exemplar de O Pequeno Principe
    livraria.addEstoque(livro2, 3);                 // 3 exemplares de Java: Como Programar
    livraria.addEstoque(revista1);                    // 1 exemplar de National Geographic
    livraria.addEstoque(revista2, 2);                 // 2 exemplares de Acao Games ed1
    livraria.addEstoque(revista3, 1);        //1 exemplar de Acao Games ed37
    livraria.addEstoque(revista4);                     //1 exemplar de Acao Games ed1 (revista4 é a mesma que revista2)
    livraria.addEstoque(livro4);                    // 1 exemplar de Clean Code

    System.out.println("Estoque adicionado com sucesso!");
    System.out.println();

    // --- Consultando exemplares ---
    System.out.println("--- Consulta de exemplares ---");
    System.out.println("Exemplares de O Pequeno Principe: " + livraria.getExemplares(livro1));   // 1
    System.out.println("Exemplares de Java: Como Programar: " + livraria.getExemplares(livro2)); // 3
    System.out.println("Exemplares de National Geographic: " + livraria.getExemplares(revista1));  // 1
    System.out.println("Exemplares de Clean Code: " + livraria.getExemplares(livro4));           // 1
    System.out.println("Exemplares de Acao Games ed1: " + livraria.getExemplares(revista2));           // 3
    System.out.println("Exemplares de Acao Games ed37: " + livraria.getExemplares(revista3));           // 1
    System.out.println("Exemplares de livro3 (igual a livro1): " + livraria.getExemplares(livro3));     // 1 (usa equals)
    System.out.println();

    // --- Vendendo ---
    System.out.println("--- Venda de exemplar (livro) ---");
    Imprimivel vendido = livraria.vende(livro1);
    if (vendido != null) {
        System.out.println("Vendido:");
        System.out.println(vendido);
    } else {
        System.out.println("Exemplar nao encontrado!");
    }
    System.out.println();

    System.out.println("Exemplares de O Pequeno Principe apos venda: " + livraria.getExemplares(livro1)); // 0
    System.out.println();

    System.out.println("--- Venda de exemplar (revista) ---");
    Imprimivel vendido2 = livraria.vende(revista2);
    if (vendido2 != null) {
        System.out.println("Vendido:");
        System.out.println(vendido2);
    } else {
        System.out.println("Exemplar nao encontrado!");
    }
    System.out.println();

    System.out.println("Exemplares de Acao Games ed1: " + livraria.getExemplares(revista4)); // 2
    System.out.println();


    // --- Vendendo o que nao existe ---
    System.out.println("--- Venda de exemplar inexistente ---");
    Imprimivel vendido3 = livraria.vende(livro1);
    if (vendido3 != null) {
        System.out.println("Vendido:");
        System.out.println(vendido3);
    } else {
        System.out.println("Exemplar nao encontrado (null)!");
    }
    System.out.println();

    // --- Testando toString da Impressao ---
    System.out.println("--- toString de Impressao (exemplar) ---");
    Imprimivel ex = livraria.vende(livro2);
    if (ex != null) {
        System.out.println(ex);
    }
    System.out.println();

    // --- Testando addEstoque com null ---
    System.out.println("--- Teste de null safety ---");
    livraria.addEstoque(null);              // nao deve adicionar nada
    livraria.addEstoque(null, 5);           // nao deve adicionar nada
    System.out.println("Exemplares de null: " + livraria.getExemplares(null)); // 0
    System.out.println();

}




