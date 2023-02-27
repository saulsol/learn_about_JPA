package jpabasic.hellojpa;

import jdk.jfr.Enabled;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Product {

    @Id @GeneratedValue
    @Column(name = "PRODUCT_ID")
    private Long id;

    private String name;

    @OneToMany(mappedBy = "product")
    List<MemberProduct> memberProducts = new ArrayList<>();

    public Product() {
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<MemberProduct> getMemberProducts() {
        return memberProducts;
    }
}
