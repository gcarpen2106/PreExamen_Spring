package ies.castillodeluna.psp.ejercicio_prexamen2.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "pokemons")
public class Pokemons {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String type;

    @Column(name = "hit_points" , nullable = false)
    private Long hitPoints;

    @Column(nullable = false)
    private Integer level;

    @Column(nullable = true)
    private String evolution;

    @Column(name = "capture_rate" , nullable = false)
    private Integer captureRate;

    @Column(nullable = false)
    private Boolean legendary;

    public Pokemons() {
    }

    public Pokemons(Long id, String name, String type, Long hitPoints, Integer level, String evolution,
            Integer captureRate, Boolean legendary) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.hitPoints = hitPoints;
        this.level = level;
        this.evolution = evolution;
        this.captureRate = captureRate;
        this.legendary = legendary;
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

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public String getEvolution() {
        return evolution;
    }

    public void setEvolution(String evolution) {
        this.evolution = evolution;
    }

    public Integer getCaptureRate() {
        return captureRate;
    }

    public void setCaptureRate(Integer captureRate) {
        this.captureRate = captureRate;
    }

    public Boolean getLegendary() {
        return legendary;
    }

    public void setLegendary(Boolean legendary) {
        this.legendary = legendary;
    }

    @Override
    public String toString() {
        return "Pokemon [id=" + id + ", name=" + name + ", type=" + type + ", hitPoints=" + hitPoints + ", level="
                + level + ", evolution=" + evolution + ", captureRate=" + captureRate + ", legendary=" + legendary
                + "]";
    }

}
