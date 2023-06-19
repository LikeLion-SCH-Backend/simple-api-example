package com.likelionsch.simpleapiexample.item;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class ItemService {

    private final ItemRepository itemRepository;

    public List<Item> findAllItems() {
        return itemRepository.findAll();
    }

    public Item findItem(long id) {
        return itemRepository.findById(id)
                .orElseThrow(() -> new NullPointerException("존재하지 않는 Id 입니다."));
    }

    @Transactional
    public Long createItem(ItemDto itemDto) {
        Item item = ItemDto.itemMapper(itemDto);
        Item newItem = itemRepository.save(item);
        return newItem.getId();
    }

    @Transactional
    public Long updateItem(Long id, ItemDto itemDto) {
        Item item = this.findItem(id);
        item.update(itemDto);
        return item.getId();
    }

    public void deleteItem(long id) {
        itemRepository.deleteById(id);
    }

}
