package com.example.product_management.service;

import java.util.List;

import javax.management.RuntimeErrorException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.product_management.model.Product;
import com.example.product_management.repository.ProductRepository;

import com.example.product_management.request.ProductCreateRequest;

@Service
public class ProductServiceImpl implements ProductService {
	
	@Autowired
	private ProductRepository productRepository;
	
	@Override
	public Product createProduct(ProductCreateRequest request) {
		Product newProduct = new Product();
        newProduct.setProName(request.getProName());
        newProduct.setOrder(request.getOrder());
        newProduct.setActive(request.isActive());
        return productRepository.save(newProduct);
	}
	
	@Override
	public List<Product> getAllProducts() {
		
		return productRepository.findAll();
	}
	
	@Override
	public Product getProductById(Integer id) {
		
		return productRepository.findById(id)
				.orElseThrow(()->new RuntimeException("Không tìm thấy sản phẩm với ID: "+ id));
	}
	
	@Override
	public Product updateProduct(Integer id, ProductCreateRequest request) {
		Product existProduct= getProductById(id);
		existProduct.setProName(request.getProName());
		existProduct.setOrder(request.getOrder());
		existProduct.setActive(request.isActive());
		return productRepository.save(existProduct);
	}
	@Override
	public void deleteProduct(Integer id) {
		Product existProduct=getProductById(id);
		productRepository.deleteById(id);
	}
}
