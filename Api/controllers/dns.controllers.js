const db = require("../models");
const Dns = db.dns;
const Transport = db.transport;
const Trame = db.trame;

exports.createdns = async (req, res) => {
  try {
    
    const transport = new Transport({
      psrc: req.body.psrc,
      pdest: req.body.pdest,
      protocoletrans: req.body.protocoletrans,
      paquet: {recherche: req.body.recherche, reponse: req.body.reponse,},
      sources: "dns",
    });

    const savedTransport = await transport.save();
    
    const trame = new Trame({
      date: req.body.date,
      intdescript: req.body.intdescript,
      numtrame: req.body.numtrame,
      macsrc: req.body.macsrc,
      macdest: req.body.macdest,
      marque: req.body.marque,
      protocole: req.body.protocole,
      ipsrc: req.body.ipsrc,
      ipdest: req.body.ipdest,
      source: 'transports',
      
      transid: savedTransport._id,
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
