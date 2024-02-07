const db = require("../models");
const Transport = db.transport;
const Trame = db.trame;

// Create a new transport
exports.createTransport = async (req, res) => {
  try {
    const transport = new Transport({
      psrc: req.body.psrc,
      pdest: req.body.pdest,
      protocoletrans: req.body.protocoletrans,
    });

    const savedTransport = await transport.save();

    const trame = new Trame({
      date: req.body.date, //date de la trame
      intdescript: req.body.intdescript, // description de l'interface
      numtrame: req.body.numtrame, // numero de la trame
      macsrc: req.body.macsrc, // adresse mac source
      macdest: req.body.macdest, // adress mac destination
      marque: req.body.marque, // marque de la carte réseaux
      protocole: req.body.protocole, // protocole utilisé niveau 3 arp/ip
      ipsrc: req.body.ipsrc, // adresse ip source
      ipdest: req.body.ipdest, // adresse ip destination
      transid: savedTransport._id,
      source: "transports",
    });

    const savedTrame = await trame.save();

    res.json({
      transport: savedTransport,
      trame: savedTrame,
    });
  } catch (error) {
    console.error(error);
    res.status(500).json({ error: "Internal Server Error" });
  }
};
