package ru.nixson.itemws.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Getter
@Setter
@ToString
@Entity

@Table(name = "items", indexes = @Index(name="NAME_INDEX", unique = true, columnList = "name"))
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

/*    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id",insertable = false,updatable = false)
    private Provider provider;*/
}