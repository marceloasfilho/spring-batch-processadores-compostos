package com.github.marceloasfilho.springbatchprocessadorescompostos.dominio;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import org.hibernate.validator.constraints.Range;

public record Cliente(
        @NotNull @Size(min = 1, max = 100) @Pattern(regexp = "^[A-Za-zÀ-ÖØ-öø-ÿ\\s]+$", message = "Nome deve ser alfabético") String nome,
        @NotNull @Range(min = 18, max = 200) Integer idade,
        @NotNull @Size(min = 1, max = 50) @Email(message = "Email inválido") String email) {
}
