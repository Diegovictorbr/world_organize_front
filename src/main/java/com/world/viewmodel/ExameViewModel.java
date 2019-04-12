package com.world.viewmodel;

public class ExameViewModel {

    private int examId;
    private int patientId;
    private int estadoExameId;
    private int tipoExameId;
    private String description;
    private String priority;
    private String titulo;
    private String analise;
    private String tecnica;
    private boolean laudoWeb;

    public int getPatientId() {
        return patientId;
    }

    public void setPatientId(int patientId) {
        this.patientId = patientId;
    }

    public int getTipoExameId() {
        return tipoExameId;
    }

    public void setTipoExameId(int tipoExameId) {
        this.tipoExameId = tipoExameId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    public int getEstadoExameId() {
        return estadoExameId;
    }

    public void setEstadoExameId(int estadoExameId) {
        this.estadoExameId = estadoExameId;
    }

    public int getExamId() {
        return examId;
    }

    public void setExamId(int examId) {
        this.examId = examId;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getTecnica() {
        return tecnica;
    }

    public void setTecnica(String tecnica) {
        this.tecnica = tecnica;
    }

    public boolean isLaudoWeb() {
        return laudoWeb;
    }

    public void setLaudoWeb(boolean laudoWeb) {
        this.laudoWeb = laudoWeb;
    }

    public String getAnalise() {
        return analise;
    }

    public void setAnalise(String analise) {
        this.analise = analise;
    }

}
