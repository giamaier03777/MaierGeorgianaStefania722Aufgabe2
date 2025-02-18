package src.Repository;
import java.util.*;

import src.Domain.Produkt;
import src.Domain.Charakter;

import java.util.ArrayList;
import java.util.List;


public class CharakterRepo {
    private List<Charakter> charakterList;


    public CharakterRepo() {
        charakterList = new ArrayList<>();
    }


    public List<Charakter> getCharakterList() {
        return charakterList;
    }

    public void addCharakter(Charakter charakter) {
        charakterList.add(charakter);
    }

    public void removeCharakter(Charakter charakter) {
        charakterList.remove(charakter);
    }

    public void getAllCharakter() {
        for (Charakter charakter : charakterList) {
            System.out.println(charakter);
        }
    }

    public void updateCharakter(Charakter charakter) {
        charakterList.remove(charakter);
        charakterList.add(charakter);
    }

    public Charakter findCharacterbyId(int id) {
        for (Charakter charakter : charakterList) {
            if (charakter.getId() == id) {
                return charakter;
            }
        }
        return null;
    }
}
