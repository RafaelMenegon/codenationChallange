package com.desafio.codenation.codenation.service;

import org.springframework.stereotype.Component;

@Component
public class Descriptografia {

    static char[] charks = {
            'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h',
            'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p',
            'q', 'r', 's', 't', 'u', 'v', 'w', 'x',
            'y', 'z', '0', '1', '2', '3', '4', '5',
            '6', '7', '8', '9', 'A', 'B', 'C', 'D',
            'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L',
            'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T',
            'U', 'V', 'W', 'X', 'Y', 'Z', '!', '@',
            '#', '$', '%', '^', '&', '(', ')', '+',
            '-', '*', '/', '[', ']', '{', '}', '=',
            '<', '>', '?', '_', '"', '.', ',', ' '
    };


    public String descriptografia(String cip, int offset) {
        char[] cipher = cip.toCharArray();
        for (int i = 0; i < cipher.length; i++) {
            for (int j = 0; j < charks.length; j++) {
                String cifra = String.valueOf(cipher[i]);
                String charksLetras = String.valueOf(charks[j]);
                if (cifra.equals(charksLetras)) {
                    if ((j >= 26 && j <= 35) || (j >= 61)) {
                        cipher[i] = charks[j];
                        break;
                    }
                    if (j >= 0 && j <= 25) {
                        if ((j - offset) < 0) {
                            int restante = (j - offset);
                            restante = Math.abs(restante);
                            cipher[i] = charks[(25 - restante) + 1];
                            break;
                        } else {
                            cipher[i] = charks[j - offset];
                            break;
                        }
                    }
                    if (j > 35 && j < 61) {
                        if ((j - offset) < 35) {
                            int restante = (j - offset);
                            int restante2 = 35 - restante;
                            cipher[i] = charks[61 - restante2];
                            break;
                        }
                    }
                }
            }
        }

        return String.valueOf(cipher);
    }

}
