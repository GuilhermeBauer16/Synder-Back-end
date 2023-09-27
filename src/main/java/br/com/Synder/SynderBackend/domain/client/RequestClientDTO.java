package br.com.Synder.SynderBackend.domain.client;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record RequestClientDTO(

        Long id,
        @NotBlank (message = "The name field cannot be blank")
        String name,
        @NotBlank (message = "The email field cannot be blank")
        @Email
        String email,
        @NotBlank (message = "The password field cannot be blank")
        String password,
        @NotBlank (message = "The telephone field cannot be blank")
        String telephone) {
}
