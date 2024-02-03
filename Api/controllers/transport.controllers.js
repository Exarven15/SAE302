const db = require("../models");
const Transport = db.transport
const Trame = db.trame

// Create a new transport
exports.createTransport = async (req, res) => {
  try {

    const transport = new Transport({
      psrc: req.body.psrc,
      pdest: req.body.pdest,
      protocoletrans: req.body.protocole,
      paquet: req.body.paquet
    });
  
    const savedTransport = await transport.save();

    const trame = new Trame({
      date: req.body.date, //date de la trame
      intdescript: req.body.intdescript, // description de l'interface 
      numtrame: req.body.numtrame,  // numero de la trame
      macsrc: req.body.macsrc, // adresse mac source
      macdest: req.body.macdest, // adress mac destination 
      marque: req.body.marque, // marque de la carte réseaux
      protocole: req.body.protocole, // protocole utilisé niveau 3 arp/ip
      ipsrc: req.body.ipsrc, // adresse ip source 
      ipdest: req.body.ipdest, // adresse ip destination
      transid: savedTransport._id
      
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

/*

exports.findAllTransport = (req, res) => {
    const ipsource = req.query.ipsource;
    var condition = ipsource ? { ipsource: { $regex: new RegExp(ipsource), $options: "i" } } : {};
  
    Udp.find(condition)
      .then(data => {
        res.send(data);
      })
      .catch(err => {
        res.status(500).send({
          message:
            err.message || "Some error occurred while retrieving Udp."
        });
      });
  };
  
//*/