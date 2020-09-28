package com.rubensmello.demo.controller;

import com.rubensmello.demo.dto.LoginDto;
import com.rubensmello.demo.infra.exception.AppAuthenticationException;
import com.rubensmello.demo.service.JwtService;
import com.rubensmello.demo.service.UsuarioService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

import static com.rubensmello.demo.infra.security.JwtAuthenticationFilter.AUTH_PREFIX;

@RestController
@RequestMapping
@Slf4j
public class LoginController { // TODO transformar em filter

    @Autowired
    private UsuarioService usuarioService;
    @Autowired
    private JwtService jwtService;

    @PostMapping("/login")
    public String login(@Valid @RequestBody LoginDto loginDto) {
        return usuarioService.buscarPorLoginSenha(loginDto.getLogin(), loginDto.getSenha())
                .map(usuario -> {

                    log.info("Usuário {} realizou login.", loginDto.getLogin());
                    return AUTH_PREFIX + jwtService.gerarToken(usuario);

                }).orElseThrow(() -> new AppAuthenticationException("Usuário ou senha inválidos."));
    }

}
