package fr.diginamic.BO.descriptif;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table
public class Categorie extends DescriptifProduit {
    public Categorie() {
    }
    public Categorie(String s) {
        super(s);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Categorie{");
        sb.append(super.toStringChild());
        sb.append('}');
        return sb.toString();
    }
}
