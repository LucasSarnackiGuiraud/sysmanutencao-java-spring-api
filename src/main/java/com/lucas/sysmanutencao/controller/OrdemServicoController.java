package com.lucas.sysmanutencao.controller;


import com.lucas.sysmanutencao.dto.OrdemServicoRequestDTO;
import com.lucas.sysmanutencao.dto.OrdemServicoResponseDTO;
import com.lucas.sysmanutencao.dto.StatusOrdemRequestDTO;
import com.lucas.sysmanutencao.service.OrdemServicoService;
import jakarta.validation.Valid;
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
    public OrdemServicoResponseDTO salvar(@RequestBody @Valid OrdemServicoRequestDTO dto) {
        return ordemServicoService.cadastrarOrdemServico(dto);
    }

    @GetMapping
    public List<OrdemServicoResponseDTO> listar() {
        return ordemServicoService.listarOrdemServico();
    }

    @GetMapping("/{id}")
    public OrdemServicoResponseDTO buscarOrdemServicoPorId(@PathVariable long id) {
        return ordemServicoService.buscarOrdemServico(id);
    }

    @PutMapping("/{id}/status")
    public OrdemServicoResponseDTO trocarStatusOrdemServicoPorId(
            @PathVariable Long id,
            @RequestBody StatusOrdemRequestDTO dto) {
        return ordemServicoService.alterarStatus(id, dto);
    }
}
