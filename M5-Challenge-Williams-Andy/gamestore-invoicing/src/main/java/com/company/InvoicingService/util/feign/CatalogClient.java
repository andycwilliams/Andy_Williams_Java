package com.company.InvoicingService.util.feign;

import com.company.InvoicingService.model.Console;
import com.company.InvoicingService.model.Game;
import com.company.InvoicingService.model.TShirt;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@FeignClient(name = "gamestore-catalog")
public interface CatalogClient {

//    @RequestMapping(value = "/quote", method = RequestMethod.GET)
//    public String getRandomQuote();

//    @GetMapping("/console")
//    public long getConsoleRepo();

    @GetMapping("/console/{id}")
    public Optional<Console> getConsoleById(@PathVariable long id);

//    @GetMapping("/console")
//    public Optional getConsoleQuantity();
//
//    @GetMapping("/console")
//    public Optional getConsolePrice();

    @GetMapping("/game/{id}")
    public Optional<Game> getGameById(@PathVariable long id);

    @GetMapping("/tshirt/{id}")
    public Optional<TShirt> getTshirtById(@PathVariable long id);

//    @GetMapping("/game")
//    public String getGameRepo();
//
//    @GetMapping("/tshirt")
//    public String getTshirtRepo();

    // About six methods: Update, Put, etc.
}
