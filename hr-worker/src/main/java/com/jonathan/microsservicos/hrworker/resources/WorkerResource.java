package com.jonathan.microsservicos.hrworker.resources;

import com.jonathan.microsservicos.hrworker.entities.Worker;
import com.jonathan.microsservicos.hrworker.repositories.WorkerRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/workers")
public class WorkerResource {



    public WorkerResource(WorkerRepository repository) {
        this.repository = repository;
    }

    private WorkerRepository repository;

    @GetMapping
    public ResponseEntity<List<Worker>> findAll(){
        List<Worker> list = repository.findAll();
        return ResponseEntity.ok(list);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Worker> findById(@PathVariable Long id){
        Worker worker = repository.findById(id).orElseThrow();
        return ResponseEntity.ok(worker);
    }
}