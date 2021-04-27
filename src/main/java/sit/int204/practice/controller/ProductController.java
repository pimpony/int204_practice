package sit.int204.practice.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import sit.int204.practice.models.Product;
import sit.int204.practice.repositories.ProductRepository;

import java.util.List;

@Controller
public class ProductController {

    @Autowired
    private ProductRepository productRepository;

    @RequestMapping("/product")
    public String product(Model model){
        model.addAttribute("products",productRepository.findAll());
        return "product";
    }
    @RequestMapping("/show/{id}")
    public String show(@PathVariable  Long id , Model model){
        model.addAttribute("product",productRepository.findById(id).orElse(null));
        return "show";
    }

    @RequestMapping("/create")
    public String create(Model model){
        return "create";
    }

    @RequestMapping("/save")
    public String save(Product product, Model model){
        productRepository.save(product);
        model.addAttribute("product",product);
        return "redirect:/show/"+product.getId();
    }


    @RequestMapping("/delete")
    public String delete(@RequestParam  Long id , Model model){
        productRepository.deleteById(id);
        return "redirect:/product";
    }

    @RequestMapping("/price")
    public String findByPrice(@RequestParam  (defaultValue = "0")Double lower,@RequestParam (defaultValue = "10000")Double upper , Model model){
       List<Product> products = productRepository.findAllByProdPriceBetween(lower, upper);
       model.addAttribute("products",products);
       return "product";
    }
    @RequestMapping("/productWithPage")
    public String productWithPage(
            @RequestParam(defaultValue = "0")Integer pageNo,
            @RequestParam(defaultValue = "5")Integer pageSize,
            @RequestParam(defaultValue = "prodPrice")String sortBy,
            Model model){
        Pageable pageable = PageRequest.of(pageNo,pageSize, Sort.by(sortBy));
        Page<Product> pageResult = productRepository.findAll(pageable);
        model.addAttribute("products",pageResult.getContent());
        return "product";
    }
}
