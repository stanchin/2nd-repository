package com.tsystems.javaschool.DTO;


import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class ReportClients extends ArrayList<ClientDTO>{

    public ReportClients(){
        super();
    }

    public ReportClients(Collection<? extends ClientDTO> c) {
        super(c);
    }

    public List<ClientDTO> getReportInfo() {
        return this;
    }

    public void setReportInfo(List<ClientDTO> reportInfo) {
        this.addAll(reportInfo);
    }
}
