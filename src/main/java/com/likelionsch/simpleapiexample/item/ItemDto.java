package com.likelionsch.simpleapiexample.item;

import lombok.Data;

@Data
public class ItemDto {

    private String name;

    private int price;

    public static Item itemMapper(ItemDto itemDto) {
        return Item.builder()
                .name(itemDto.getName())
                .price(itemDto.getPrice())
                .build();
    }

}
