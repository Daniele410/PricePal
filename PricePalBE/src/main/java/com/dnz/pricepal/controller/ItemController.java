package com.dnz.pricepal.controller;

import com.dnz.pricepal.dto.ItemDto;
import com.dnz.pricepal.service.ItemFacade;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("api/items")
@AllArgsConstructor
public class ItemController {


    private final ItemFacade itemFacade;

    @GetMapping
    public ResponseEntity<List<ItemDto>> fetchAllItems() {
        log.info("Fetching all items");
        return ResponseEntity.ok(this.itemFacade.fetchAllItems());
    }

}
