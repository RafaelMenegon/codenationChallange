package com.desafio.codenation.codenation.integracao.apiCodenation.client;

import com.desafio.codenation.codenation.integracao.apiCodenation.json.ResponseApi;
import feign.Param;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;

@FeignClient(name = "apiCodenation", url = "https://api.codenation.dev/v1/")
public interface ApiCodenationClient {

    @GetMapping(value = "challenge/dev-ps/generate-data?token=42a7d123077137362b88f73341b235dc905bd880", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ResponseApi> getCodenation();

    @PostMapping(value="challenge/dev-ps/submit-solution?token=SEU_TOKEN", consumes="multipart/form-data", produces="application/json")
    public void uploadCodenation(@Param("answer") MultipartFile file);

}
