const db = require("../models");
const Transport = db.transport
const Trame = db.trame

// Create a new transport
exports.createTransport = async (req, res) => {
    if (!req.body.psrc) {
      res.status(400).send({ message: "Content can not be empty!" });
      return;
    }
  
    const transport = new Transport({
      psrc: req.body.psrc,
      pdest: req.body.pdest,
      protocole: req.body.protocole,
      paquet: req.body.paquet
    });
  
    try {
      const savedTransport = await transport.save();
      console.log(savedTransport._id); // Récupérer l'id de l'objet créé
      res.send(savedTransport);
    } catch (err) {
      res.status(500).send({
        message: err.message || "Some error occurred while creating the Transport.",
      });
    }

    const trame = new Trame({
      date: req.body.date, //date de la trame
      intdescript: req.body.intdescript, // description de l'interface 
      numtrame: req.body.numtrame,  // numero de la trame
      macsrc: req.body.macsrc, // adresse mac source
      macdest: req.body.macdest, // adress mac destination 
      marque: req.body.marque, // marque de la carte réseaux
      protocole: req.body.protocole, // protocole utilisé niveau 3 arp/ip
      ipsrc: req.body.ipsrc, // adresse ip source 
      ipdest: req.body.ipdest // adresse ip destination
      
  });

  try {
      const savedTrame = await trame.save();
      console.log(savedTrame._id); // Récupérer l'id de l'objet créé
      res.send(savedTrame);
    } catch (err) {
      res.status(500).send({
        message: err.message || "Some error occurred while creating the Trame.",
      });
    }

  };

//*

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

/*
exports.deleteAllUdp = (req, res) => {
    Udp.deleteMany({})
      .then(data => {
        res.send({
          message: `${data.deletedCount} Udp were deleted successfully!`
        });
      })
      .catch(err => {
        res.status(500).send({
          message:
            err.message || "Some error occurred while removing all Udp."
        });
      });
  }; */