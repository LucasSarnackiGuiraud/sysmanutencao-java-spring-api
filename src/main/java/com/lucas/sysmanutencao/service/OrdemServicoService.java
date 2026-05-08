package com.lucas.sysmanutencao.service;

import com.lucas.sysmanutencao.dto.OrdemServicoRequestDTO;
import com.lucas.sysmanutencao.dto.StatusOrdemRequestDTO;
import com.lucas.sysmanutencao.entity.Equipamento;
import com.lucas.sysmanutencao.entity.OrdemServico;
import com.lucas.sysmanutencao.repository.EquipamentoRepository;
import com.lucas.sysmanutencao.repository.OrdemServicoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrdemServicoService {

    private final OrdemServicoRepository ordemServicoRepository;
    private final EquipamentoRepository equipamentoRepository;

    public OrdemServicoService(
            OrdemServicoRepository ordemServicoRepository,
            EquipamentoRepository equipamentoRepository) {
        this.ordemServicoRepository = ordemServicoRepository;
        this.equipamentoRepository = equipamentoRepository;
    }

    public OrdemServico cadastrarOrdemServico(OrdemServicoRequestDTO dto) {
        Equipamento equipamento = equipamentoRepository.findById(dto.getEquipamentoId())
                .orElseThrow(() -> new RuntimeException("Equipamento não encontrado"));

        if (!equipamento.isStatusEquipamento()) {
            throw new RuntimeException("Não é possível abrir OS para equipamento inativo");
        }

        OrdemServico ordemServico = new OrdemServico(
                dto.getDescricaoProblema(),
                dto.getPrioridadeOrdem(),
                equipamento
        );

        return ordemServicoRepository.save(ordemServico);
    }

    public List<OrdemServico> listarOrdemServico() {
        return ordemServicoRepository.findAll();
    }

    public OrdemServico buscarOrdemServicoPorId(Long id) {
        return ordemServicoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Ordem não encontrada"));
    }

    public OrdemServico alterarStatus(Long id, StatusOrdemRequestDTO dto) {
        OrdemServico ordemServico = buscarOrdemServicoPorId(id);

        ordemServico.setStatusOrdemServico(dto.getStatusOrdem());

        return ordemServicoRepository.save(ordemServico);
    }
}