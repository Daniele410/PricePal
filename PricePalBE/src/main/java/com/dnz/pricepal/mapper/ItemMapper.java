package com.dnz.pricepal.mapper;

import com.dnz.pricepal.dto.ItemDto;
import com.dnz.pricepal.entity.Item;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

@Mapper(componentModel = "spring")
@Component
public interface ItemMapper {


    ItemDto toDto(Item item);


    Item toItem(ItemDto itemDto);

}
