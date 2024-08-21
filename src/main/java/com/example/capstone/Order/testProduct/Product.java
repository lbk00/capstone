package com.example.capstone.Order.testProduct;
//임시 product (기존 product -> ProductA)

import com.example.capstone.Order.Order;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Objects;


@Entity
@NoArgsConstructor
@Getter
@Setter
@Table(name = "Product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private Integer price;
    private Integer amount;

    @ManyToOne
    @JoinColumn(name = "order_id")
    private Order order;

    public Product(Long id, String name, Integer price, Integer amount) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.amount = amount;
    }

    public Boolean sameId(Long id) {
        return this.id.equals(id);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Objects.equals(id, product.id);
    }

    //재고가 충분한지 확인해주는 메서드
    public void checkEnoughAmount(Integer orderedAmount) {
        if (amount < orderedAmount)
            throw new RuntimeException(this.id + "번 상품의 수량이 부족합니다.");
    }
    // 재고 수량을 차감하는 메서드
    public void decreaseAmount(Integer orderedAmount) {
        this.amount = this.amount - orderedAmount;
    }
    // 재고 수량을 증가시키는 메서드
    public void increaseAmount(Integer orderedAmount) {
        this.amount = this.amount + orderedAmount;
    }


}
