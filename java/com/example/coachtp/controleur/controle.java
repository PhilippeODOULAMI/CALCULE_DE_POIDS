package com.example.coachtp.controleur;

import com.example.coachtp.modele.Profil;

/**
 * Created by Coach 19/04/2023
 */
public final class controle {

    private static controle instance = null;
    private Profil profil;

    /**
     * constructeur private
     */

    private controle(){
        super();

    }

    /**
     * creation de l'instance
     * @return instance
     */
    public static final controle getInstance(){

        if(controle.instance == null) {
            controle.instance = new controle();
        }
        return controle.instance;
    }

    /**
     * creation du profil
     * @param poids
     * @param taille en cm
     * @param age
     * @param sexe 1 pour homme et 0 pur femme
     */
    public void creerProfil ( Integer poids, Integer taille , Integer age, Integer sexe){
        profil = new Profil(poids , taille, age , sexe);
    }

    /**
     * recuperation img de profil
     * @return img
     */
    public float getImg(){
        return profil.getImg();
    }

    /**
     * recuperation msg de profil
     * @return msg
     */
    public String getMsg(){
        return profil.getMsg();
    }



}
