package com.desafio.codenation.codenation.controller;

import com.desafio.codenation.codenation.integracao.apiCodenation.json.ResponseApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/executarDesafio")
public class DesafioController {

    @Autowired
    DesafioFacade facade;

    @RequestMapping(value = "/play", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public ResponseApi executarDesafio() {

        return facade.executarDesafio();

    }

}
