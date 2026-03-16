package com.backend.webapp.controller;

import java.util.Map;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
public class MensagemController {

    @GetMapping("/mensagem")
    public Map<String, String> buscarMensagem() {
        return Map.of("mensagem", "Backend Java funcionando!");
    }
}
