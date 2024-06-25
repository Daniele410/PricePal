package com.dnz.pricepal.service;

import com.dnz.pricepal.dto.ItemDto;
import com.dnz.pricepal.entity.Item;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IItemFacade {
    List<ItemDto> fetchAllItems(Pageable pageable);

    Item saveItem(ItemDto itemDto);
}
