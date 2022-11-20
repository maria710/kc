package com.example.kc.controller;

import com.example.kc.dto.ProductDTO;
import com.example.kc.entity.Product;
import com.example.kc.mapper.ProductMapper;
import com.example.kc.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/")
@RequiredArgsConstructor
public class ProductController {

    private final ProductMapper productMapper;
    private final ProductService productService;

    //    @GetMapping(value = "/", produces = {MediaType.APPLICATION_JSON_VALUE})
//    public ProductDTO getProduct(@PathVariable("id") Long id) {
//        return productMapper.toProductDTO(productService.getProduct(id));
//    }
//    @GetMapping(value = "product")
//    public String getProduct(@ModelAttribute("id") Long id, Model model) {
//        var productDTO =  productMapper.toProductDTO(productService.getProduct(id));
//        model.addAttribute("product", productDTO);
//        return "product";
//    }

    @GetMapping(value = "/products")
    public String getProduct(Model model) {
        List<Product> productList =  productService.getProducts();
        model.addAttribute("products", productList);
        return "productList";
    }

    @GetMapping(value = "/addProduct")
    public String showForm(Model model) {
        model.addAttribute("formData", new ProductDTO());
        return "productForm";
    }

    @PostMapping(value = "/productForm")
    public String addProduct(@ModelAttribute("formData") ProductDTO productDTO, Model model) {
        productMapper.toProductDTO(productService.addProduct(productDTO));
        model.addAttribute("name", productDTO.getName());
        model.addAttribute("description", productDTO.getDescription());
        model.addAttribute("price", productDTO.getPrice());
        return "redirect:/";
    }

    @GetMapping(value = "/updateProduct")
    public String updateProduct(@ModelAttribute("id") Long id, Model model) {
        var productDTO = productMapper.toProductDTO(productService.findById(id));
        productDTO.setId(id);
        model.addAttribute("product", productDTO);
        //model.addAttribute("id", id);
        return "editForm";
    }

    @PostMapping(value = "/editForm")
    public String updateProduct(@ModelAttribute("product") ProductDTO productDTO, Model model) {
        productMapper.toProductDTO(productService.updateProduct(productDTO.getId(), productDTO));
        model.addAttribute("name", productDTO.getName());
        model.addAttribute("description", productDTO.getDescription());
        model.addAttribute("price", productDTO.getPrice());
        return "redirect:/";
    }

    @GetMapping(value = "/deleteProduct")
    public String deleteProduct(@ModelAttribute("id")  Long id) {
        productMapper.toProductDTO(productService.deleteProduct(id));
        return "redirect:/products";
    }


//    @PostMapping(value = "/", produces = {MediaType.APPLICATION_JSON_VALUE})
//    public ProductDTO postProduct(@RequestBody ProductDTO productDTO) {
//        return productMapper.toProductDTO(productService.addProduct(productDTO));
//    }



//    @PutMapping(value = "/product/{id}", produces = {MediaType.APPLICATION_JSON_VALUE})
//    public ProductDTO putProduct(@PathVariable("id") Long id, @RequestBody ProductDTO productDTO) {
//        return productMapper.toProductDTO(productService.updateProduct(id, productDTO));
//    }
//
//    @DeleteMapping(value = "/product/{id}", produces = {MediaType.APPLICATION_JSON_VALUE})
//    public ProductDTO deleteProduct(@PathVariable("id") Long id) {
//        return productMapper.toProductDTO(productService.deleteProduct(id));
//    }
}
