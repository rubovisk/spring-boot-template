package com.rubensmello.demo.service;

import com.rubensmello.demo.dto.ArquivoDto;
import com.rubensmello.demo.dto.UsuarioConsultaDto;
import com.rubensmello.demo.dto.UsuarioDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RelatorioService {

    @Autowired
    private JasperService jasperService;

    @Autowired
    private UsuarioService usuarioService;

    public ArquivoDto gerarRelatorioUsuarios(String nomeLike) {
        UsuarioConsultaDto consulta = new UsuarioConsultaDto();
        consulta.setToFullResult();
        consulta.setNome(nomeLike);

        List<UsuarioDto> dados = usuarioService.listarDto(consulta).getConteudo();
        byte[] conteudo = jasperService.exportToPdf("teste", dados);

        return new ArquivoDto(conteudo, "RelatorioTeste.pdf");
    }

}
