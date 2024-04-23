package com.nela.exploradordefarmacias.ui.configuracion;

public class Configuracion {
    private String conf;

    public Configuracion(String conf, String mapa, String normal, String hib, String idioma, String espanol, String ingles, String tema, String oscuro, String claro) {
        this.conf = conf;
        this.mapa = mapa;
        this.normal = normal;
        this.hib = hib;
        this.idioma = idioma;
        this.espanol = espanol;
        this.ingles = ingles;
        this.tema = tema;
        this.oscuro = oscuro;
        this.claro = claro;
    }

    public String getConf() {
        return conf;
    }

    public void setConf(String conf) {
        this.conf = conf;
    }

    private String mapa;
    private String normal;
    private String hib;
    private String idioma;
    private String espanol;
    private String ingles;
    private String tema;
    private String oscuro;
    private String claro;

    public String getMapa() {
        return mapa;
    }

    public void setMapa(String mapa) {
        this.mapa = mapa;
    }

    public String getNormal() {
        return normal;
    }

    public void setNormal(String normal) {
        this.normal = normal;
    }

    public String getHib() {
        return hib;
    }

    public void setHib(String hib) {
        this.hib = hib;
    }

    public String getIdioma() {
        return idioma;
    }

    public void setIdioma(String idioma) {
        this.idioma = idioma;
    }

    public String getEspanol() {
        return espanol;
    }

    public void setEspanol(String espanol) {
        this.espanol = espanol;
    }

    public String getIngles() {
        return ingles;
    }

    public void setIngles(String ingles) {
        this.ingles = ingles;
    }

    public String getTema() {
        return tema;
    }

    public void setTema(String tema) {
        this.tema = tema;
    }

    public String getOscuro() {
        return oscuro;
    }

    public void setOscuro(String oscuro) {
        this.oscuro = oscuro;
    }

    public String getClaro() {
        return claro;
    }

    public void setClaro(String claro) {
        this.claro = claro;
    }


}
