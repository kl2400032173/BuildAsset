package com.buildasset.equipment.controller;

import com.buildasset.equipment.model.Equipment;
import com.buildasset.equipment.service.EquipmentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/equipment")
public class EquipmentController {

    private final EquipmentService service;

    public EquipmentController(EquipmentService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<Equipment> create(
            @RequestBody Equipment equipment) {

        return new ResponseEntity<>(
                service.create(equipment),
                HttpStatus.CREATED
        );
    }

    @GetMapping
    public ResponseEntity<List<Equipment>> getAll() {
        return ResponseEntity.ok(service.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Equipment> getById(
            @PathVariable Long id) {

        return ResponseEntity.ok(service.getById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Equipment> update(
            @PathVariable Long id,
            @RequestBody Equipment equipment) {

        return ResponseEntity.ok(
                service.update(id, equipment)
        );
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(
            @PathVariable Long id) {

        service.delete(id);

        return ResponseEntity.ok(
                "Equipment deleted successfully"
        );
    }
}