module.exports = app => {
    const trame = require("../controllers/trame.controllers.js");
  
    let router = require("express").Router();
  
    router.post("/", trame.createTrame);
  
    app.use('/api/trame', router);
};