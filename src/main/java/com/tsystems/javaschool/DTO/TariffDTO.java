package com.tsystems.javaschool.DTO;


import java.math.BigDecimal;

public class TariffDTO {

    private long tariffId;
    private String tariffName;
    private BigDecimal tariffPrice;

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

    public BigDecimal getTariffPrice() {
        return tariffPrice;
    }

    public void setTariffPrice(BigDecimal tariffPrice) {
        this.tariffPrice = tariffPrice;
    }
}
