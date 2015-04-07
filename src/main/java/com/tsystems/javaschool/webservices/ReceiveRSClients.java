package com.tsystems.javaschool.webservices;

import com.tsystems.javaschool.DTO.ReportClients;

import javax.ejb.Stateless;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;

@Stateless
public class ReceiveRSClients {

    public ReportClients getClients(long tariffId){

        Client client = ClientBuilder.newClient();
        WebTarget target = client.target("http://localhost:8080/eCare/service/getClientsByTariff");
        Invocation invocation = target.queryParam("tariffId", tariffId).request().buildGet();
        Response response = invocation.invoke();

        return response.readEntity(ReportClients.class);
    }

}
