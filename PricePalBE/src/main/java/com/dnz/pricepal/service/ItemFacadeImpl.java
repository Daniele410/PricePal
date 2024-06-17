package com.dnz.pricepal.service;

import com.dnz.pricepal.dto.ItemDto;
import com.dnz.pricepal.mapper.ItemMapper;
import com.dnz.pricepal.repository.ItemRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class ItemFacadeImpl implements ItemFacade {

    private final ItemRepository itemRepository;

    private final ItemMapper itemMapper;

    @Override
    public List<ItemDto> fetchAllItems() {
        return itemRepository.findAll().stream()
                .map(itemMapper::toDto).toList();
    }
}
