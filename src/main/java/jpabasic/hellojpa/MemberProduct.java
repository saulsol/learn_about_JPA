package jpabasic.hellojpa;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.*;

@Entity
@Table(name = "ORDERS")
public class MemberProduct {
    
    // 회원들이 시킨 상품들
    @Id @Column(name = "ORDER_ID")
    @GeneratedValue
    private Long id; //PK

    @ManyToOne
    @JoinColumn(name = "MEMBER_ID") // FK
    private Member member;

    @ManyToOne
    @JoinColumn(name = "PRODUCT_ID") // FK
    private Product product;



    public Member getMember() {
        return member;
    }

    public Product getProduct() {
        return product;
    }

    public void setMember(Member member) {
        this.member = member;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}
