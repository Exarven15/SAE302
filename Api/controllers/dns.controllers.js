const db = require("../models");
const Dns = db.dns;
const Transport = db.transport;
const Trame = db.trame;

exports.createdns = async (req, res) => {
  try {
    
    const dns = new Dns({
      recherche: req.body.recherche,
      reponse: req.body.reponse,
    });

    const savedDns = await dns.save();
    console.log(savedDns._id);

    
    const transport = new Transport({
      psrc: req.body.psrc,
      pdest: req.body.pdest,
      protocoletrans: req.body.protocoletrans,
      paquet: savedDns._id,
    });

    const savedTransport = await transport.save();
    console.log(savedTransport._id);

    
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
      transid: savedTransport._id,
    });

    const savedTrame = await trame.save();

    res.json({
      dns: savedDns,
      transport: savedTransport,
      trame: savedTrame,
    });
    
  } catch (error) {
    console.error(error);
    res.status(500).json({ error: "Internal Server Error" });
  }
};
