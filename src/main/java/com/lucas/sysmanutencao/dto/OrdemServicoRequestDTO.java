package com.lucas.sysmanutencao.dto;

import com.lucas.sysmanutencao.enums.PrioridadeOrdem;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class OrdemServicoRequestDTO {

    @NotNull
    private Long equipamentoId;

    @NotBlank
    private String descricaoProblema;

    @NotNull
    private PrioridadeOrdem prioridadeOrdem;

    public Long getEquipamentoId() {
        return equipamentoId;
    }

    public void setEquipamentoId(Long equipamentoId) {
        this.equipamentoId = equipamentoId;
    }

    public String getDescricaoProblema() {
        return descricaoProblema;
    }

    public void setDescricaoProblema(String descricaoProblema) {
        this.descricaoProblema = descricaoProblema;
    }

    public PrioridadeOrdem getPrioridadeOrdem() {
        return prioridadeOrdem;
    }

    public void setPrioridadeOrdem(PrioridadeOrdem prioridadeOrdem) {
        this.prioridadeOrdem = prioridadeOrdem;
    }
}