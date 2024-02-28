const db = require("../models");
const Transport = db.transport;
const Trame = db.trame;
const { check } = require("./auth.controllers")

exports.createdns = async (req, res) => {
  try {

    const auth = await check(req.body.token)

    if (auth){
      const transport = new Transport({
        psrc: req.body.psrc,
        pdest: req.body.pdest,
        protocoletrans: req.body.protocoletrans,
        paquet: { recherche: req.body.recherche, reponse: req.body.reponse, ipreponse: req.body.ipreponse, tempsrep: req.body.tempsrep },
        sources: "dns",
      });

      const savedTransport = await transport.save();

      const trame = new Trame({
        date: req.body.date,
        type: "dns",
        intdescript: req.body.intdescript,
        numtrame: req.body.numtrame,
        macsrc: req.body.macsrc,
        macdest: req.body.macdest,
        marque: req.body.marque,
        protocole: req.body.protocole,
        ipsrc: req.body.ipsrc,
        ipdest: req.body.ipdest,
        source: "transports",

        transid: savedTransport._id,
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