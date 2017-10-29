package net.hackyeah.giveahand.controller;

import net.hackyeah.giveahand.data.EventCategoryRepo;
import net.hackyeah.giveahand.entity.EventCategory;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/categories")
public class CategoriesController {

    @Resource
    private EventCategoryRepo eventCategoryRepo;

    @GetMapping
    public List<EventCategory> getAllCategories(){
        return (List<EventCategory>)eventCategoryRepo.findAll();
    }

    @GetMapping("/{categoryId}")
    public EventCategory getCategoryById(@PathVariable("categoryId") Long categoryId){
        return eventCategoryRepo.findOne(categoryId);
    }

    @PostMapping
    public void saveCategory(EventCategory eventCategory){
        eventCategoryRepo.save(eventCategory);
    }

}
