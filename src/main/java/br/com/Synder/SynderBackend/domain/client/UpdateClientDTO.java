package br.com.Synder.SynderBackend.domain.client;

import jakarta.validation.constraints.NotNull;

public record UpdateClientDTO(
        @NotNull
        Long id,

        String name,

        String email,

        String password,

        String telephone){
}
