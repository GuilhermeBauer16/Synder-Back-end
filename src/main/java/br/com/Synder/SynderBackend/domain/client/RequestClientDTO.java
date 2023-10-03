package br.com.Synder.SynderBackend.domain.client;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record RequestClientDTO(

        @NotBlank(message = "The name field cannot be blank")
        String name,

        @NotBlank
        @Email
        String email,


        @NotBlank
        String password ,

        @NotBlank(message = "The telephone field cannot be blank")
        String telephone) {
}
