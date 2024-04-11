package org.example.pr14vmmybatis.controller;

import lombok.RequiredArgsConstructor;
import org.example.pr14vmmybatis.dao.IProductDao;
import org.example.pr14vmmybatis.dto.ProductDto;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
@RequiredArgsConstructor
public class HtmlController {
    final IProductDao productDao;
    @GetMapping("/")
    public String main(Model model) {
        model.addAttribute("productList", productDao.list());
        return "pList";
    }

    @GetMapping("/add")
    public String addProductForm(Model model) {
        return "add";
    }

    @GetMapping("/edit")
    public String edit(@RequestParam("productId") int productId, Model model) {
        Optional<ProductDto> product = productDao.findById(productId);
        if (product.isEmpty()) {
            return "error";
        }

        model.addAttribute("product", product.get());
        return "edit";
    }

    @GetMapping("/update") //상품 수정
    public String update(@RequestParam int id, @RequestParam String name, @RequestParam int price) {
        Optional<ProductDto> product = productDao.findById(id);
        if (product.isEmpty()) {
            return "error";
        }
        productDao.update(id, name, price);
        return "redirect:/";
    }

    @GetMapping("/save") //상품 추가
    public String save(@RequestParam String name, @RequestParam int price) {
        ProductDto product = ProductDto.builder().productId((long) (productDao.count()+1)).productName(name).productPrice(price).build();
        productDao.insert(product);
        return "redirect:/";
    }
}