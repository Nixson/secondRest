package ru.nixson.itemws.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import ru.nixson.itemws.domain.Item;
import ru.nixson.itemws.repository.ItemRepository;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/items")
public class ItemController {
    @Autowired
    public ItemRepository itemRepository;

    @GetMapping(value = "")
    public Iterable<Item> getAll(){
        return itemRepository.findAll();
    }

    @GetMapping(value = "/id/{id}")
    public Item getItemById(@PathVariable Long id){
        return itemRepository.findById(id).orElseThrow(RuntimeException::new);
    }

    @GetMapping(value = "/name/{name}")
    public Iterable<Item> getItemByName(@PathVariable String name){
        return itemRepository.findByName(name);
    }

    @PostMapping(value = "/", consumes = MediaType.APPLICATION_JSON_VALUE)
    public Item setItem(@RequestBody Item item){
        return itemRepository.save(item);
    }

    @PostMapping(value = "{id}")
    public Optional<Item> updateItem(@PathVariable Long id, @RequestBody  Item item){
        item.setId(id);
        itemRepository.save(item);
        return itemRepository.findById(id);
    }
    @GetMapping(value = "/delete/{id}")
    public Iterable<Item> rmItem(@PathVariable Long id){
        itemRepository.deleteById(id);
        return itemRepository.findAll();
    }

}
