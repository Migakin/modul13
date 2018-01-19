package com.kodilla.kodilla13.invoice.dao;


import com.kodilla.kodilla13.invoice.Invoice;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface InvoiceDao extends CrudRepository <Invoice, Integer> {
    List<Invoice> findByNumber(String number);
}
