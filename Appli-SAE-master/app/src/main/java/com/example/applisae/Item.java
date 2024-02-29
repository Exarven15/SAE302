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
            return "Type de trame : '" + type +
                    "', \nid='" + _id +
                    "', \ndate='" + date +
                    "', \nintdescript='" + intdescript +
                    "', \nnumtrame=" + numtrame +
                    "', \nmacsrc=" + macsrc +
                    "', \nmacdest=" + macdest +
                    "', \nmarque=" + marque +
                    "', \nprotocole=" + protocole +
                    "', \nipsrc=" + ipsrc +
                    "', \nipdest=" + ipdest +
                    "', \nsource=" + source +
                    "', \npsrc=" + psrc +
                    "', \npdest=" + pdest +
                    "', \nsources=" + sources +
                    "', \nrecherche=" + recherche +
                    "', \nreponse=" + reponse +
                    "', \nipreponse=" + ipreponse +
                    "', \ntempsrep=" + tempsrep + '}';
        } else if (Objects.equals(type, "icmp")) {
            return  "Type de trame : '" + type +
                    "', \nid='" + _id +
                    "', \ndate='" + date +
                    "', \nintdescript='" + intdescript +
                    "', \nnumtrame=" + numtrame +
                    "', \nmacsrc=" + macsrc +
                    "', \nmacdest=" + macdest +
                    "', \nmarque=" + marque +
                    "', \nprotocole=" + protocole +
                    "', \nipsrc=" + ipsrc +
                    "', \nipdest=" + ipdest +
                    "', \nsource=" + source +
                    "', \nreponse=" + reponse + '}';
        } else if (Objects.equals(type, "tcp")) {
            return  "Type de trame : '" + type +
                    "', \nid='" + _id +
                    "', \ndate='" + date +
                    "', \nintdescript='" + intdescript +
                    "', \nnumtrame=" + numtrame +
                    "', \nmacsrc=" + macsrc +
                    "', \nmacdest=" + macdest +
                    "', \nmarque=" + marque +
                    "', \nprotocole=" + protocole +
                    "', \nipsrc=" + ipsrc +
                    "', \nipdest=" + ipdest +
                    "', \nsource=" + source +
                    "', \npsrc=" + psrc +
                    "', \npdest=" + pdest + '}';
        }
        return null;
    }

    // D'autres méthodes, si nécessaire
}
