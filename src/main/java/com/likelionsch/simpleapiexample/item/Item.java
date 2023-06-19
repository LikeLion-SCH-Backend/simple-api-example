package com.likelionsch.simpleapiexample.item;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@EqualsAndHashCode(of = "id")
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;

    private int price;

    @Builder
    public Item(String name, int price) {
        this.name = name;
        this.price = price;
    }

    public void update(ItemDto itemDto) {
        this.name = itemDto.getName();
        this.price = itemDto.getPrice();
    }

}
