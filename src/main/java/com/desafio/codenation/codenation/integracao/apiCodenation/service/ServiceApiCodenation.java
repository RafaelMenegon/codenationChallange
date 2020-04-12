package com.desafio.codenation.codenation.integracao.apiCodenation.service;

import com.desafio.codenation.codenation.integracao.apiCodenation.client.ApiCodenationClient;
import com.desafio.codenation.codenation.integracao.apiCodenation.json.ResponseApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServiceApiCodenation {


    @Autowired
    private ApiCodenationClient clientCodenation;

    public ResponseApi getApiCodenation() {
        return clientCodenation.getCodenation().getBody();
    }

}
