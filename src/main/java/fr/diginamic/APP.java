package fr.diginamic;

import fr.diginamic.BLL.OpenfoodfactsService;
import fr.diginamic.BO.Produit;
import fr.diginamic.DAL.Connexion;

import javax.persistence.EntityManager;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import java.util.*;

public class APP {
    public static void main(String[] args) throws IOException {

        Path path = Paths.get("C:\\Users\\moi\\Desktop\\code\\cours\\diginamics\\java\\tp07_Open_Food_Facts\\src\\main\\resources\\open-food-facts.csv");
        List<String>lines = Files.readAllLines(path, StandardCharsets.UTF_8);
        OpenfoodfactsService opfService = new OpenfoodfactsService();
        EntityManager em = new Connexion().getManager();

        List<Produit> produitList = new ArrayList<>();
        for (String line : lines) {
            Produit produit = opfService.createProduit(line);
            if (produit != null) produitList.add(produit);
        }
//        em.getTransaction().begin();
//        for (int i = 0; i < produitList.size(); i++) {
//                em.persist(produitList.get(i));
//            if ((i % 50) == 0){
//                em.flush();
//                em.clear();
//                em.getTransaction().commit();
//                em.getTransaction().begin();
//            }
//        }
//        em.getTransaction().commit();

    }
}
