module.exports = app => {
    const dns = require("../controllers/dns.controllers.js");
  
    let router = require("express").Router();
  
    router.post("/", dns.createdns);
  
    //router.get("/", transport.findAlltransport);
  
    //router.delete("/", transport.deleteAllUdp);
  
    app.use('/api/dns', router);
};