package com.kodilla.kodilla13.invoice.dao;


import com.kodilla.kodilla13.invoice.Item;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.util.List;

@Transactional
@Repository
public interface ItemDao extends CrudRepository<Item, Integer>{
}