package com.tsystems.javaschool.DTO;


import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class ReportTariffs extends ArrayList<TariffDTO>{

    public ReportTariffs(){
        super();
    }

    public ReportTariffs(Collection<? extends TariffDTO> c) {
        super(c);
    }

    public List<TariffDTO> getReportInfo() {
        return this;
    }

    public void setReportInfo(List<TariffDTO> reportInfo) {
        this.addAll(reportInfo);
    }
}
