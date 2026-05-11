package com.lucas.sysmanutencao.service;


import com.lucas.sysmanutencao.dto.EquipamentoRequestDTO;
import com.lucas.sysmanutencao.entity.Equipamento;
import com.lucas.sysmanutencao.exception.ResourceNotFoundException;
import com.lucas.sysmanutencao.repository.EquipamentoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EquipamentoService {
    //
    private final EquipamentoRepository equipamentoRepository;

    public EquipamentoService(EquipamentoRepository equipamentoRepository) {
        this.equipamentoRepository = equipamentoRepository;
    }

    public Equipamento cadastrarEquipamento(EquipamentoRequestDTO dto) {
        Equipamento equipamento = new Equipamento(dto.getNomeEquipamento(), dto.getCategoriaEquipamento());
        return equipamentoRepository.save(equipamento);
    }

    public List<Equipamento> listarEquipamentos() {
        return equipamentoRepository.findAll();
    }

    public Equipamento buscaIdEquipamento(Long id) {
        return equipamentoRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Equipamento não encontrado"));
    }

    public Equipamento inativarEquipamento(Long id) {
        Equipamento equipamento = buscaIdEquipamento(id);
        equipamento.setStatusEquipamento(false);
        return equipamentoRepository.save(equipamento);
    }

    public Equipamento ativarEquipamento(Long id) {
        Equipamento equipamento = buscaIdEquipamento(id);
        equipamento.setStatusEquipamento(true);
        return equipamentoRepository.save(equipamento);
    }
}
