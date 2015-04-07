package com.tsystems.javaschool.service;

import com.tsystems.javaschool.webservices.ReceiveRSClients;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.servlet.http.HttpServletResponse;

@Stateless
public class PdfService {

    @EJB
    private ReceiveRSClients receiveRSClients;

    public void createPdf(HttpServletResponse response){
        response.setContentType("application/pdf");
        response.setHeader("Content-Disposition","attachment; filename=\"clients.pdf\"");


    }
}
