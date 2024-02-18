module.exports = (app) => {
  const trame = require("../controllers/trame.controllers.js");

  let router = require("express").Router();

  router.post("/arp", trame.createTrame);

  router.get("/trame", trame.recupTrame);

  router.delete("/arp", trame.deleteAlltrame);

  app.use("/api/", router);
};
