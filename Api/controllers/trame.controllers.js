const db = require("../models");
const Trame = db.trame

// Create a new Trame
exports.createTrame = async (req, res) => {
      
    const trame = new Trame({
        date: req.body.date,  
        intdescript: req.body.intdescript, 
        numtrame: req.body.numtrame,
        macsrc: req.body.macsrc,
        macdest: req.body.macsrc, 
        marque: req.body.marque,
        protocole: req.body.protocole,
        ipsrc: req.body.ipsrc,
        ipdest: req.body.ipdest
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

exports.recupTrame = async (req, res) => {

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


//*

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
};
  
// */