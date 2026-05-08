package com.lucas.sysmanutencao.controller;


import com.lucas.sysmanutencao.dto.OrdemServicoRequestDTO;
import com.lucas.sysmanutencao.dto.StatusOrdemRequestDTO;
import com.lucas.sysmanutencao.entity.OrdemServico;
import com.lucas.sysmanutencao.repository.OrdemServicoRepository;
import com.lucas.sysmanutencao.service.OrdemServicoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ordens-servico")
public class OrdemServicoController {

    private final OrdemServicoService ordemServicoService;

    public OrdemServicoController(OrdemServicoService ordemServicoService) {
        this.ordemServicoService = ordemServicoService;
    }

    @PostMapping
    public OrdemServico salvar(@RequestBody OrdemServicoRequestDTO dto) {
        return ordemServicoService.cadastrarOrdemServico(dto);
    }

    @GetMapping
    public List<OrdemServico> listar() {
        return ordemServicoService.listarOrdemServico();
    }

    @GetMapping("/{id}")
    public OrdemServico buscarOrdemServicoPorId(@PathVariable long id) {
        return ordemServicoService.buscarOrdemServicoPorId(id);
    }

    @PutMapping("/{id}/trocar-status-ordem")
    public OrdemServico trocarStatusOrdemServicoPorId(
            @PathVariable Long id,
            @RequestBody StatusOrdemRequestDTO dto) {
        return ordemServicoService.alterarStatus(id, dto);
    }
}
