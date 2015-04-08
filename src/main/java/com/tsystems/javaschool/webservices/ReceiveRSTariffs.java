package com.tsystems.javaschool.webservices;


import com.tsystems.javaschool.DTO.TariffDTO;

import javax.ejb.Stateless;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Stateless
public class ReceiveRSTariffs {

    public List<TariffDTO> getTariffs(){

        Client client = ClientBuilder.newClient();
        WebTarget target = client.target("http://localhost:8080/eCare/service/tariffs");

        Response response = target
                .request(MediaType.APPLICATION_JSON_TYPE)
                .get();

        return response.readEntity(new GenericType<List<TariffDTO>>(){});
    }
}
