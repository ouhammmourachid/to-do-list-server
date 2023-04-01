package com.ouhammou.todolistserver.item;

import com.ouhammou.todolistserver.exception.RequestValidationException;
import com.ouhammou.todolistserver.exception.ResourceNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ItemService {
    @Autowired
    private final ItemRepository itemRepository;

    public List<Item> getItems(){
        return itemRepository.findAll();
    }
    public Item addItem(Item item){
        return itemRepository.save(item);
    }
    public Item updateItem(Long itemId,Item item){
        Item savedItem = itemRepository.findById(itemId)
                .orElseThrow(()-> new ResourceNotFoundException("Job with id [%s] not found .".formatted(itemId)));
        boolean changed = false;
        if(item.getText()!= null && !item.getText().equals(savedItem.getText())){
            savedItem.setText(item.getText());
            changed = true;
        }
        if(item.getCategory()!=savedItem.getCategory()){
            savedItem.setCategory(item.getCategory());
            changed = true;
        }
        boolean debug = item.isSelected()!=savedItem.isSelected();
        if(debug){
            savedItem.setSelected(item.isSelected());
            changed = true;
        }
        if(!changed){
            throw new RequestValidationException("no data changes found");
        }
        return itemRepository.save(savedItem);
    }
    public void deleteItem(Long itemId){
        Item savedItem = itemRepository.findById(itemId)
                .orElseThrow(()-> new ResourceNotFoundException("Job with id [%s] not found .".formatted(itemId)));
        itemRepository.delete(savedItem);
    }
}
