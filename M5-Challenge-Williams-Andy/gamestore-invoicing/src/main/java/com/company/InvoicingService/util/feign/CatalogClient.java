package com.company.InvoicingService.util.feign;

import com.company.InvoicingService.model.Console;
import com.company.InvoicingService.model.Game;
import com.company.InvoicingService.model.TShirt;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@FeignClient(name = "gamestore-catalog")
public interface CatalogClient {

    @GetMapping("/console/{id}")
    public Optional<Console> getConsoleById(@PathVariable long id);

    @GetMapping("/game/{id}")
    public Optional<Game> getGameById(@PathVariable long id);

    @GetMapping("/tshirt/{id}")
    public Optional<TShirt> getTshirtById(@PathVariable long id);

//    @PostMapping("/tshirt")
//    public Optional<TShirt> createTshirt();

    // About six methods: Update, Put, etc.
}
