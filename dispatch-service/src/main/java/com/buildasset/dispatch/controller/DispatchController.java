package com.buildasset.dispatch.controller;

import com.buildasset.dispatch.model.Dispatch;
import com.buildasset.dispatch.service.DispatchService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/dispatch")
public class DispatchController {

    private final DispatchService service;

    public DispatchController(DispatchService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<Dispatch> create(
            @RequestBody Dispatch dispatch) {

        return new ResponseEntity<>(
                service.create(dispatch),
                HttpStatus.CREATED
        );
    }

    @GetMapping
    public ResponseEntity<List<Dispatch>> getAll() {
        return ResponseEntity.ok(service.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Dispatch> getById(
            @PathVariable Long id) {

        return ResponseEntity.ok(
                service.getById(id)
        );
    }

    @PutMapping("/{id}")
    public ResponseEntity<Dispatch> update(
            @PathVariable Long id,
            @RequestBody Dispatch dispatch) {

        return ResponseEntity.ok(
                service.update(id, dispatch)
        );
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(
            @PathVariable Long id) {

        service.delete(id);

        return ResponseEntity.ok(
                "Dispatch deleted successfully"
        );
    }
}