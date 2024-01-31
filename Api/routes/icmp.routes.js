module.exports = app => {
    const icmp = require("../controllers/icmp.controllers.js");
  
    let router = require("express").Router();
  
    router.post("/", icmp.createicmp);
  
    app.use('/api/icmp', router);
};