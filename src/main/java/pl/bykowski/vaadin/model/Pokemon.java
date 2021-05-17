package pl.bykowski.vaadin.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Pokemon {
    private String name;
    private PokemonType pokemonType;
    private String image;
}
