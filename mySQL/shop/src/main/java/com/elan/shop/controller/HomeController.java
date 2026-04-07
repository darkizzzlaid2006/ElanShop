package com.elan.shop.controller;

import com.elan.shop.model.Product;
import com.elan.shop.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

// QUAN TRỌNG: Đổi từ @RestController thành @Controller
@Controller
public class HomeController {

    @Autowired
    private ProductRepository productRepository;

    @GetMapping("/")
    public String hienThiTrangChu(Model model) {
        // 1. Vào kho lấy toàn bộ sản phẩm
        List<Product> danhSachSanPham = productRepository.findAll();

        // 2. Đóng gói danh sách đó vào một cái thùng tên là "products" để gửi sang file HTML
        model.addAttribute("products", danhSachSanPham);

        // 3. Trả về tên của file HTML (không cần đuôi .html) mà bạn vừa tạo ở thư mục templates
        return "index";
    }
}