package ies.castillodeluna.psp.ejercicio_prexamen1.models;

public class PokemonEvolutionRequest {
    
    private Long id;
    private Integer levelIncrement;
    private Long hitPointsIncrement;
    
    public PokemonEvolutionRequest() {
    }

    public PokemonEvolutionRequest(Long id, Integer levelIncrement, Long hitPointsIncrement) {
        this.id = id;
        this.levelIncrement = levelIncrement;
        this.hitPointsIncrement = hitPointsIncrement;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getLevelIncrement() {
        return levelIncrement;
    }

    public void setLevelIncrement(Integer levelIncrement) {
        this.levelIncrement = levelIncrement;
    }

    public Long getHitPointsIncrement() {
        return hitPointsIncrement;
    }

    public void setHitPointsIncrement(Long hitPointsIncrement) {
        this.hitPointsIncrement = hitPointsIncrement;
    }

    

}
