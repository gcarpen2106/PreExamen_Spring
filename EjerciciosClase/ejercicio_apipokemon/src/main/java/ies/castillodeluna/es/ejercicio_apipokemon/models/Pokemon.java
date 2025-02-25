package ies.castillodeluna.es.ejercicio_apipokemon.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "pokemons")
public class Pokemon {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String type;

    @Column(name = "hit_points" ,nullable = false)
    private Long hitPoints;
    
    public Pokemon() {
    }

    public Pokemon(Long id, String name, String type, Long hitPoints) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.hitPoints = hitPoints;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Long getHitPoints() {
        return hitPoints;
    }

    public void setHitPoints(Long hitPoints) {
        this.hitPoints = hitPoints;
    }

    

}
