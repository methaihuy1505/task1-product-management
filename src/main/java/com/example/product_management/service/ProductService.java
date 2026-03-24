package com.example.product_management.service;

import java.util.List;

import com.example.product_management.model.Product;

import com.example.product_management.request.ProductCreateRequest;

public interface ProductService {
	//Thêm mới
    Product createProduct(ProductCreateRequest request);

    //Lấy toàn bộ danh sách
    List<Product> getAllProducts();

    //Lấy 1 sản phẩm theo ID
    Product getProductById(Integer id);

    //Cập nhật thông tin
    Product updateProduct(Integer id, ProductCreateRequest request);

    //Xóa sản phẩm theo ID
    void deleteProduct(Integer id);
}
