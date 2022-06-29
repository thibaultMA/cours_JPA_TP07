package fr.diginamic.BO.descriptif;

import fr.diginamic.BO.Produit;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table
public class Ingredient extends DescriptifProduit {

    @ManyToMany(mappedBy = "ingredients", cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private Set<Produit> produits = new LinkedHashSet<>();

    public Set<Produit> getProduits() {
        return produits;
    }

    public void setProduits(Set<Produit> produits) {
        this.produits = produits;
    }

    public Ingredient() {
    }

    public Ingredient(String ingrerdiant) {
        super(ingrerdiant);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Ingredient{");
        sb.append(super.toStringChild());
        sb.append('}');
        return sb.toString();
    }
}
