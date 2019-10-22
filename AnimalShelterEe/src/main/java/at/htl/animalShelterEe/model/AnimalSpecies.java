package at.htl.animalShelterEe.model;

public class AnimalSpecies {
    private String breed;
    private String species;
    private String genus;

    public AnimalSpecies(String breed, String species, String genus) {
        this.breed = breed;
        this.species = species;
        this.genus = genus;
    }

    public AnimalSpecies() {
    }

    //region Getter and Setter
    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
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
        return String.format("%d: %s %s",breed,species,genus);
    }
}
