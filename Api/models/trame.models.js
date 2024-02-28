module.exports = (mongoose) => {
  const Trame = mongoose.model(
    "trames",
    mongoose.Schema(
      {
        date: String, //date de la trame
        type: String,
        intdescript: String, // description de l'interface
        numtrame: Number, // numero de la trame
        macsrc: String, // adresse mac source
        macdest: String, // adress mac destination
        marque: String, // marque de la carte réseaux
        protocole: String, // protocole utilisé niveau 3 arp/ip
        ipsrc: String, // adresse ip source
        ipdest: String, // adresse ip destination
        source: String, // permet de savoir ce qui suit, transport ou icmp
        transid: {
          type: mongoose.Schema.Types.ObjectId,
          ref: function () {
            switch (this.source) {
              case "transports":
                return "transports";
              case "icmp":
                return "icmp";
              default:
                return null;
            }
          },
        },
      },
      { versionKey: false },
    ),
  );
  return Trame;
};
