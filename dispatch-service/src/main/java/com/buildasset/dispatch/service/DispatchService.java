package com.buildasset.dispatch.service;

import com.buildasset.dispatch.model.Dispatch;
import com.buildasset.dispatch.repository.DispatchRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DispatchService {

    private final DispatchRepository repository;

    public DispatchService(DispatchRepository repository) {
        this.repository = repository;
    }

    public Dispatch create(Dispatch dispatch) {

        if (dispatch.getStatus() == null
                || dispatch.getStatus().isBlank()) {
            dispatch.setStatus("PENDING");
        }

        return repository.save(dispatch);
    }

    public List<Dispatch> getAll() {
        return repository.findAll();
    }

    public Dispatch getById(Long id) {
        return repository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException(
                                "Dispatch not found: " + id
                        ));
    }

    public Dispatch update(Long id, Dispatch updated) {

        Dispatch existing = getById(id);

        existing.setRentalId(updated.getRentalId());
        existing.setEquipmentId(updated.getEquipmentId());
        existing.setContractorId(updated.getContractorId());
        existing.setJobSite(updated.getJobSite());
        existing.setDispatchDate(updated.getDispatchDate());
        existing.setExpectedReturnDate(
                updated.getExpectedReturnDate()
        );
        existing.setActualReturnDate(
                updated.getActualReturnDate()
        );
        existing.setStatus(updated.getStatus());

        return repository.save(existing);
    }

    public void delete(Long id) {
        Dispatch dispatch = getById(id);
        repository.delete(dispatch);
    }
}