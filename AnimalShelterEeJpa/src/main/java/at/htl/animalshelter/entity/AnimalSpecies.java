package at.htl.animalshelter.entity;

import javax.persistence.*;

@Entity
@NamedQueries(
        @NamedQuery(
                name = "AnimalSpecies.findall",
                query = "select a from AnimalSpecies a"
        )
)
public class AnimalSpecies {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String breed;
    private String species;
    private String genus;

    //region Getter and Setter
    public void setBreed(String breed) {
        this.breed = breed;
    }

    @Id
    public String getBreed() {
        return breed;
    }

    public String getSpecies() {
        return species;
    }

    public void setSpecies(String species) {
        this.species = species;
    }

    public String getGenus() {
        return genus;
    }

    public void setGenus(String genus) {
        this.genus = genus;
    }
    //endregion

    @Override
    public String toString() {
        return String.format("%d: %s %s", breed,species,genus);
    }
}
