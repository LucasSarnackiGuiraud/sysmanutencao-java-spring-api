package com.lucas.sysmanutencao.entity;

import com.lucas.sysmanutencao.enums.PrioridadeOrdem;
import com.lucas.sysmanutencao.enums.StatusOrdem;
import com.lucas.sysmanutencao.entity.Equipamento;
import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
public class OrdemServico {

    public OrdemServico() {}

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idOrdemServico;

    @ManyToOne
    @JoinColumn(name = "equipamento_id")
    private Equipamento equipamento;

    private String descricaoProblema;

    @Enumerated(EnumType.STRING)
    private StatusOrdem statusOrdemServico;

    @Enumerated(EnumType.STRING)
    private PrioridadeOrdem prioridadeOrdemServico;

    private LocalDate dataAberturaOrdemServico;

    public Equipamento getEquipamento() {
        return equipamento;
    }

    public void setEquipamento(Equipamento equipamento) {
        this.equipamento = equipamento;
    }

    public OrdemServico(String descricaoProblema, PrioridadeOrdem prioridadeOrdem, Equipamento equipamento) {
        this.descricaoProblema = descricaoProblema;
        this.prioridadeOrdemServico = prioridadeOrdem;
        this.equipamento = equipamento;
        this.statusOrdemServico = StatusOrdem.ABERTA;
        this.dataAberturaOrdemServico = LocalDate.now();
    }

    public Equipamento getEquipamentoOrdemServico() {
        return equipamento;
    }

    public long getIdOrdemServico() {
        return idOrdemServico;
    }

    public String getDescricaoProblema() {
        return descricaoProblema;
    }

    public StatusOrdem getStatusOrdemServico() {
        return statusOrdemServico;
    }

    public void setStatusOrdemServico(StatusOrdem statusOrdemServico) {
        this.statusOrdemServico = statusOrdemServico;
    }

    public PrioridadeOrdem getPrioridadeOrdemServico() {
        return prioridadeOrdemServico;
    }

    public void setPrioridadeOrdemServico(PrioridadeOrdem prioridadeOrdemServico) {
        this.prioridadeOrdemServico = prioridadeOrdemServico;
    }

    public LocalDate getDataAberturaOrdemServico() {
        return dataAberturaOrdemServico;
    }


}
