package ies.castillodeluna.psp.ejercicio_prexamen2.models;

public class PokemonsDTO {
    
    private Long id;
    private Integer level;
    private Long hitPoints;
    private String evolution;
    
    public PokemonsDTO() {
    }

    public PokemonsDTO(Long id, Integer level, Long hitPoints, String evolution) {
        this.id = id;
        this.level = level;
        this.hitPoints = hitPoints;
        this.evolution = evolution;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public Long getHitPoints() {
        return hitPoints;
    }

    public void setHitPoints(Long hitPoints) {
        this.hitPoints = hitPoints;
    }

    public String getEvolution() {
        return evolution;
    }

    public void setEvolution(String evolution) {
        this.evolution = evolution;
    }

    

}
