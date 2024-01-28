const db = require("../models");
const Udp = db.udp

// Create a new Udp
exports.createUdp = (req, res) => {
    if (!req.body.ipsource) {
      res.status(400).send({ message: "Content can not be empty!" });
      return;
    }
  
    const udp = new Udp({
      ipsource: req.body.ipsource,
      ipdest: req.body.ipdest,
      frameNumber: req.body.frameNumber,
    });
  
    udp
      .save(udp)
      .then(data => {
        res.send(data);
      })
      .catch(err => {
        res.status(500).send({
          message:
            err.message || "Some error occurred while creating the Udp."
        });
      });
  };

exports.findAllUdp = (req, res) => {
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