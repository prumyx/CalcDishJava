package com.karalexsandr.coreservice.entity;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Table(name = "meals")
public class Meal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "title")
    private String title;

    @Column(name = "weight")
    private Float weight;

    @Column(name = "calories")
    private Float calories;

    @Column(name = "fats")
    private Float fats;

    @Column(name = "proteins")
    private Float proteins;

    @Column(name = "carbohydrates")
    private Float carbohydrates;

    @ManyToMany(mappedBy = "meals")
    @ToString.Exclude
    private List<Dish> dishes;

    @CreationTimestamp
    private LocalDateTime createAt;

    @UpdateTimestamp
    private LocalDateTime updateAt;

}
