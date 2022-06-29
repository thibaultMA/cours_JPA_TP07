package fr.diginamic.BO.descriptif;




import fr.diginamic.BO.Produit;

import javax.persistence.CascadeType;
import javax.persistence.Entity;

import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.util.LinkedHashSet;
import java.util.Set;


@Entity
@Table(name = "vitamine")
public class Vitamine extends DescriptifProduit {


    @ManyToMany(mappedBy = "vitamines", cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private Set<Produit> produits = new LinkedHashSet<>();

    public Set<Produit> getProduits() {
        return produits;
    }

    public void setProduits(Set<Produit> produits) {
        this.produits = produits;
    }

    public Vitamine(String libelle) {
        super(libelle);
    }

    public Vitamine() {
    }
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Vitamine{");
        sb.append(super.toStringChild());
        sb.append('}');
        return sb.toString();
    }
}
