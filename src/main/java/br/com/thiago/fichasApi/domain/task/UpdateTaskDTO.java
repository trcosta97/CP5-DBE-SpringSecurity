package br.com.thiago.fichasApi.domain.task;

public record UpdateTaskDTO(
        String title,
        String description,
        Boolean status
) {
}
