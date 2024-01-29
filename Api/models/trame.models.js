module.exports = mongoose => {
    const Trame = mongoose.model(
      "trames",
      mongoose.Schema(
        {
            date: String,  //date de la trame
            intdescript: String,  // description de l'interface 
            numtrame: Number,  // numero de la trame
            macsrc: String, // adresse mac source
            macdest: String, // adress mac destination 
            marque: String, // marque de la carte réseaux
            protocole: String, // protocole utilisé niveau 3 arp/ip
            ipsrc: String, // adresse ip source 
            ipdest: String // adresse ip destination
        },
        { versionKey: false }
      )
    );
    return Trame;
};