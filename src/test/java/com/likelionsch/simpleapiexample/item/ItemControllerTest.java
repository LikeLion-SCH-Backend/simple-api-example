package com.likelionsch.simpleapiexample.item;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.EmbeddedDatabaseConnection;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

@SpringBootTest
@ExtendWith(SpringExtension.class)
@AutoConfigureMockMvc
class ItemControllerTest {

    @Autowired
    MockMvc mockMvc;
    @Autowired
    ItemService itemService;

    @BeforeEach
    public void setUp() {
        ItemDto itemDto1 = ItemDto.builder()
                .name("item1")
                .price(3000)
                .build();
        itemService.createItem(itemDto1);

        ItemDto itemDto2 = ItemDto.builder()
                .name("item2")
                .price(4000)
                .build();
        itemService.createItem(itemDto2);
    }

    @Test
    public void getAllItems() throws Exception {

        mockMvc.perform(get("/api/item"))
                .andDo(print());

    }

}