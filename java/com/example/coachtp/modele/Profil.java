package com.example.coachtp.modele;

public class Profil {
    private static final Integer minFemme =15;
    private static final Integer maxFemme =30;
    private static final Integer minHomme =10;
    private static final Integer maxHomme =25;

    private Integer poids;
    private Integer taille;
    private Integer age;
    private Integer sexe;
    private float img;
    private String msg;

    public Profil(int poids, int taille, int age, int sexe) {
        this.poids = poids;
        this.taille = taille;
        this.age = age;
        this.sexe = sexe;
        this.calcul();
        this.resultIMG();
    }

    public Integer getPoids() {
        return poids;
    }

    public Integer getTaille() {
        return taille;
    }

    public Integer getAge() {
        return age;
    }

    public Integer getSexe() {
        return sexe;
    }

    public float getImg() {
        return img;
    }

    public String getMsg() {
        return msg;
    }
    private void calcul(){
        float tailleM = ((float)taille)/100;
        this.img = (float)(1.2*poids /(tailleM*tailleM) +(0.23*age) -(10.83*sexe)-5.4);
    }
    private void resultIMG()
    {
        Integer min;
        Integer max;
        if (sexe==0){ //femme
            min = minFemme;
            max = maxFemme;
        }else{
            min = minHomme;
            max = maxHomme;
        }
        //message correspondant
        msg = "normal";
        if(img<min){
            msg = "trop faible";
        } else if (img>max) {
            msg = "trop elevé";

        }
    }
}
