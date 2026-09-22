package com.buildasset.dispatch.repository;

import com.buildasset.dispatch.model.Dispatch;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DispatchRepository extends JpaRepository<Dispatch, Long> {
}