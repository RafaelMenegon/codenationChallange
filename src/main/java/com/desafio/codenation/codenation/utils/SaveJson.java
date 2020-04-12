package com.desafio.codenation.codenation.utils;

import org.springframework.stereotype.Component;

import java.io.FileWriter;
import java.io.IOException;

@Component
public class SaveJson {

    public void saveJson(String json) throws IOException {
        FileWriter file = new FileWriter("C://Users//RafaelVictordeMattos//Documents//DesafioAceleraDev//codenation//src//main//answer.JSON");
        file.write(json);
        file.flush();
    }
}
