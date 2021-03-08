package com.bezkoder.springjwt.payload.request;

import java.util.Set;

public class categorierequest {
    private Long id_offre;
    private String name  ;
    private int quantite ;
    private  String description ;
    private Set<String> categories ;

    public Long getId_offre() {
        return id_offre;
    }

    public Set<String> getCategories() {
        return categories;
    }

    public void setCategories(Set<String> categories) {
        this.categories = categories;
    }

    public void setId_offre(Long id_offre) {
        this.id_offre = id_offre;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQuantite() {
        return quantite;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }



    public categorierequest(Long id_offre, String name, int quantite, String description, Set<String> role) {
        this.id_offre = id_offre;
        this.name = name;
        this.quantite = quantite;
        this.description = description;
        this.categories = role;
    }

    public categorierequest(String name, int quantite, String description, Set<String> role) {
        this.name = name;
        this.quantite = quantite;
        this.description = description;
        this.categories = role;
    }

    public categorierequest() {
    }
}
