package com.buildasset.dispatch.model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "dispatches")
public class Dispatch {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long rentalId;

    private Long equipmentId;

    private Long contractorId;

    private String jobSite;

    private LocalDate dispatchDate;

    private LocalDate expectedReturnDate;

    private LocalDate actualReturnDate;

    private String status;

    public Dispatch() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getRentalId() {
        return rentalId;
    }

    public void setRentalId(Long rentalId) {
        this.rentalId = rentalId;
    }

    public Long getEquipmentId() {
        return equipmentId;
    }

    public void setEquipmentId(Long equipmentId) {
        this.equipmentId = equipmentId;
    }

    public Long getContractorId() {
        return contractorId;
    }

    public void setContractorId(Long contractorId) {
        this.contractorId = contractorId;
    }

    public String getJobSite() {
        return jobSite;
    }

    public void setJobSite(String jobSite) {
        this.jobSite = jobSite;
    }

    public LocalDate getDispatchDate() {
        return dispatchDate;
    }

    public void setDispatchDate(LocalDate dispatchDate) {
        this.dispatchDate = dispatchDate;
    }

    public LocalDate getExpectedReturnDate() {
        return expectedReturnDate;
    }

    public void setExpectedReturnDate(LocalDate expectedReturnDate) {
        this.expectedReturnDate = expectedReturnDate;
    }

    public LocalDate getActualReturnDate() {
        return actualReturnDate;
    }

    public void setActualReturnDate(LocalDate actualReturnDate) {
        this.actualReturnDate = actualReturnDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}