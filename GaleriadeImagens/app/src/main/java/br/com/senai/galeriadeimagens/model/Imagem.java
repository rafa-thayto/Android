package br.com.senai.galeriadeimagens.model;

/**
 * Created by adminLocal on 06/04/2018.
 */

public class Imagem {
    private Long id;
    private String caminhoImagem;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCaminhoImagem() {
        return caminhoImagem;
    }

    public void setCaminhoImagem(String caminhoImagem) {
        this.caminhoImagem = caminhoImagem;
    }
}
