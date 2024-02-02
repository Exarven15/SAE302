const db = require("../models");
const Icmp = db.icmp
const Trame = db.trame

exports.createicmp = async (req, res) => {
  try {
    const icmp = new Icmp({
        numseq: req.body.numseq,  //Numéro de la séquence de ping
        reponse: req.body.reponse,  // Temps de réponse
    });

    const savedIcmp = await icmp.save();

    const trame = new Trame({
        date: req.body.date, //date de la trame
        intdescript: req.body.intdescript, // description de l'interface 
        numtrame: req.body.numtrame,  // numero de la trame
        macsrc: req.body.macsrc, // adresse mac source
        macdest: req.body.macdest, // adress mac destination 
        marque: req.body.marque, // marque de la carte réseaux
        protocole: req.body.protocole, // protocole utilisé niveau 3 arp/ip/icmp
        ipsrc: req.body.ipsrc, // adresse ip source 
        ipdest: req.body.ipdest, // adresse ip destination
        transid: savedIcmp._id // id de l'objet créé 
    });

    const savedTrame = await trame.save();
    
    res.json({
        icmp: savedIcmp,
        trame: savedTrame,
    });

  } catch (error) {
    console.error(error);
    res.status(500).json({ error: "Internal Server Error" });
  }   

};