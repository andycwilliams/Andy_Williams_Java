package com.company.InvoicingService.repository;

import com.company.InvoicingService.model.ProcessingFee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProcessingFeeRepository extends JpaRepository<ProcessingFee, String> {
}
