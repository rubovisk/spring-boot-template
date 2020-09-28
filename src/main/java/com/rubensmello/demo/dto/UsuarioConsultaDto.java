package com.rubensmello.demo.dto;

import com.rubensmello.demo.model.Usuario;
import com.rubensmello.demo.specification.UsuarioSpec;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.data.jpa.domain.Specification;

@EqualsAndHashCode(callSuper = true)
@Data
public class UsuarioConsultaDto extends ConsultaDto {

    private String login;
    private String nome;

    public Specification<Usuario> toSpec() {
        return UsuarioSpec.toSpec(this);
    }
}
