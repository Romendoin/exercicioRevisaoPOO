package Classes;

import Interfaces.Imprimivel;
import Interfaces.Publicavel;

import java.util.ArrayList;

public class Livraria {
    private ArrayList<Imprimivel> estoque;
    private String nome;

    public Livraria(String nome) {
        this.nome = nome;
        this.estoque = new ArrayList<>();
    }

    public String getNome() {return nome;}

    public int getExemplares(Publicavel publicavel){
        if (publicavel == null){return 0;}

        int numExemplares = 0;

        for (Imprimivel exemplar: estoque){
            Impressao impressao = (Impressao) exemplar;
            if (impressao.getPublicacao().equals(publicavel)){
                numExemplares+=1;
            }
        }
        return numExemplares;
    }

    public void addEstoque(Publicavel publicavel){
        if (publicavel != null)
            estoque.add(new Impressao(publicavel));
    }

    public void addEstoque(Publicavel publicavel, int quantidade){
        if (publicavel != null && quantidade > 0){
            for (int i =0;i < quantidade; i++){
                addEstoque(publicavel);
            }
        }
    }

    public Imprimivel vende (Publicavel publicavel){
        if (publicavel == null) return null;
        for (int i = 0; i < estoque.size();i++){
            Impressao impressao = (Impressao) estoque.get(i);
            if (impressao.getPublicacao().equals(publicavel)){
                return estoque.remove(i);
            }
        }
        return null;
    }
}
