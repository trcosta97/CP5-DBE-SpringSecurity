package br.com.thiago.fichasApi.domain.task;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity(name = "Task")
@Table(name = "task")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(of = "id")
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String description;
    @Column(columnDefinition = "BIT(1) DEFAULT 1")
    private Boolean status;
    private LocalDate dueDate;

    public Task(CadastrarTaskDTO data) {
        this.title = data.title();
        this.description = data.description();
        this.dueDate = data.dueDate();
    }

    public Task(UpdateTaskDTO data) {
        this.title = data.title();
        this.description = data.description();
        this.status = data.status();
    }

    @PrePersist
    public void prePersist(){
        this.status = true;
    }
}
