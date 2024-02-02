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