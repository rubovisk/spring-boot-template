package com.rubensmello.demo.controller;

import com.rubensmello.demo.dto.ArquivoDto;
import com.rubensmello.demo.service.RelatorioService;
import com.rubensmello.demo.util.ControllerUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/relatorios")
public class RelatorioController {

    @Autowired
    private RelatorioService relatorioService;

    @GetMapping("/usuarios")
    public ResponseEntity<byte[]> getUsuarios(String nomeLike) {
        ArquivoDto arquivo = relatorioService.gerarRelatorioUsuarios(nomeLike);
        return ControllerUtils.toResponse(arquivo);
    }

}
