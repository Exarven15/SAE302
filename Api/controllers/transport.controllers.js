const db = require("../models");
const Transport = db.transport;
const Trame = db.trame;
const { check } = require("./auth.controllers")

// Create a new transport
exports.createTransport = async (req, res) => {
  try {

    const auth = await check(req.body.token)

    if (auth){
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
    } else {
      return res.status(401).json({ message: "token incorect" });
    }

  } catch (error) {
    console.error(error);
    res.status(500).json({ error: "Internal Server Error" });
  }
};
