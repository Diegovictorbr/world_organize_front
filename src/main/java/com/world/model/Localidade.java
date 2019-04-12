package com.world.model;

public class Localidade {

    private int id;
    private String cidade;
    private String bairo;
    private String geom_cidade;
    private String geom_bairro;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getBairo() {
        return bairo;
    }

    public void setBairo(String bairo) {
        this.bairo = bairo;
    }

    public String getGeom_cidade() {
        return geom_cidade;
    }

    public void setGeom_cidade(String geom_cidade) {
        this.geom_cidade = geom_cidade;
    }

    public String getGeom_bairro() {
        return geom_bairro;
    }

    public void setGeom_bairro(String geom_bairro) {
        this.geom_bairro = geom_bairro;
    }
}
