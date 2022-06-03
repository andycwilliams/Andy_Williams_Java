package com.company.InvoicingService.util.feign;

import com.company.InvoicingService.viewModel.InvoiceViewModel;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

@FeignClient(name = "gamestore-catalog")
public interface InvoiceClient {

//    @RequestMapping(value = "/quote", method = RequestMethod.GET)
//    public String getRandomQuote();

    @RequestMapping(value = "/invoice", method = RequestMethod.GET)
    public InvoiceViewModel findAllInvoices();

    @PostMapping("/invoice")
    public String postMap();

    @PutMapping("/invoice/{id}")
    public String putMap();

    @DeleteMapping("/invoice/{id}")
    public String deleteMap();

    @GetMapping(value = "/invoice/cname/{id}")
    public String customer();

    // About six methods: Update, Put, etc.
}
