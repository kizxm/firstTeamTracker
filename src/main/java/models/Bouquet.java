package models;

import java.util.ArrayList;

public class Bouquet {
    private String flower1;
    private String flower2;
    private ArrayList<String> flower3;

    private int id;
    private static ArrayList<Bouquet> allFlowers = new ArrayList<Bouquet>();

    public Bouquet(String flower1, String flower2) {
        this.flower1 = flower1;
        this.flower2 = flower2;
        this.flower3 = new ArrayList<>();
        allFlowers.add(this);
        this.id = allFlowers.size();
    }

//    public void update(String flower1, String flower2, String flower3) {
//        this.flower1 = flower1;
//        this.flower2 = flower2;
//        this.flower3 = flower3;
//    }


    public void addMember(String memberName){
        String newMember = memberName;
        flower3.add(newMember);
    }

    public static Bouquet findById(int id){
        return allFlowers.get(id-1);
    }
    public int getId() {
        return id;
    }




    public static void clearAllFlowers() {
        allFlowers.clear();
    }

    public static ArrayList<Bouquet> getAll() {
        return allFlowers;
    }

    /// getters & setters//////
    public String getFlower1() {
        return flower1;
    }
    public String getFlower2() {
        return flower2;
    }
    public ArrayList<String> getFlower3() { return flower3; }
    public static ArrayList<Bouquet> getAllFlowers() {
        return allFlowers;
    }
    public void setFlower1(String flower1) { this.flower1 = flower1; }
    ////////////////
}
