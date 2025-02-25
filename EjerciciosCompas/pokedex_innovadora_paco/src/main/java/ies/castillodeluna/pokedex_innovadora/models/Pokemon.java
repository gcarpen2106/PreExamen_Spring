package ies.castillodeluna.pokedex_innovadora.models;

import jakarta.persistence.*;
import java.util.List;

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
    
    @Column(name = "hit_points", nullable = false)
    private Long hitPoints;
    
    @Column(nullable = false)
    private Integer level;

    @ElementCollection
    private List<String> abilities;

    @Column(nullable = false)
    private Double weight;

    @Column(nullable = false)
    private String region;

    @Column(name = "evolution_number", nullable = false)
    private Integer evolutionNumber;

    @ElementCollection
    private List<String> specialAttacks;

    @Column(nullable = false)
    private Integer defense;

    @Column(nullable = false)
    private String trainer;

    @Column(nullable = false)
    private Integer ps;

    @Column(nullable = false)
    private Integer pp;

    public Pokemon() {}

    public Pokemon(Long id, String name, String type, Long hitPoints, Integer level, List<String> abilities, Double weight, String region, Integer evolutionNumber, List<String> specialAttacks, Integer defense, String trainer, Integer ps, Integer pp) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.hitPoints = hitPoints;
        this.level = level;
        this.abilities = abilities;
        this.weight = weight;
        this.region = region;
        this.evolutionNumber = evolutionNumber;
        this.specialAttacks = specialAttacks;
        this.defense = defense;
        this.trainer = trainer;
        this.ps = ps;
        this.pp = pp;
    }

    // Getters y Setters

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

    public List<String> getAbilities() {
        return abilities;
    }
    public void setAbilities(List<String> abilities) {
        this.abilities = abilities;
    }

    public Double getWeight() {
        return weight;
    }
    public void setWeight(Double weight) {
        this.weight = weight;
    }

    public String getRegion() {
        return region;
    }
    public void setRegion(String region) {
        this.region = region;
    }

    public Integer getEvolutionNumber() {
        return evolutionNumber;
    }
    public void setEvolutionNumber(Integer evolutionNumber) {
        this.evolutionNumber = evolutionNumber;
    }

    public List<String> getSpecialAttacks() {
        return specialAttacks;
    }
    public void setSpecialAttacks(List<String> specialAttacks) {
        this.specialAttacks = specialAttacks;
    }

    public Integer getDefense() {
        return defense;
    }
    public void setDefense(Integer defense) {
        this.defense = defense;
    }

    public String getTrainer() {
        return trainer;
    }
    public void setTrainer(String trainer) {
        this.trainer = trainer;
    }

    public Integer getPs() {
        return ps;
    }
    public void setPs(Integer ps) {
        this.ps = ps;
    }

    public Integer getPp() {
        return pp;
    }
    public void setPp(Integer pp) {
        this.pp = pp;
    }
  
    @Override
    public String toString() {
        return "Pokemon{" +
               "id=" + id +
               ", name='" + name + '\'' +
               ", type='" + type + '\'' +
               ", hitPoints=" + hitPoints +
               ", level=" + level +
               ", abilities=" + abilities +
               ", weight=" + weight +
               ", region='" + region + '\'' +
               ", evolutionNumber=" + evolutionNumber +
               ", specialAttacks=" + specialAttacks +
               ", defense=" + defense +
               ", trainer='" + trainer + '\'' +
               ", ps=" + ps +
               ", pp=" + pp +
               '}';
    }
}