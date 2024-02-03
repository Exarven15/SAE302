module.exports = app => {
    const icmp = require("../controllers/icmp.controllers.js");
  
    let router = require("express").Router();
  
    router.post("/", icmp.createicmp);

    router.get("/", icmp.getAllIcmp);
  
    app.use('/api/icmp', router);
};