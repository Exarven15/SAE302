module.exports = (app) => {
  const dns = require("../controllers/dns.controllers.js");

  let router = require("express").Router();

  router.post("/", dns.createdns);

  app.use("/api/dns", router);
};
