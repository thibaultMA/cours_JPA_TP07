package fr.diginamic.BO.descriptif;

import fr.diginamic.BO.Produit;

import javax.persistence.*;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "additif")
public class Additifs extends DescriptifProduit {
    @ManyToMany(mappedBy = "additifses", cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private Set<Produit> produits = new LinkedHashSet<>();

    public Set<Produit> getProduits() {
        return produits;
    }

    public void setProduits(Set<Produit> produits) {
        this.produits = produits;
    }

    public Additifs(String libelle) {
        super(libelle);
    }

    public Additifs() {
    }
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Additifs{");
        sb.append(super.toStringChild());
        sb.append('}');
        return sb.toString();
    }
}
