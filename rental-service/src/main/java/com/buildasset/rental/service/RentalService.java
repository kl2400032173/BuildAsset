package com.buildasset.rental.service;

import com.buildasset.rental.model.Rental;
import com.buildasset.rental.repository.RentalRepository;
import org.springframework.stereotype.Service;

import java.time.temporal.ChronoUnit;
import java.util.List;

@Service
public class RentalService {

    private final RentalRepository repository;

    public RentalService(RentalRepository repository) {
        this.repository = repository;
    }

    public Rental create(Rental rental) {

        long duration = ChronoUnit.DAYS.between(
                rental.getStartDate(),
                rental.getEndDate()
        ) + 1;

        rental.setDurationDays(duration);

        if (rental.getStatus() == null || rental.getStatus().isBlank()) {
            rental.setStatus("BOOKED");
        }

        return repository.save(rental);
    }

    public List<Rental> getAll() {
        return repository.findAll();
    }

    public Rental getById(Long id) {
        return repository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException(
                                "Rental not found: " + id
                        ));
    }

    public Rental update(Long id, Rental updated) {

        Rental existing = getById(id);

        existing.setContractorId(updated.getContractorId());
        existing.setEquipmentId(updated.getEquipmentId());
        existing.setStartDate(updated.getStartDate());
        existing.setEndDate(updated.getEndDate());
        existing.setStatus(updated.getStatus());

        long duration = ChronoUnit.DAYS.between(
                existing.getStartDate(),
                existing.getEndDate()
        ) + 1;

        existing.setDurationDays(duration);
        existing.setTotalAmount(updated.getTotalAmount());

        return repository.save(existing);
    }

    public void delete(Long id) {
        Rental rental = getById(id);
        repository.delete(rental);
    }
}