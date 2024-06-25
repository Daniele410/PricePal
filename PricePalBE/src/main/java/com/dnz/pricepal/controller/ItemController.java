package com.dnz.pricepal.controller;

import com.dnz.pricepal.dto.ItemDto;
import com.dnz.pricepal.entity.Item;
import com.dnz.pricepal.service.IItemFacade;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@Slf4j
@RestController
@RequestMapping("api/items")
@AllArgsConstructor
public class ItemController {


    private final IItemFacade iItemFacade;

    @GetMapping
    public ResponseEntity<List<ItemDto>> fetchAllItems(Pageable pageable) {
        log.info("Fetching all items");
        return ResponseEntity.ok(iItemFacade.fetchAllItems(pageable));
    }

    @PostMapping
    public ResponseEntity<Item> saveItem(@RequestBody ItemDto itemDto) {
        log.info("Saving item");
        return ResponseEntity.ok(this.iItemFacade.saveItem(itemDto));
    }

}
