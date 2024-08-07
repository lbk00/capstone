package com.example.capstone.Order;

public class ProductDTO {
    private Long id;
    private String name;
    private Integer price;
    private Integer amount;

    public ProductDTO(Long id, String name, Integer price, Integer amount) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.amount = amount;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Integer getPrice() {
        return price;
    }

    public Integer getAmount() {
        return amount;
    }

    public static ProductDTO toDto(Product product) {
        ProductDTO productDto = new ProductDTO(
                product.getId(),
                product.getName(),
                product.getPrice(),
                product.getAmount()
        );

        return productDto;
    }
}
