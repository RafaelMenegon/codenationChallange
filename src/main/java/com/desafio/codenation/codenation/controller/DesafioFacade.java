package com.desafio.codenation.codenation.controller;

import com.desafio.codenation.codenation.integracao.apiCodenation.json.ResponseApi;
import com.desafio.codenation.codenation.integracao.apiCodenation.service.ServiceApiCodenation;
import com.desafio.codenation.codenation.service.Descriptografia;
import com.desafio.codenation.codenation.utils.ConvertToSha1;
import com.desafio.codenation.codenation.utils.SaveJson;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class DesafioFacade {

    @Autowired
    ServiceApiCodenation codenationService;

    @Autowired
    Descriptografia descriptografia;

    @Autowired
    ConvertToSha1 convertToSha1;

    @Autowired
    SaveJson saveJson;


    public ResponseApi executarDesafio() {

        ResponseApi entradaJson = codenationService.getApiCodenation();

        try {

            ObjectMapper objectMapper = new ObjectMapper();
            System.out.println(entradaJson);

            saveJson.saveJson(objectMapper.writeValueAsString(entradaJson));
            entradaJson.setDecifrado(descriptografia.descriptografia(entradaJson.getCifrado(), entradaJson.getNumero_casas()));
            entradaJson.setResumo_criptografico(convertToSha1.convertToSha(entradaJson.getDecifrado()));
            saveJson.saveJson(objectMapper.writeValueAsString(entradaJson));
            System.out.println(entradaJson);
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("erro ao salvar arquivo");
        }

        return entradaJson;
    }
}
