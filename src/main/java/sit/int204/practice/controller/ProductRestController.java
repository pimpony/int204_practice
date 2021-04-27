package sit.int204.practice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import sit.int204.practice.models.Product;
import sit.int204.practice.repositories.ProductRepository;

import java.util.List;

@RestController
public class ProductRestController {


    @Autowired
    private ProductRepository productRepository;

    @GetMapping("/api/show/{id}")
    public Product show(@PathVariable Long id ){
        return productRepository.findById(id).orElse(null);

    }

    @GetMapping("/api/product")
    public List<Product> product(Model model){
        return productRepository.findAll();

    }

    @RequestMapping("/api/productWithPage")
    public List<Product> productWithPage(
            @RequestParam(defaultValue = "0")Integer pageNo,
            @RequestParam(defaultValue = "5")Integer pageSize,
            @RequestParam(defaultValue = "prodPrice")String sortBy,
            Model model){
        Pageable pageable = PageRequest.of(pageNo,pageSize, Sort.by(sortBy));
        Page<Product> pageResult = productRepository.findAll(pageable);
        return pageResult.getContent();
    }

}
