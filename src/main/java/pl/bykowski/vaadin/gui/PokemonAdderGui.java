package pl.bykowski.vaadin.gui;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;
import org.springframework.beans.factory.annotation.Autowired;
import pl.bykowski.vaadin.model.PokeDeck;
import pl.bykowski.vaadin.model.Pokemon;
import pl.bykowski.vaadin.model.PokemonType;

@Route
public class PokemonAdderGui extends VerticalLayout {

    @Autowired
    public PokemonAdderGui(PokeDeck pokeDeck) {
        TextField textFieldName = new TextField("name");
        TextField textFieldImage = new TextField("image");
        ComboBox<PokemonType> pokemonTypeComboBox = new ComboBox<PokemonType>("Pokemon Type: ", PokemonType.values());

        Button buttonAdd = new Button("Add new Pokemon!");

        buttonAdd.addClickListener(clickEvent -> {
            Pokemon pokemon = new Pokemon();
            pokemon.setName(textFieldName.getValue());
            pokemon.setImage(textFieldImage.getValue());
            pokemon.setPokemonType(pokemonTypeComboBox.getValue());
            pokeDeck.getPokemons().add(pokemon);
            Notification notification = new Notification("Pokemon added!", 3000);
            notification.open();
            textFieldName.clear();
            textFieldImage.clear();
            pokemonTypeComboBox.clear();
        });

        add(textFieldName, textFieldImage, pokemonTypeComboBox, buttonAdd);
    }
}
