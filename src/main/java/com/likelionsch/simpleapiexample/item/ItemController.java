package com.likelionsch.simpleapiexample.item;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/item")
public class ItemController {

    private final ItemService itemService;

    @GetMapping
    public ResponseEntity allItems() {
        List<Item> items = itemService.findAllItems();
        return ResponseEntity.ok().body(items);
    }

    @GetMapping("/{id}")
    public ResponseEntity findItem(@PathVariable Long id) {
        Item item = itemService.findItem(id);
        return ResponseEntity.ok().body(item);
    }

    @PostMapping
    public ResponseEntity createItem(@RequestBody ItemDto itemDto) {
        Long newItemId = itemService.createItem(itemDto);
        URI createdUri = linkTo(methodOn(ItemController.class).createItem(itemDto)).slash(newItemId).toUri();
        return ResponseEntity.created(createdUri).body(newItemId);
    }

    @PatchMapping("/{id}")
    public ResponseEntity updateItem(@PathVariable Long id, @RequestBody ItemDto itemDto) {
        Long itemId = itemService.updateItem(id, itemDto);
        return ResponseEntity.ok().body(itemId);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteItem(@PathVariable Long id) {
        itemService.deleteItem(id);
        return ResponseEntity.ok().body("delete success");
    }

}
