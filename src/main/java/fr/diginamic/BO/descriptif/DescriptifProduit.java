package fr.diginamic.BO.descriptif;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;


@MappedSuperclass
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class DescriptifProduit {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private Long id;

    protected String libelle;

    public DescriptifProduit(String libelle) {
       setLibelle(libelle);
    }
    public DescriptifProduit() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }
    public String toStringChild() {
        final StringBuilder sb = new StringBuilder();
        sb.append("id=").append(id);
        sb.append(", libelle='").append(libelle).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
