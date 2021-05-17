package pl.bykowski.vaadin.gui;

import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.data.renderer.ComponentRenderer;
import com.vaadin.flow.router.Route;
import org.springframework.beans.factory.annotation.Autowired;
import pl.bykowski.vaadin.model.PokeDeck;
import pl.bykowski.vaadin.model.Pokemon;
import pl.bykowski.vaadin.model.PokemonType;

import java.util.List;
import java.util.stream.Collectors;

@Route
public class PokemonDeckGui extends VerticalLayout {

    @Autowired
    public PokemonDeckGui(PokeDeck pokeDeck) {

        ComboBox<PokemonType> pokemonTypeComboBox = new ComboBox<PokemonType>("Pokemon Type: ", PokemonType.values());

        add(pokemonTypeComboBox);

        Grid<Pokemon> gridPokemon = new Grid<>(Pokemon.class);
        List<Pokemon> pokemons = pokeDeck.getPokemons();
        gridPokemon.setItems(pokemons);
        add(gridPokemon);

        pokemonTypeComboBox.addValueChangeListener(click -> {

            List<Pokemon> collect;
            if (pokemonTypeComboBox.isEmpty()) {
                collect = pokemons;
            } else {
                collect = pokemons.stream()
                        .filter(pokemon -> pokemon.getPokemonType() == pokemonTypeComboBox.getValue())
                        .collect(Collectors.toList());
            }
            gridPokemon.setItems(collect);
        });

        gridPokemon.addColumn(new ComponentRenderer<>(pokemon ->
                new Image(pokemon.getImage(), pokemon.getImage()))).setHeader("Image");
        gridPokemon.removeColumnByKey("image");

    }
}
