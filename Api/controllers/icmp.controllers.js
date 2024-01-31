const db = require("../models");
const Icmp = db.icmp
const Transport = db.transport
const Trame = db.trame

exports.createicmp = async (req, res) => {
      
    const icmp = new Icmp({
        numseq: req.body.numseq,  //Numéro de la séquence de ping
        reponse: req.body.reponse,  // Temps de réponse
    });

    try {
        const savedIcmp = await icmp.save();
        console.log(savedIcmp._id); // Récupérer l'id de l'objet créé
        res.send(savedIcmp);
      } catch (err) {
        res.status(500).send({
          message: err.message || "Some error occurred while creating the Icmp.",
        });
      }

    const transport = new Transport({
        psrc: req.body.psrc, //port source
        pdest: req.body.pdest, //port dest
        protocole: req.body.protocole, //protocole UDP/TCP 
        paquet: savedIcmp._id // id du prochain paquet
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
        ipdest: req.body.ipdest, // adresse ip destination
        transid: savedTransport._id // id de l'objet créé 
    });

    try {
        const savedTrame = await trame.save();
        res.send(savedTrame);
      } catch (err) {
        res.status(500).send({
          message: err.message || "Some error occurred while creating the Trame.",
        });
      }
  
};