package com.virtualrestart.giflib.controller;

import com.virtualrestart.giflib.data.CategoryRepository;
import com.virtualrestart.giflib.data.GifRepository;
import com.virtualrestart.giflib.model.Category;
import com.virtualrestart.giflib.model.Gif;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;


@Controller
public class CategoryController {
    @Autowired
    protected CategoryRepository categoryRepository;
    @Autowired
    protected GifRepository gifRepository;

    @RequestMapping("/categories")
    public String index(ModelMap modelMap){
        List <Category> categories = categoryRepository.getAllCategories();
        modelMap.put("categories", categories);
        return "categories";
    }
    @RequestMapping("/category/{id}")
    public String category(@PathVariable int id, ModelMap modelMap){
        Category category = categoryRepository.findById(id);
        modelMap.put("category", category);

        List<Gif> gifs = gifRepository.findByCategoryId(id);
        modelMap.put("gifs", gifs);
        return "category";
    }
}
