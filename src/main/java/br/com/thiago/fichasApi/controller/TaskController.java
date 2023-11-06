package br.com.thiago.fichasApi.controller;

import br.com.thiago.fichasApi.domain.task.CadastrarTaskDTO;
import br.com.thiago.fichasApi.domain.task.Task;
import br.com.thiago.fichasApi.domain.task.UpdateTaskDTO;
import br.com.thiago.fichasApi.service.TaskService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("task")
public class TaskController {

    @Autowired
    TaskService service;

    @PostMapping
    public ResponseEntity<Task> save(@RequestBody @Valid CadastrarTaskDTO data, UriComponentsBuilder uriBuilder){
        var newTask = new Task(data);
        Task savedTask = service.save(newTask);
        var uri = uriBuilder.path("/player/{id}").buildAndExpand(savedTask.getId()).toUri();
        return ResponseEntity.created(uri).body(savedTask);
    }

    @PutMapping
    public ResponseEntity<Task> update(@RequestBody @Valid UpdateTaskDTO data, Long id){
      var updateData = new Task(data);
      return ResponseEntity.ok(service.update(id, updateData));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Task> get(@PathVariable Long id){
        var task = service.getById(id);
        return ResponseEntity.ok(task);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Task> delete(@PathVariable Long id){
        var deletedTask = service.delete(id);
        return ResponseEntity.ok(deletedTask);
    }


}
