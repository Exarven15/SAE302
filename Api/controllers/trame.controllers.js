const db = require("../models");
const Trame = db.trame

// Create a new Trame
exports.createTrame = (req, res) => {
      
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
  
    trame
      .save(trame)
      .then(data => {
        res.send(data);
      })
      .catch(err => {
        res.status(500).send({
          message:
            err.message || "Some error occurred while creating the Trame."
        });
    });
};

exports.createTrameV2 = async (req, res) => {
      
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
  
    const response = await trame
      .save(trame)
      .then(data => {
        res.send(data);
      })
      .catch(err => {
        res.status(500).send({
          message:
            err.message || "Some error occurred while creating the Trame."
        });
    });

    console.log()
};

/*

exports.createTrame = async (req, res) => {
    try {
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

        const savedTrame = await trame.save();

        const autreObjet = new AutreObjet({
            param1: req.body.param1,
            param2: req.body.param2,
            trame: savedTrame._id
        });

            await autreObjet.save();

        res.send(savedTrame);
    } catch (err) {
        res.status(500).send({
            message: err.message || "Une erreur s'est produite lors de la création de la Trame et de l'AutreObjet."
        });
    }
};

*/