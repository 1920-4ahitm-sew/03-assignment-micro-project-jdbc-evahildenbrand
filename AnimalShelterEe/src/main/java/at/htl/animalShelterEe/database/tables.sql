create table animalSpecies(
    breed varchar(50) constraint breedPK primary key,
    species varchar(50),
    genus varchar(50)
);

insert into ANIMALSPECIES (breed, species, genus) values('Wildkatze', 'Katze', 'Saeugetier');
insert into ANIMALSPECIES (breed, species, genus) values('Siamkatze', 'Katze', 'Saeugetier');
insert into ANIMALSPECIES (breed, species, genus) values('Golden Retriever', 'Hund', 'Saeugetier');
insert into ANIMALSPECIES (breed, species, genus) values('Border Collie', 'Hund', 'Saeugetier');

select*from ANIMALSPECIES;