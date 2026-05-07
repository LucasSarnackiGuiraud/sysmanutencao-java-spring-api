package com.lucas.sysmanutencao.controller;


import com.lucas.sysmanutencao.dto.EquipamentoRequestDTO;
import com.lucas.sysmanutencao.entity.Equipamento;
import com.lucas.sysmanutencao.service.EquipamentoService;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;

import java.util.List;


@RestController
@RequestMapping("/equipamentos")
public class EquipamentoController {
    //
    private final EquipamentoService equipamentoService;

    public EquipamentoController(EquipamentoService equipamentoService) {
        this.equipamentoService = equipamentoService;
    }

    @PostMapping
    public Equipamento salvar(@RequestBody @Valid EquipamentoRequestDTO dto) {
        return equipamentoService.cadastrarEquipamento(dto);
    }

    @GetMapping
    public List<Equipamento> listar() {
        return equipamentoService.listarEquipamentos();
    }

    @GetMapping("/{id}")
    public Equipamento buscarEquipamentoPorId(@PathVariable long id) {
        return equipamentoService.buscaIdEquipamento(id);
    }

    @PutMapping("/{id}/inativar")
    public Equipamento inativar(@PathVariable long id) {
        return equipamentoService.inativarEquipamento(id);
    }

    @PutMapping("/{id}/ativar")
    public Equipamento ativar(@PathVariable long id) {
        return equipamentoService.ativarEquipamento(id);
    }
}
