module.exports = app => {
    const transport = require("../controllers/transport.controllers.js");
  
    let router = require("express").Router();
  
    router.post("/", transport.createTransport);
  
    //router.get("/", transport.findAlltransport);
  
    //router.delete("/", transport.deleteAllUdp);
  
    app.use('/api/transport', router);
};