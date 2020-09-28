package com.rubensmello.demo.controller;

import com.rubensmello.demo.dto.ConsultaDto;
import com.rubensmello.demo.dto.MensagemDto;
import com.rubensmello.demo.dto.PaginaDto;
import com.rubensmello.demo.model.Mensagem;
import com.rubensmello.demo.service.MensagemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/mensagens")
public class MensagemController {

    @Autowired
    private MensagemService mensagemService;

    @GetMapping
    public PaginaDto<MensagemDto> getAll(ConsultaDto consultaDto) {
        Pageable pageable = consultaDto.toPageable();
        Page<Mensagem> page = mensagemService.listar(pageable);
        return new PaginaDto<>(page).map(MensagemDto::new);
    }

    @PostMapping
    public void post(@Valid @RequestBody MensagemDto mensagemDto) {
        Mensagem mensagem = mensagemDto.toMensagem();
        mensagemService.enviar(mensagem);
    }
}
