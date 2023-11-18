module.exports = app => {
    const udp = require("../controllers/udp.controllers.js");
  
    let router = require("express").Router();
  
    router.post("/", udp.createUdp);
  
    router.get("/", udp.findAllUdp);
  
    router.delete("/", udp.deleteAllUdp);
  
    app.use('/api/Udp', router);
};