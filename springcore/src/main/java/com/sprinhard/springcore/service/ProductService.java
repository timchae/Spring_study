package com.sprinhard.springcore.service;

import com.sprinhard.springcore.model.Product;
import com.sprinhard.springcore.dto.ProductMypriceRequestDto;
import com.sprinhard.springcore.dto.ProductRequestDto;
import com.sprinhard.springcore.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;


@Service
public class ProductService {
    // 멤버 변수 선언
    private final ProductRepository productRepository;

    // 생성자: ProductService() 가 생성될 때 호출됨
    @Autowired
    public ProductService(ProductRepository productRepository) {
        // 멤버 변수 생성
        this.productRepository = productRepository;
    }

    public List<Product> getProducts(){
        // 멤버 변수 사용
        return productRepository.findAll();
    }

    public Product createProduct(ProductRequestDto requestDto){
        // 요청받은 DTO 로 DB에 저장할 객체 만들기
        Product product = new Product(requestDto);
        productRepository.save(product);
        return product;
    }

    @Transactional
    public Product updateProduct(Long id, ProductMypriceRequestDto requestDto){
        Product product = productRepository.findById(id)
                .orElseThrow(()-> new NullPointerException("No Id"));

        int myPrice = requestDto.getMyprice();
        product.updateMyPrice(myPrice);
        //productRepository.save(product);
        return product;
    }
}