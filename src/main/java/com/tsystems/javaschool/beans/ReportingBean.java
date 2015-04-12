package com.tsystems.javaschool.beans;


import com.tsystems.javaschool.DTO.TariffDTO;
import com.tsystems.javaschool.service.PdfService;
import com.tsystems.javaschool.webservices.ReceiveRSTariffs;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@ManagedBean
@ViewScoped
public class ReportingBean {

    private long tariffId;
    private String tariffName;
    private List<TariffDTO> tariffs;

    @EJB
    private PdfService pdfService;
    @EJB
    private ReceiveRSTariffs receiveRSTariffs;

    public void receiveReportTariffs(){
        tariffs = receiveRSTariffs.getTariffs();
    }

    public void getReportClients(){
        FacesContext context = FacesContext.getCurrentInstance();
        HttpServletResponse response = (HttpServletResponse)context.getExternalContext().getResponse();
        pdfService.createPdf(response, tariffId, tariffName);
        context.responseComplete();
    }

    public List<TariffDTO> getTariffs() {
        return tariffs;
    }

    public void setTariffs(List<TariffDTO> tariffs) {
        this.tariffs = tariffs;
    }

    public long getTariffId() {
        return tariffId;
    }

    public void setTariffId(long tariffId) {
        this.tariffId = tariffId;
    }

    public String getTariffName() {
        return tariffName;
    }

    public void setTariffName(String tariffName) {
        this.tariffName = tariffName;
    }
}
