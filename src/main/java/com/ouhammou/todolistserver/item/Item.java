package com.ouhammou.todolistserver.item;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "item")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Item {
    @Id
    @GeneratedValue
    private Long id;
    @Column(nullable = false)
    private String text;
    @Column(nullable = false)
    private int category;
    @Column(nullable = false)
    private boolean selected;
}
