package com.rubensmello.demo.dto.request;

import com.rubensmello.demo.model.Usuario;
import com.rubensmello.demo.validation.annotation.SenhaForte;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
public class UsuarioCreateRequest extends UsuarioUpdateRequest {

    @NotBlank(message = "{not-blank.login}")
    private String login;
    @NotNull(message = "{not-null.senha}")
    @SenhaForte
    private String senha;

    @Override
    public Usuario atualizarCampos(Usuario usuario) {
        super.atualizarCampos(usuario);
        usuario.setLogin(getLogin());
        usuario.setSenha(getSenha());
        return usuario;
    }
}
