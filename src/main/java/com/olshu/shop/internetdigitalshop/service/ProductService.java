package com.olshu.shop.internetdigitalshop.service;

import com.olshu.shop.internetdigitalshop.DTO.ProductDTO;
import com.olshu.shop.internetdigitalshop.models.*;
import com.olshu.shop.internetdigitalshop.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Product addProduct(ProductDTO productDTO) {
        String productType = productDTO.getProductType();

        if ("desktop".equals(productType)) {
            Desktop desktop = new Desktop();
            desktop.setQuantity(productDTO.getQuantity());
            desktop.setProductType(productDTO.getProductType());
            desktop.setPrice(productDTO.getPrice());
            desktop.setSerialNumber(productDTO.getSerialNumber());
            desktop.setManufacturer(productDTO.getManufacturer());
            desktop.setFormFactor(productDTO.getFormFactor());
            return productRepository.save(desktop);
        } else if ("laptop".equals(productType)) {
            Laptop laptop = new Laptop();
            laptop.setQuantity(productDTO.getQuantity());
            laptop.setProductType(productDTO.getProductType());
            laptop.setPrice(productDTO.getPrice());
            laptop.setSerialNumber(productDTO.getSerialNumber());
            laptop.setManufacturer(productDTO.getManufacturer());
            laptop.setScreenSize(productDTO.getScreenSize());
            return productRepository.save(laptop);
        } else if ("monitor".equals(productType)) {
            Monitor monitor = new Monitor();
            monitor.setQuantity(productDTO.getQuantity());
            monitor.setProductType(productDTO.getProductType());
            monitor.setPrice(productDTO.getPrice());
            monitor.setSerialNumber(productDTO.getSerialNumber());
            monitor.setManufacturer(productDTO.getManufacturer());
            monitor.setDiagonal(productDTO.getDiagonal());
            return productRepository.save(monitor);
        } else if ("hard_drive".equals(productType)) {
            HardDrive hardDrive = new HardDrive();
            hardDrive.setQuantity(productDTO.getQuantity());
            hardDrive.setProductType(productDTO.getProductType());
            hardDrive.setPrice(productDTO.getPrice());
            hardDrive.setSerialNumber(productDTO.getSerialNumber());
            hardDrive.setManufacturer(productDTO.getManufacturer());
            hardDrive.setCapacity(productDTO.getCapacity());
            return productRepository.save(hardDrive);
        }
        throw new IllegalArgumentException("Некорректный тип продукта: " + productType);
    }


    public Product updateProduct(Long productId, ProductDTO productDTO) {
        Optional<Product> optionalProduct = productRepository.findById(productId);
        if (optionalProduct.isPresent()) {
            Product existingProduct = optionalProduct.get();

            // Обновляем свойства, которые могут быть изменены
            existingProduct.setQuantity(productDTO.getQuantity());
            existingProduct.setPrice(productDTO.getPrice());
            existingProduct.setSerialNumber(productDTO.getSerialNumber());
            existingProduct.setManufacturer(productDTO.getManufacturer());

            // В зависимости от типа продукта, обновляем специфичные свойства
            String productType = productDTO.getProductType();
            if ("desktop".equals(productType) && existingProduct instanceof Desktop) {
                Desktop desktop = (Desktop) existingProduct;
                desktop.setFormFactor(productDTO.getFormFactor());
            } else if ("laptop".equals(productType) && existingProduct instanceof Laptop) {
                Laptop laptop = (Laptop) existingProduct;
                laptop.setScreenSize(productDTO.getScreenSize());
            } else if ("monitor".equals(productType) && existingProduct instanceof Monitor) {
                Monitor monitor = (Monitor) existingProduct;
                monitor.setDiagonal(productDTO.getDiagonal());
            } else if ("hardDrive".equals(productType) && existingProduct instanceof HardDrive) {
                HardDrive hardDrive = (HardDrive) existingProduct;
                hardDrive.setCapacity(productDTO.getCapacity());
            } else {
                throw new IllegalArgumentException("Некорректный тип продукта: " + productType);
            }

            return productRepository.save(existingProduct);
        } else {
            throw new NoSuchElementException("Продукт с идентификатором " + productId + " не найден");
        }
    }


    public List<Product> getAllProductsByType(String productType) {
        return productRepository.findByProductType(productType);
    }

    public Product getProductById(Long id) {
        return productRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid product id: " + id));
    }
}
