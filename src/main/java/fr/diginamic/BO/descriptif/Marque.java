package fr.diginamic.BO.descriptif;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Persistence;
import javax.persistence.Table;

@Entity
@Table(name = "Marque")
public class Marque extends DescriptifProduit {

    public Marque() {
    }

    @Override

    public String getLibelle() {
        return super.getLibelle();
    }

    @Override
    @Column(unique = true)
    public void setLibelle(String libelle) {
        super.setLibelle(libelle);
    }

    public Marque(String s) {
        super(s);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Marque{");
        sb.append(super.toStringChild());
        sb.append('}');
        return sb.toString();
    }
}
