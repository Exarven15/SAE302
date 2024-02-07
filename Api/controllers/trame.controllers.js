const db = require("../models");
const Trame = db.trame;

// Create a new Trame
exports.createTrame = async (req, res) => {
  try {

    const auth = await check(req.body.token)
    if (!auth){
      const trame = new Trame({
      date: req.body.date, //date de la trame
      intdescript: req.body.intdescript, // description de l'interface
      numtrame: req.body.numtrame, // numero de la trame
      macsrc: req.body.macsrc, // adresse mac source
      macdest: req.body.macdest, // adress mac destination
      marque: req.body.marque, // marque de la carte réseaux
      protocole: req.body.protocole, // protocole utilisé niveau 3 arp/ip/icmp
      ipsrc: req.body.ipsrc, // adresse ip source
      ipdest: req.body.ipdest, // adresse ip destination
    });

    const savedTrame = await trame.save();

    res.json({
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

exports.recupTrame = async (req, res) => {
  try {
    const trames = await Trame.find().populate("transid");

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

//*

exports.deleteAlltrame = (req, res) => {
  Trame.deleteMany({})
    .then((data) => {
      res.send({
        message: `${data.deletedCount} trame were deleted successfully!`,
      });
    })
    .catch((err) => {
      res.status(500).send({
        message: err.message || "Some error occurred while removing all trame.",
      });
    });
};

// */
