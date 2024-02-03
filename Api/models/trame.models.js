const { transport } = require(".");

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
            ipdest: String, // adresse ip destination
            transid: [{type : mongoose.Schema.Types.ObjectId, ref: 'transport'}], // id du porchain paquet transport
            icmpid: [{type : mongoose.Schema.Types.ObjectId, ref: 'icmp'}], // id du porchain paquet icmp
        },
        { versionKey: false }
      )
    );
    return Trame;
};