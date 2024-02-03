const db = require("../models");
const Tls = db.tls
const Transport = db.transport
const Trame = db.trame

exports.createtls = async (req, res) => {
  try {

    const tls = new Tls({
        taille: req.body.taille,  //Longueur données
        type: req.body.type,  // type (handeshake ou contenu) 
        content: req.body.content,  // contenu de la réponse dependant du type
    });

    const savedTls = await tls.save();

    const transport = new Transport({
        psrc: req.body.psrc, //port source
        pdest: req.body.pdest, //port dest
        protocoletrans: req.body.protocole, //protocole UDP/TCP 
        paquet: savedTls._id, // id du prochain paquet
        source:"tls"
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
        transid: savedTransport._id // id de l'objet créé 
    });

    const savedTrame = await trame.save();

    res.json({
        tls: savedTls,
        transport: savedTransport,
        trame: savedTrame,
    });

  } catch (error) {

    console.error(error);
    res.status(500).json({ error: "Internal Server Error" });

  }    
  
};