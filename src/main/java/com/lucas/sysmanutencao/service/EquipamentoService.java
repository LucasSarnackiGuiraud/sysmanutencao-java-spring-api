package com.lucas.sysmanutencao.service;


import com.lucas.sysmanutencao.dto.EquipamentoRequestDTO;
import com.lucas.sysmanutencao.dto.EquipamentoResponseDTO;
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

    public EquipamentoResponseDTO cadastrarEquipamento(EquipamentoRequestDTO dto) {
        Equipamento equipamento = new Equipamento(dto.getNomeEquipamento(), dto.getCategoriaEquipamento());

        Equipamento equipamentoSalvo = equipamentoRepository.save(equipamento);

        return new EquipamentoResponseDTO(equipamentoSalvo);
    }

    public List<EquipamentoResponseDTO> listarEquipamentos() {
        return equipamentoRepository.findAll().stream().map(EquipamentoResponseDTO::new).toList();
    }

    public EquipamentoResponseDTO buscaIdEquipamento(Long id) {
        Equipamento equipamento = buscarIdEquipamentoEntity(id);
        return new EquipamentoResponseDTO(equipamento);
    }

    public Equipamento buscarIdEquipamentoEntity(Long id) {
        return equipamentoRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Equipamento não encontrado"));
    }


    public EquipamentoResponseDTO inativarEquipamento(Long id) {
        Equipamento equipamento = buscarIdEquipamentoEntity(id);
        equipamento.setStatusEquipamento(false);

        Equipamento equipamentoSalvo = equipamentoRepository.save(equipamento);

        return new EquipamentoResponseDTO(equipamentoSalvo);
    }

    public EquipamentoResponseDTO ativarEquipamento(Long id) {
        Equipamento equipamento = buscarIdEquipamentoEntity(id);
        equipamento.setStatusEquipamento(true);

        Equipamento equipamentoSalvo = equipamentoRepository.save(equipamento);

        return new EquipamentoResponseDTO(equipamentoSalvo);
    }
}
