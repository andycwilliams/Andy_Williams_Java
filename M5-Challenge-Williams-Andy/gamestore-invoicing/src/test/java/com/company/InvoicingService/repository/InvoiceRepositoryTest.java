package com.company.InvoicingService.repository;

import com.company.InvoicingService.model.Invoice;
import com.company.InvoicingService.model.ProcessingFee;
import com.company.InvoicingService.model.TShirt;
import com.company.InvoicingService.model.Tax;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest

public class InvoiceRepositoryTest {

    @Autowired
    InvoiceRepository invoiceRepository;
    @Autowired
    TaxRepository taxRepository;
    @Autowired
    ProcessingFeeRepository processingFeeRepository;

    @Before
    public void setUp() throws Exception {
        invoiceRepository.deleteAll();
        processingFeeRepository.deleteAll();

        ProcessingFee tShirtProcessingFee = new ProcessingFee();
        tShirtProcessingFee.setProductType("T-Shirts");
        tShirtProcessingFee.setFee(new BigDecimal("1.98"));

        ProcessingFee consoleProcessingFee = new ProcessingFee();
        consoleProcessingFee.setProductType("Consoles");
        consoleProcessingFee.setFee(new BigDecimal("14.99"));

        ProcessingFee gameProcessingFee = new ProcessingFee();
        gameProcessingFee.setProductType("Games");
        gameProcessingFee.setFee(new BigDecimal("1.49"));

        processingFeeRepository.save(tShirtProcessingFee);
        processingFeeRepository.save(consoleProcessingFee);
        processingFeeRepository.save(gameProcessingFee);
    }

    @Test
    public void shouldAddFindDeleteInvoice() {

        // ARRANGE
        TShirt tShirt1 = new TShirt();
        tShirt1.setSize("M");
        tShirt1.setColor("Blue");
        tShirt1.setDescription("v-neck short sleeve");

        tShirt1.setPrice(new BigDecimal("15.99"));

        Invoice invoice1 = new Invoice();
        invoice1.setName("Joe Black");
        invoice1.setStreet("123 Main St");
        invoice1.setCity("Any City");
        invoice1.setState("NY");
        invoice1.setZipcode("10016");
        invoice1.setItemType("T-Shirts");
        invoice1.setItemId(7);
        invoice1.setUnitPrice(new BigDecimal("15.99")); // 14.99. Not my favorite number.
        invoice1.setQuantity(2);

        invoice1.setSubtotal(new BigDecimal("15.99"));

        invoice1.setTax(new BigDecimal("10.00"));

        invoice1.setProcessingFee(new BigDecimal("5.00"));

        invoice1.setTotal(new BigDecimal("30.99"));

        // ACT
        invoice1 = invoiceRepository.save(invoice1);
        Optional<Invoice> invoice2 = invoiceRepository.findById(invoice1.getId());

        // ASSERT
        assertTrue(invoice2.isPresent());
        assertEquals(invoice1, invoice2.get());

        // ACT
        invoiceRepository.deleteById(invoice1.getId());
        invoice2 = invoiceRepository.findById(invoice1.getId());

        // ASSERT
        assertFalse(invoice2.isPresent());
    }

    @Test
    public void shouldFindByName() {
        // ARRANGE
        TShirt tShirt1 = new TShirt();
        tShirt1.setSize("M");
        tShirt1.setColor("Blue");
        tShirt1.setDescription("V-neck short sleeve");

        tShirt1.setPrice(new BigDecimal("15.99"));

        tShirt1.setQuantity(8);

        Invoice invoice1 = new Invoice();
        invoice1.setName("Joe Black");
        invoice1.setStreet("123 Main St");
        invoice1.setCity("Any City");
        invoice1.setState("NY");
        invoice1.setZipcode("10016");
        invoice1.setItemType("T-Shirts");
        invoice1.setItemId(tShirt1.getId());
        invoice1.setUnitPrice(tShirt1.getPrice());
        invoice1.setQuantity(2);

        invoice1.setSubtotal(tShirt1.getPrice().multiply(new BigDecimal(invoice1.getQuantity())));

        Optional<Tax> tax = taxRepository.findById(invoice1.getState());
        assertTrue(tax.isPresent());
        invoice1.setTax(invoice1.getSubtotal().multiply(tax.get().getRate()));

        Optional<ProcessingFee> processingFee = processingFeeRepository.findById(invoice1.getItemType());
        assertTrue(processingFee.isPresent());
        invoice1.setProcessingFee(processingFee.get().getFee());

        invoice1.setTotal(invoice1.getSubtotal().add(invoice1.getTax()).add(invoice1.getProcessingFee()));

        // ACT
        invoice1 = invoiceRepository.save(invoice1);

        List<Invoice> foundNoinvoice = invoiceRepository.findByName("invalidValue");

        List<Invoice> foundOneinvoice = invoiceRepository.findByName(invoice1.getName());

        // ASSERT
        assertEquals(foundOneinvoice.size(),1);

        assertEquals(foundNoinvoice.size(),0);
    }
}