package com.application.Controller;

import com.application.Model.Product;
import com.application.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@Controller
@RequestMapping("shop")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("product")
    public ResponseEntity<Product> getProductById(@RequestParam("id") String id){
        Product product=productService.getProductById(Integer.parseInt(id));
        return new ResponseEntity<Product>(product, HttpStatus.OK);
    }
@GetMapping("all")
    public ResponseEntity<List<Product>> getAllProduct(){
        List<Product> list=productService.getAllProducts();
        return new ResponseEntity<List<Product>>(list,HttpStatus.OK);
}

@PostMapping("product")
    public ResponseEntity<Void> createProduct (@RequestBody Product product, UriComponentsBuilder builder){
    HttpHeaders httpHeaders=new HttpHeaders();
    httpHeaders.setLocation(builder.path("/product?id={id}").buildAndExpand(product.getId()).toUri());
    return new ResponseEntity<Void>(httpHeaders, HttpStatus.CREATED);
}
@PutMapping("product")
    public ResponseEntity<Product> updateProduct(@RequestBody Product product){
        productService.updateProduct(product);
        return new ResponseEntity<Product>(product,HttpStatus.OK);
}

@DeleteMapping
    public ResponseEntity<Void> deleteProduct(@RequestParam("id") String id){
        productService.deleteProduct(Integer.parseInt(id));
        return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
}
}
