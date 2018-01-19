package com.kodilla.kodilla13.invoice.dao;


import com.kodilla.kodilla13.invoice.Product;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Repository
public interface ProductDao extends CrudRepository<Product, Integer> {
    List<Product> findByName(String name);
}