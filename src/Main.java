import Classes.*;
import Interfaces.Imprimivel;
import java.time.LocalDate;

void main() {
    System.out.println("========================================");
    System.out.println("   TESTE - SISTEMA LIVRARIA");
    System.out.println("========================================\n");

    // --- Criando publicacoes ---
    Livro l1 = new Livro("O Pequeno Principe", LocalDate.of(1943, 4, 6), 96, "Antoine de Saint-Exupery");
    Livro l2 = new Livro("Java: Como Programar", LocalDate.of(2018, 1, 1), 928, "Deitel", "Franscisco", "Carlos");
    Livro l3 = new Livro("O Pequeno Principe", LocalDate.of(1943, 4, 6), 96, "Antoine de Saint-Exupery"); // igual a l1
    Livro l4 = new Livro("Clean Code", LocalDate.of(2008, 8, 1), 464, "Robert C. Martin");

    Revista r1 = new Revista("National Geographic", LocalDate.of(2021, 3, 1), 15, "Pamimi");
    Revista r2 = new Revista("科学", LocalDate.of(2022, 7, 1), 3, "Editora ABC");
    Revista r3 = new Revista("National Geographic", LocalDate.of(2021, 3, 1), 15, "Pamimi"); // igual a r1

    System.out.println("--- toString das publicacoes ---");
    System.out.println(l1);
    System.out.println(l2);
    System.out.println(r1);
    System.out.println(r2);
    System.out.println();

    // --- Testando equals ---
    System.out.println("--- Testes de equals ---");
    System.out.println("l1.equals(l3) [mesmo livro]: " + l1.equals(l3));           // true
    System.out.println("l1.equals(l2) [livros diferentes]: " + l1.equals(l2));       // false
    System.out.println("r1.equals(r3) [mesma revista]: " + r1.equals(r3));           // true
    System.out.println("r1.equals(r2) [revistas diferentes]: " + r1.equals(r2));     // false
    System.out.println("l1.equals(r1) [tipos diferentes]: " + l1.equals(r1));       // false
    System.out.println();

    // --- Criando livraria ---
    Livraria livraria = new Livraria("Livraria Estrela");
    System.out.println("Livraria: " + livraria.getNome());
    System.out.println();

    // --- Adicionando ao estoque ---
    System.out.println("--- Adicionando ao estoque ---");
    livraria.addEstoque(l1);                    // 1 exemplar de O Pequeno Principe
    livraria.addEstoque(l2, 3);                 // 3 exemplares de Java: Como Programar
    livraria.addEstoque(r1);                    // 1 exemplar de National Geographic
    livraria.addEstoque(r2, 2);                 // 2 exemplares de revista r2
    livraria.addEstoque(l4);                    // 1 exemplar de Clean Code

    System.out.println("Estoque adicionado com sucesso!");
    System.out.println();

    // --- Consultando exemplares ---
    System.out.println("--- Consulta de exemplares ---");
    System.out.println("Exemplares de O Pequeno Principe: " + livraria.getExemplares(l1));   // 1
    System.out.println("Exemplares de Java: Como Programar: " + livraria.getExemplares(l2)); // 3
    System.out.println("Exemplares de National Geographic: " + livraria.getExemplares(r1));  // 1
    System.out.println("Exemplares de Clean Code: " + livraria.getExemplares(l4));           // 1
    System.out.println("Exemplares de revista r2: " + livraria.getExemplares(r2));           // 2
    System.out.println("Exemplares de l3 (igual a l1): " + livraria.getExemplares(l3));     // 1 (usa equals)
    System.out.println();

    // --- Vendendo ---
    System.out.println("--- Venda de exemplar ---");
    Imprimivel vendido = livraria.vende(l1);
    if (vendido != null) {
        System.out.println("Vendido:");
        System.out.println(vendido);
    } else {
        System.out.println("Exemplar nao encontrado!");
    }
    System.out.println();

    System.out.println("Exemplares de O Pequeno Principe apos venda: " + livraria.getExemplares(l1)); // 0
    System.out.println();

    // --- Vendendo o que nao existe ---
    System.out.println("--- Venda de exemplar inexistente ---");
    Imprimivel vendido2 = livraria.vende(l1);
    if (vendido2 != null) {
        System.out.println("Vendido:");
        System.out.println(vendido2);
    } else {
        System.out.println("Exemplar nao encontrado (null)!");  // esperado
    }
    System.out.println();

    // --- Testando toString da Impressao ---
    System.out.println("--- toString de Impressao (exemplar) ---");
    Imprimivel ex = livraria.vende(l2);
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

    System.out.println("========================================");
    System.out.println("   TODOS OS TESTES CONCLUIDOS");
    System.out.println("========================================");

}




