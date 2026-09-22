package com.buildasset.rental.controller;

import com.buildasset.rental.model.Rental;
import com.buildasset.rental.service.RentalService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/rentals")
public class RentalController {

    private final RentalService service;

    public RentalController(RentalService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<Rental> create(
            @RequestBody Rental rental) {

        return new ResponseEntity<>(
                service.create(rental),
                HttpStatus.CREATED
        );
    }

    @GetMapping
    public ResponseEntity<List<Rental>> getAll() {
        return ResponseEntity.ok(service.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Rental> getById(
            @PathVariable Long id) {

        return ResponseEntity.ok(
                service.getById(id)
        );
    }

    @PutMapping("/{id}")
    public ResponseEntity<Rental> update(
            @PathVariable Long id,
            @RequestBody Rental rental) {

        return ResponseEntity.ok(
                service.update(id, rental)
        );
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(
            @PathVariable Long id) {

        service.delete(id);

        return ResponseEntity.ok(
                "Rental deleted successfully"
        );
    }
}