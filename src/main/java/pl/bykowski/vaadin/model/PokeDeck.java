package pl.bykowski.vaadin.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Repository;
import pl.bykowski.vaadin.model.Pokemon;

import java.util.ArrayList;
import java.util.List;

@Repository
@Getter
@Setter
public class PokeDeck {
    private List<Pokemon> pokemons;

    public PokeDeck() {
        this.pokemons = new ArrayList<>();
    }

}
