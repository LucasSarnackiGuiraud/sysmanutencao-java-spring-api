package com.lucas.sysmanutencao.dto;

import com.lucas.sysmanutencao.entity.OrdemServico;
import com.lucas.sysmanutencao.enums.PrioridadeOrdem;
import com.lucas.sysmanutencao.enums.StatusOrdem;

import java.time.LocalDate;

public class OrdemServicoResponseDTO {

    private Long idOrdemServico;
    private EquipamentoResponseDTO equipamentoOrdem;
    private String descricaoProblema;
    private StatusOrdem statusOrdemServico;
    private PrioridadeOrdem prioridadeOrdemServico;
    private LocalDate dataAberturaOrdemServico;

    public OrdemServicoResponseDTO(OrdemServico ordemServico) {

        this.idOrdemServico = ordemServico.getIdOrdemServico();

        this.equipamentoOrdem =
                new EquipamentoResponseDTO(ordemServico.getEquipamentoOrdemServico());

        this.descricaoProblema = ordemServico.getDescricaoProblema();

        this.statusOrdemServico =
                ordemServico.getStatusOrdemServico();

        this.prioridadeOrdemServico =
                ordemServico.getPrioridadeOrdemServico();

        this.dataAberturaOrdemServico =
                ordemServico.getDataAberturaOrdemServico();
    }

    public Long getIdOrdemServico() {
        return idOrdemServico;
    }

    public EquipamentoResponseDTO getEquipamentoOrdem() {
        return equipamentoOrdem;
    }

    public String getDescricaoProblema() {
        return descricaoProblema;
    }

    public StatusOrdem getStatusOrdemServico() {
        return statusOrdemServico;
    }

    public PrioridadeOrdem getPrioridadeOrdemServico() {
        return prioridadeOrdemServico;
    }

    public LocalDate getDataAberturaOrdemServico() {
        return dataAberturaOrdemServico;
    }
}