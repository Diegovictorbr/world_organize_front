package com.world.viewmodel;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import org.springframework.format.annotation.DateTimeFormat;

public class FilterViewModel {

    private String nomePaciente;
    private String nomeMedico;
    private Integer estadoExameId;
    private Integer tipoExameId;
    private Integer hospitalId;
    private Integer currentPage;
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private Calendar fromDate;
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private Calendar toDate;

    public String getNomePaciente() {
        return nomePaciente;
    }

    public void setNomePaciente(String nomePaciente) {
        this.nomePaciente = nomePaciente;
    }

    public String getNomeMedico() {
        return nomeMedico;
    }

    public void setNomeMedico(String nomeMedico) {
        this.nomeMedico = nomeMedico;
    }

    public Integer getEstadoExameId() {
        return estadoExameId;
    }

    public void setEstadoExameId(Integer estadoExameId) {
        this.estadoExameId = estadoExameId;
    }

    public Integer getTipoExameId() {
        return tipoExameId;
    }

    public void setTipoExameId(Integer tipoExameId) {
        this.tipoExameId = tipoExameId;
    }

    public Integer getHospitalId() {
        return hospitalId;
    }

    public void setHospitalId(Integer hospitalId) {
        this.hospitalId = hospitalId;
    }

    public Integer getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(Integer currentPage) {
        this.currentPage = currentPage;
    }

    public Calendar getFromDate() {
        return fromDate;
    }

    public void setFromDate(Calendar fromDate) {
        this.fromDate = fromDate;
    }

    public Calendar getToDate() {
        return toDate;
    }

    public void setToDate(Calendar toDate) {
        this.toDate = toDate;
    }

    public String getFormattedFromDate() {
        if (fromDate != null) {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
            return simpleDateFormat.format(fromDate.getTime());
        }
        return "";
    }

    public String getFormattedToDate() {
        if (toDate != null) {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
            return simpleDateFormat.format(toDate.getTime());
        }
        return "";
    }
}
