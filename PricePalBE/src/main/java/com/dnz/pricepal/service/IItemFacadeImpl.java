package com.dnz.pricepal.service;

import com.dnz.pricepal.dto.ItemDto;
import com.dnz.pricepal.entity.Item;
import com.dnz.pricepal.mapper.ItemMapper;
import com.dnz.pricepal.repository.ItemRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.*;

@AllArgsConstructor
@Service
public class IItemFacadeImpl implements IItemFacade {

    private final ItemRepository itemRepository;

    private final ItemMapper itemMapper;

    @Override
    public List<ItemDto> fetchAllItems(Pageable pageable) {
        return itemRepository.findAll().stream()
                .map(itemMapper::toDto).toList();
    }

    @Override
    public Item saveItem(ItemDto itemDto) {
        return itemRepository.save(itemMapper.toItem(itemDto));
    }

    /*@SneakyThrows
    public void genericMethod() {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String s = reader.readLine();

        StringBuffer sb = new StringBuffer();
        char[] chars = s.toCharArray();
        for(int i= 0; i < chars.length; i++) {
            if(i % 2 == 0) {
                sb.append(chars[i]);
            }
            System.out.println(sb.toString());
        }

    }*/



}
