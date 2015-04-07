package com.tsystems.javaschool.beans;


import com.tsystems.javaschool.DTO.TariffDTO;
import com.tsystems.javaschool.service.PdfService;
import com.tsystems.javaschool.webservices.ReceiveRSTariffs;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Stateless
@ManagedBean
public class ReportingBean {

    private List<TariffDTO> tariffs;
    @EJB
    private PdfService pdfService;
    @EJB
    private ReceiveRSTariffs receiveRSTariffs;

    public void getReportTariffs(){
        tariffs = receiveRSTariffs.getTariffs();
    }

    public void getReportClients(){
        FacesContext context = FacesContext.getCurrentInstance();
        HttpServletResponse response = (HttpServletResponse)context.getExternalContext().getResponse();
        pdfService.createPdf(response);
        context.responseComplete();
    }

    public List<TariffDTO> getTariffs() {
        return tariffs;
    }

    public void setTariffs(List<TariffDTO> tariffs) {
        this.tariffs = tariffs;
    }
}
