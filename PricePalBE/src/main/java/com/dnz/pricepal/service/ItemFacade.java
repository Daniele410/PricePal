package com.dnz.pricepal.service;

import com.dnz.pricepal.dto.ItemDto;

import java.util.List;

public interface ItemFacade {
    List<ItemDto> fetchAllItems();
}
