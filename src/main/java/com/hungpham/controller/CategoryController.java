package com.hungpham.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("admin")
public class CategoryController {
    @GetMapping("/get-all-category")
    public List<String> getAllCategory() {
        List<String> a = new ArrayList<>();
        a.add("success");
        return a;
    }
}
