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
public class Allergene extends DescriptifProduit {
    @ManyToMany(mappedBy = "allergenes", cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private Set<Produit> produits = new LinkedHashSet<>();

    public Set<Produit> getProduits() {
        return produits;
    }

    public void setProduits(Set<Produit> produits) {
        this.produits = produits;
    }

    public Allergene(String libelle) {
        super(libelle);
    }

    public Allergene() {
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Allergene{");
        sb.append(super.toStringChild());
        sb.append('}');
        return sb.toString();
    }
}
