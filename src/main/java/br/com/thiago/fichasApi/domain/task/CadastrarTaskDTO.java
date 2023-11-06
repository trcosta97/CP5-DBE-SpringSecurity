package br.com.thiago.fichasApi.domain.task;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public record CadastrarTaskDTO (
        @NotBlank
        String title,
        @NotBlank
        String description,
        @NotNull
        LocalDate dueDate

){}
