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
        transid: savedIcmp._id, // id de l'objet créé
        source: "icmp"
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

/*
exports.getAllIcmp = async (req, res) => {
  try {
    const trames = await Trame.find().populate('transid');

    // Si aucune trame n'est trouvée, renvoyez une réponse vide ou un message approprié
    if (!trames || trames.length === 0) {
      return res.status(404).json({ message: "Aucune trame trouvée." });
    }

    // Renvoyez la liste des trames avec les informations de transport
    res.json(trames);
  } catch (error) {
    console.error(error);
    res.status(500).json({ error: "Internal Server Error" });
  }
};

// */