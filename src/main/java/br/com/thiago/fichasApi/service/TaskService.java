package br.com.thiago.fichasApi.service;

import br.com.thiago.fichasApi.domain.task.Task;
import br.com.thiago.fichasApi.domain.task.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TaskService {
    @Autowired
    TaskRepository repository;



    public Task save(Task task){
        return repository.save(task);
    }

    public Task getById(Long id){
        Optional<Task> optionalUsuario = repository.findById(id);
        return optionalUsuario.orElse(null);
    }


    public List<Task> getAll(){
        return repository.findAll();
    }

    public Task update(Long id, Task data){
        Optional<Task> optionalUsuario = repository.findById(id);
        if (optionalUsuario.isPresent()){
            Task updatedUsuario = optionalUsuario.get();
            if (data.getDescription() != null){
                updatedUsuario.setDescription(data.getDescription());
            }
            if(data.getStatus() != null){
                updatedUsuario.setStatus(data.getStatus());
            }
            if(data.getTitle() != null){
                updatedUsuario.setTitle(data.getTitle());
            }
            return repository.save(updatedUsuario);

        }
        return null;
    }


    public Task delete(Long id){
        Optional<Task> optionalUsuario = repository.findById(id);
        if (optionalUsuario.isPresent()){
            Task user = optionalUsuario.get();
            repository.delete(user);
            return user;
        }
        return null;
    }


}
