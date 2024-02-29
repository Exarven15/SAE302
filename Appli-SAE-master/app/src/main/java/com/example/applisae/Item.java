package com.example.applisae;

import com.google.gson.annotations.SerializedName;

import java.util.Objects;

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

    private String _id, date, intdescript, macsrc, macdest, marque, protocole, ipsrc, ipdest, source,psrc,pdest,sources,recherche,reponse,ipreponse,tempsrep,type;
    private Number numtrame;

    public String toString() {
        // Personnalise la représentation textuelle de l'objet

        if (Objects.equals(type, "dns")){
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
                    "', tempsrep=" + tempsrep + '}';
        } else if (Objects.equals(type, "icmp")) {
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
                    "', reponse=" + reponse + '}';
        } else if (Objects.equals(type, "tcp")) {
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
                    "', pdest=" + pdest + '}';
        }
        return null;
    }

    // D'autres méthodes, si nécessaire
}
