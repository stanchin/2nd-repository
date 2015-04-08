package com.tsystems.javaschool.webservices;

import com.tsystems.javaschool.DTO.ClientDTO;

import javax.ejb.Stateless;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Stateless
public class ReceiveRSClients {

    public List<ClientDTO> getClients(long tariffId){

        Client client = ClientBuilder.newClient();
        WebTarget target = client.target("http://localhost:8080/eCare/service/getClientsByTariff");

        Response response = target.queryParam("tariffId", tariffId)
                .request(MediaType.APPLICATION_JSON_TYPE)
                .get();

        return response.readEntity(new GenericType<List<ClientDTO>>(){});
    }

}
