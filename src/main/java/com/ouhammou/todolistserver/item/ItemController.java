package com.ouhammou.todolistserver.item;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping(path = "/api/v1/item")
public class ItemController {
    @Autowired
    private final ItemService itemService;
    @GetMapping
    public List<Item> getAllItems(){
        return itemService.getItems();
    }
    @PostMapping
    public Item addItem(@RequestBody Item item){
        return itemService.addItem(item);
    }
    @PutMapping(path = "/{itemId}")
    public Item updateItem(@PathVariable Long itemId,
                         @RequestBody Item item){
        return itemService.updateItem(itemId, item);
    }
    @DeleteMapping(path = "{itemId}")
    public ResponseEntity<?> deleteItem(@PathVariable Long itemId){
        itemService.deleteItem(itemId);
        return ResponseEntity.ok()
                .body("delete operation succeeded .");
    }
}
