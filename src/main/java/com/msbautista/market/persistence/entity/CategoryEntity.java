package com.msbautista.market.persistence.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "categories")
public class CategoryEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "category_id")
    private Integer categoryId;

    @Column(name = "description")
    private String description;

    @Column(name = "state")
    private Boolean state;

    @OneToMany(mappedBy = "category")
    private List<ProductEntity> products;

}