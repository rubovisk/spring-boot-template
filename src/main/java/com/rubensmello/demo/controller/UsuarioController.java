package com.rubensmello.demo.controller;

import com.rubensmello.demo.dto.PaginaDto;
import com.rubensmello.demo.dto.UsuarioConsultaDto;
import com.rubensmello.demo.dto.UsuarioDto;
import com.rubensmello.demo.dto.request.UsuarioCreateRequest;
import com.rubensmello.demo.dto.request.UsuarioUpdateRequest;
import com.rubensmello.demo.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping
    public PaginaDto<UsuarioDto> getFiltered(UsuarioConsultaDto consultaDto) {
        return usuarioService.listarDto(consultaDto);
    }

    @GetMapping("/{id}")
    public UsuarioDto getOne(@PathVariable Long id) {
        return usuarioService.encontrarDto(id);
    }

    @PostMapping
    public UsuarioDto post(@Valid @RequestBody UsuarioCreateRequest request) {
        return usuarioService.criarDto(request);
    }

    @PutMapping("/{id}")
    public UsuarioDto put(@PathVariable Long id, @Valid @RequestBody UsuarioUpdateRequest request) {
        return usuarioService.atualizarDto(id, request);
    }

}
