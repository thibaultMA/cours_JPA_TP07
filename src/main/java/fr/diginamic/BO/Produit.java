package fr.diginamic.BO;
import fr.diginamic.BO.descriptif.*;

import javax.persistence.*;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "Produit")
public class Produit {
//    0 categorie, 1 marque,2 nom,3 nutritionGradeFr,4 ingredients,
//    5 energie100g,6 graisse100g,7 sucres100g,8 fibres100g,
//    9 proteines100g, 10 sel100g,
//    11 vitA100g,12 vitD100g,13 vitE100g,14 vitK100g,15 vitC100g,16 vitB1100g, 17 vitB2100g,18 vitPP100g,
//    19 vitB6100g, 20 vitB9100g,21 vitB12100g,
//    22 calcium100g,23 magnesium100g,
//    24 iron100g,25 fer100g, 26 betaCarotene100g,27 presenceHuilePalme,
//    28 allergenes,29 additifs


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(name = "categorie_id")
    private Categorie categorie;
     @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
     @JoinColumn(name = "marque_id")
    private Marque marque;
    private String nom ;
    private String nutritionGradeFr;
    private String energie100g;
    private String graisse100g;
    private String sucres100g;
    private String fibres100g;
    private String proteines100g;
    private String sel100g;
    private String calcium100g;
    private String magnesium100g;
    private String iron100g;
    private String fer100g;
    private String betaCarotene100g;
    private String presenceHuilePalme;

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(name = "Produit_ingredients",
            joinColumns = @JoinColumn(name = "produit_id"),
            inverseJoinColumns = @JoinColumn(name = "ingredients_id"))
    private Set<Ingredient> ingredients = new LinkedHashSet<>();

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(name = "Produit_allergenes",
            joinColumns = @JoinColumn(name = "produit_id"),
            inverseJoinColumns = @JoinColumn(name = "allergenes_id"))
    private Set<Allergene> allergenes = new LinkedHashSet<>();

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(name = "Produit_additifses",
            joinColumns = @JoinColumn(name = "produit_id"),
            inverseJoinColumns = @JoinColumn(name = "additifses_id"))
    private Set<Additifs> additifses = new LinkedHashSet<>();

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(name = "Produit_vitamines",
            joinColumns = @JoinColumn(name = "produit_id"),
            inverseJoinColumns = @JoinColumn(name = "vitamines_id"))
    private Set<Vitamine> vitamines = new LinkedHashSet<>();

    public Set<Vitamine> getVitamines() {
        return vitamines;
    }

    public void setVitamines(Set<Vitamine> vitamines) {
        this.vitamines = vitamines;
    }

    public Set<Additifs> getAdditifses() {
        return additifses;
    }

    public void setAdditifses(Set<Additifs> additifses) {
        this.additifses = additifses;
    }

    public Set<Allergene> getAllergenes() {
        return allergenes;
    }

    public void setAllergenes(Set<Allergene> allergenes) {
        this.allergenes = allergenes;
    }

    public Set<Ingredient> getIngredients() {
        return ingredients;
    }

    public void setIngredients(Set<Ingredient> ingredients) {
        this.ingredients = ingredients;
    }

    public String getNutritionGradeFr() {
        return nutritionGradeFr;
    }

    public void setNutritionGradeFr(String nutritionGradeFr) {
        this.nutritionGradeFr = nutritionGradeFr;
    }

    public String getIron100g() {
        return iron100g;
    }

    public void setIron100g(String iron100g) {
        this.iron100g = iron100g;
    }

    public String getFer100g() {
        return fer100g;
    }

    public void setFer100g(String fer100g) {
        this.fer100g = fer100g;
    }

    public String getBetaCarotene100g() {
        return betaCarotene100g;
    }

    public void setBetaCarotene100g(String betaCarotene100g) {
        this.betaCarotene100g = betaCarotene100g;
    }

    public String getPresenceHuilePalme() {
        return presenceHuilePalme;
    }

    public void setPresenceHuilePalme(String presenceHuilePalme) {
        this.presenceHuilePalme = presenceHuilePalme;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMagnesium100g() {
        return magnesium100g;
    }

    public void setMagnesium100g(String magnesium100g) {
        this.magnesium100g = magnesium100g;
    }



    public String getCalcium100g() {
        return calcium100g;
    }

    public void setCalcium100g(String calcium100g) {
        this.calcium100g = calcium100g;
    }



    public String getSel100g() {
        return sel100g;
    }

    public void setSel100g(String sel100g) {
        this.sel100g = sel100g;
    }

    public String getProteines100g() {
        return proteines100g;
    }

    public void setProteines100g(String proteines100g) {
        this.proteines100g = proteines100g;
    }

    public String getFibres100g() {
        return fibres100g;
    }

    public void setFibres100g(String fibres100g) {
        this.fibres100g = fibres100g;
    }

    public String getSucres100g() {
        return sucres100g;
    }

    public void setSucres100g(String sucres100g) {
        this.sucres100g = sucres100g;
    }



    public String getGraisse100g() {
        return graisse100g;
    }

    public void setGraisse100g(String graisse100g) {
        this.graisse100g = graisse100g;
    }

    public String getEnergie100g() {
        return energie100g;
    }

    public void setEnergie100g(String energie100g) {
        this.energie100g = energie100g;
    }

    public Produit() {
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Categorie getCategorie() {
        return categorie;
    }

    public void setCategorie(Categorie categorie) {
        this.categorie = categorie;
    }

    public Marque getMarque() {
        return marque;
    }

    public void setMarque(Marque marque) {
        this.marque = marque;
    }

    public String getScoreNutritionnel() {
        return nutritionGradeFr;
    }

    public void setScoreNutritionnel(String nutritionGradeFr) {
        this.nutritionGradeFr = nutritionGradeFr;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Produit{");
        sb.append("id=").append(id);
        sb.append(", categorie=").append(categorie);
        sb.append(", marque=").append(marque);
        sb.append(", nom='").append(nom).append('\'');
        sb.append(", nutritionGradeFr='").append(nutritionGradeFr).append('\'');
        sb.append(", energie100g='").append(energie100g).append('\'');
        sb.append(", graisse100g='").append(graisse100g).append('\'');
        sb.append(", sucres100g='").append(sucres100g).append('\'');
        sb.append(", fibres100g='").append(fibres100g).append('\'');
        sb.append(", proteines100g='").append(proteines100g).append('\'');
        sb.append(", sel100g='").append(sel100g).append('\'');
        sb.append(", calcium100g='").append(calcium100g).append('\'');
        sb.append(", magnesium100g='").append(magnesium100g).append('\'');
        sb.append(", iron100g='").append(iron100g).append('\'');
        sb.append(", fer100g='").append(fer100g).append('\'');
        sb.append(", betaCarotene100g='").append(betaCarotene100g).append('\'');
        sb.append(", presenceHuilePalme='").append(presenceHuilePalme).append('\'');
        sb.append(", ingredients=").append(ingredients);
        sb.append(", allergenes=").append(allergenes);
        sb.append(", additifses=").append(additifses);
        sb.append(", vitamines=").append(vitamines);
        sb.append('}');
        return sb.toString();
    }
}
