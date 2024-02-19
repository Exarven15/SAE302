package com.example.applisae;

import com.google.gson.annotations.SerializedName;

public class Item{

    @SerializedName("itemName")
    private String itemName;

    @SerializedName("itemDescription")
    private String itemDescription;

    // Constructeur, getters, setters, etc.

    // Exemple de constructeur
    public Item(String itemName, String itemDescription) {
        this.itemName = itemName;
        this.itemDescription = itemDescription;
    }

    // Exemple de getters et setters
    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getItemDescription() {
        return itemDescription;
    }

    public void setItemDescription(String itemDescription) {
        this.itemDescription = itemDescription;
    }

    private String _id, date, intdescript, macsrc, macdest, marque, protocole, ipsrc, ipdest, source,psrc,pdest,sources,recherche,reponse,ipreponse,tempsrep;
    private Number numtrame;

    public String toString() {
        // Personnalise la représentation textuelle de l'objet
        return "Item{id='" + _id +
                "', date='" + date +
                "', intdescript='" + intdescript +
                "', numtrame=" + numtrame +
                "', macsrc=" + macsrc +
                "', macdest=" + macdest +
                "', marque=" + marque +
                "', protocole=" + protocole +
                "', ipsrc=" + ipsrc +
                "', ipdest=" + ipdest +
                "', source=" + source +
                "', psrc=" + psrc +
                "', pdest=" + pdest +
                "', sources=" + sources +
                "', recherche=" + recherche +
                "', reponse=" + reponse +
                "', ipreponse=" + ipreponse +
                "', tempsrep=" + tempsrep
                /* Ajoute d'autres propriétés ici */ + '}';


    }

    // D'autres méthodes, si nécessaire
}
