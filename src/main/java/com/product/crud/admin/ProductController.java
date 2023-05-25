package com.product.crud.admin;

import com.product.crud.admin.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping("/products")
    public String showAllProduct(Model model) {
        List<Product> listProducts = productService.getAllProducts();
        model.addAttribute("listProducts", listProducts);

        return "/admin/list";
    }

//    @GetMapping("/client/index")
//    public String getAllProduct(Model model) {
//        List<Product> listProducts = productService.getAllProducts();
//        model.addAttribute("listProduct", listProducts);
//
//        return "/client/index";
//    }

    @GetMapping("/products/add")
    public String showNewForm(Model model) {
        model.addAttribute("product", new Product());
        model.addAttribute("pageTitle", "Add new product");

        return "/admin/create_product_form";
    }

    @PostMapping("/products/save")
    public String saveProduct(Product product, RedirectAttributes redirectAttributes) {
        productService.save(product);
        redirectAttributes.addFlashAttribute("message", "Create new product success!");

        return "redirect:/products";
    }

    @GetMapping("/products/edit/{id}")
    public String editInformationProduct(@PathVariable("id") Integer id, Model model, RedirectAttributes redirectAttributes) throws ProductNotFoundException {
        try {
            Product product = productService.getProductWith(id);
            model.addAttribute("product", product);
            model.addAttribute("pageTitle", "Edit information product");
            redirectAttributes.addFlashAttribute("message", "Update success");

            return "/admin/create_product_form";
        } catch (ProductNotFoundException e) {
            redirectAttributes.addFlashAttribute("message", e.getMessage());
            return "redirect:/products";
        }
    }

    @GetMapping("/products/delete/{id}")
    public String deleteProduct(@PathVariable("id") Integer id, RedirectAttributes redirectAttributes) throws ProductNotFoundException {
        productService.deleteProductWith(id);
        redirectAttributes.addFlashAttribute("message", "Delete success!");

        return "redirect:/products";
    }
}
