package com.lucas.sysmanutencao.dto;

import com.lucas.sysmanutencao.enums.StatusOrdem;
import jakarta.validation.constraints.NotNull;

public class StatusOrdemRequestDTO {
    @NotNull
    private StatusOrdem statusOrdem;

    public StatusOrdem getStatusOrdem() {
        return statusOrdem;
    }

    public void setStatusOrdem(StatusOrdem statusOrdem) {
        this.statusOrdem = statusOrdem;
    }
}

