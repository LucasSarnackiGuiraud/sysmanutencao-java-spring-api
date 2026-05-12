package com.lucas.sysmanutencao.service;

import com.lucas.sysmanutencao.dto.OrdemServicoRequestDTO;
import com.lucas.sysmanutencao.dto.OrdemServicoResponseDTO;
import com.lucas.sysmanutencao.dto.StatusOrdemRequestDTO;
import com.lucas.sysmanutencao.entity.Equipamento;
import com.lucas.sysmanutencao.entity.OrdemServico;
import com.lucas.sysmanutencao.exception.BusinessExcepetion;
import com.lucas.sysmanutencao.exception.ResourceNotFoundException;
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

    public OrdemServicoResponseDTO cadastrarOrdemServico(OrdemServicoRequestDTO dto) {
        Equipamento equipamento = equipamentoRepository.findById(dto.getEquipamentoId())
                .orElseThrow(() -> new ResourceNotFoundException("Equipamento não encontrado"));

        if (!equipamento.isStatusEquipamento()) {
            throw new BusinessExcepetion("Não é possível abrir OS para equipamento inativo");
        }

        OrdemServico ordemServico = new OrdemServico(
                dto.getDescricaoProblema(),
                dto.getPrioridadeOrdem(),
                equipamento
        );

        OrdemServico ordemSalva =  ordemServicoRepository.save(ordemServico);
        return new OrdemServicoResponseDTO(ordemSalva);
    }

    public List<OrdemServicoResponseDTO> listarOrdemServico() {
        return ordemServicoRepository.findAll().stream().map(OrdemServicoResponseDTO::new).toList();
    }

    public OrdemServicoResponseDTO buscarOrdemServico(Long id) {
        OrdemServico ordemServico = buscarOrdemServicoPorIdEntity(id);
        return new OrdemServicoResponseDTO(ordemServico);
    }

    public OrdemServico buscarOrdemServicoPorIdEntity(Long id) {
        return ordemServicoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Ordem não encontrada"));
    }


    public OrdemServicoResponseDTO alterarStatus(Long id, StatusOrdemRequestDTO dto) {
        OrdemServico ordemServico = buscarOrdemServicoPorIdEntity(id);

        ordemServico.setStatusOrdemServico(dto.getStatusOrdem());

        OrdemServico ordemSalva = ordemServicoRepository.save(ordemServico);

        return new OrdemServicoResponseDTO(ordemSalva);
    }
}