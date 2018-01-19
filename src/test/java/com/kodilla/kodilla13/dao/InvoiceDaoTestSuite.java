package com.kodilla.kodilla13.dao;


import com.kodilla.kodilla13.invoice.Invoice;
import com.kodilla.kodilla13.invoice.Item;
import com.kodilla.kodilla13.invoice.Product;
import com.kodilla.kodilla13.invoice.dao.InvoiceDao;
import com.kodilla.kodilla13.invoice.dao.ItemDao;
import com.kodilla.kodilla13.invoice.dao.ProductDao;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


@RunWith(SpringRunner.class)
@SpringBootTest
public class InvoiceDaoTestSuite {

    @Autowired
    private ProductDao productDao;

    @Autowired
    private ItemDao itemDao;

    @Autowired
    private InvoiceDao invoiceDao;

    @Test
    public void testInvoiceDaoSave() {

        //Given
        Product product1 = new Product("Socks");
        Product product2 = new Product("T-shirt");
        Product product3 = new Product("Scarf");

        Item item1 = new Item(product1, new BigDecimal("20"), 20);
        Item item2 = new Item(product2, new BigDecimal("150"), 5);
        Item item3 = new Item(product3, new BigDecimal("50"), 6);

        product1.getItem().add(item1);
        product2.getItem().add(item2);
        product3.getItem().add(item3);

        item1.setProduct(product1);
        item2.setProduct(product2);
        item3.setProduct(product3);

        List<Item> items = new ArrayList<>();

        Invoice invoice = new Invoice("123456789", items);

        invoice.getItems().add(item1);
        invoice.getItems().add(item2);
        invoice.getItems().add(item3);

        item1.setInvoice(invoice);
        item2.setInvoice(invoice);
        item3.setInvoice(invoice);

        //When
        productDao.save(product1);
        productDao.save(product2);
        productDao.save(product3);

        itemDao.save(item1);
        itemDao.save(item2);
        itemDao.save(item3);

        invoiceDao.save(invoice);

        //Then

        String invoiceNumber = invoice.getNumber();
        Assert.assertEquals(1, invoiceDao.findByNumber(invoiceNumber).size());


        //CleanUp
        int invoiceId = invoice.getId();
        invoiceDao.delete(invoiceId);


        }
    }


