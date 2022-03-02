package com.example.mastersplanets.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@NoArgsConstructor
@Getter
@Setter
@Table(name = "planet")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class Planet {
    @Id
    @SequenceGenerator(name="planet_sequence", sequenceName = "planet_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "planet_sequence")
    @Column(name = "id", updatable = false)
    private long id;

    @Column(name = "title")
    @NotBlank(message = "Title can't be blank")
    private String title;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "master_id")
    private Master master;

    public Planet(String title) {
        this.title = title;
    }

    public Planet(String title, Master master) {
        this(title);
        this.master = master;
    }

    @Override
    public String toString() {
        return "Planet{" +
                "id=" + id +
                ", title='" + title + '\'' +
                '}';
    }
}
