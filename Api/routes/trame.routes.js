module.exports = app => {
    const trame = require("../controllers/trame.controllers.js");
  
    let router = require("express").Router();
  
    router.post("/", trame.createTrame);

    router.get("/", trame.recupTrame)

    router.delete("/", trame.deleteAlltrame)
  
    app.use('/api/trame', router);
};