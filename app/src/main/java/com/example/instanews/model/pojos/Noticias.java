package com.example.instanews.model.pojos;

public class Noticias {
    public int imagemnoticia;
    public String titulo;
    public String descricao;

    public Noticias(int imagemnoticia, String titulo, String descricao) {
        this.imagemnoticia = imagemnoticia;
        this.titulo = titulo;
        this.descricao = descricao;
    }

    public Noticias() {
    }

    public int getImagemnoticia() {
        return imagemnoticia;
    }

    public void setImagemnoticia(int imagemnoticia) {
        this.imagemnoticia = imagemnoticia;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
