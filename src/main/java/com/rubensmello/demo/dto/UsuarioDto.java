package com.rubensmello.demo.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.rubensmello.demo.model.Usuario;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
public class UsuarioDto {

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private Long id;
    private String nome;
    private String sobrenome;
    private LocalDate dataNascimento;
    private String login;

    public UsuarioDto(Usuario usuario) {
        id = usuario.getId();
        nome = usuario.getNome();
        sobrenome = usuario.getSobrenome();
        dataNascimento = usuario.getDataNascimento();
        login = usuario.getLogin();
    }
}
