package com.company.InvoicingService.repository;

import com.company.InvoicingService.model.Tax;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaxRepository extends JpaRepository<Tax, String> {
}
