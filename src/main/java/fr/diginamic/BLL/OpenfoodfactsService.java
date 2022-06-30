package fr.diginamic.BLL;

import fr.diginamic.BO.Produit;
import fr.diginamic.BO.descriptif.*;
import fr.diginamic.DAL.Connexion;

import javax.persistence.EntityManager;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

public class OpenfoodfactsService {
    public OpenfoodfactsService() {
    }

    public Produit createProduit(String lines){
        Produit produit  = new Produit();
        List<String> o= List.of(lines.split("\\|"));
        if (o.size() != 30) {
            return null;
        };
        Categorie categorie = new Categorie(o.get(0));
        Marque marque = new Marque(o.get(1));
        List<String> ingrerdiants = List.of(o.get(4).split(","));
        Set<Ingredient> ingredientList = new HashSet<>();
        for (String ingrerdiant : ingrerdiants) {
            ingredientList.add(new Ingredient(ingrerdiant));
        }
        produit.setCategorie(categorie);
        produit.setMarque(marque);
        produit.setNom(o.get(2));
        produit.setScoreNutritionnel(o.get(3));
        produit.setIngredients(ingredientList);
        produit.setEnergie100g(o.get(5));
        produit.setGraisse100g(o.get(6));
        produit.setSucres100g(o.get(7));
        produit.setFibres100g(o.get(8));
        produit.setProteines100g(o.get(9));
        produit.setSel100g(o.get(10));

        Set<Vitamine> vitamineList = new HashSet<>();
        for (int j = 11; j < 22; j++) {
            if (!Objects.equals(o.get(j), "")){
                vitamineList.add(new Vitamine(o.get(j)));
            }
        }
        produit.setVitamines(vitamineList);
        produit.setCalcium100g(o.get(22));
        produit.setMagnesium100g(o.get(23));
        produit.setIron100g(o.get(24));
        produit.setFer100g(o.get(25));
        produit.setBetaCarotene100g(o.get(26));
        produit.setPresenceHuilePalme(o.get(27));

        Set<Allergene> allergeneList = new HashSet<>();
        String[] alergenes = o.get(28).split(",");
        for (String alergene : alergenes) {
            allergeneList.add(new Allergene(alergene));
        }
        produit.setAllergenes(allergeneList);

        Set<Additifs> additifsdditifs = new HashSet<>();
        String[] additifs = o.get(29).split("-");
        for (String additif : additifs) {
            additifsdditifs.add(new Additifs(additif));
        }
        Set<Additifs> additifsSet = (Set) getDescriptiList(o.get(28),"-",new Additifs());
        for (DescriptifProduit descriptifProduit : additifsSet) {
            System.out.println(descriptifProduit instanceof Allergene);
        }

        produit.setAdditifses(additifsSet);

        return produit;
    }
    private Set<DescriptifProduit> getDescriptiList(String o,String regex,DescriptifProduit target){
        Set<DescriptifProduit> DescriptifProduitList = new HashSet<>();
        String[] DescriptifProduits = o.split(regex);
        for (String DescriptifProduit : DescriptifProduits) {
            target.setLibelle(DescriptifProduit);
            DescriptifProduitList.add(target);
        }
        return DescriptifProduitList;
    }


    private <T extends DescriptifProduit> Set<T> getDescriptiListGen(String o,String regex,Class<T> clazz){
        Set<T> DescriptifProduitList = new HashSet<>();
        String[] DescriptifProduits = o.split(regex);
        for (String DescriptifProduit : DescriptifProduits) {
            target.setLibelle(DescriptifProduit);
            DescriptifProduitList.add(target);
        }
        return DescriptifProduitList;
    }
    public DescriptifProduit checkIfExist(DescriptifProduit descriptifProduit){

        return null;
    }

}