const db = require("../models");
const Transport = db.transport

// Create a new Udp
exports.createTransport = (req, res) => {
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
  
    transport
      .save(transport)
      .then(data => {
        res.send(data);
      })
      .catch(err => {
        res.status(500).send({
          message:
            err.message || "Some error occurred while creating the transport."
        });
      });
  };

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