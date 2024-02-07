module.exports = (app) => {
  const tls = require("../controllers/tls.controllers.js");

  let router = require("express").Router();

  router.post("/", tls.createtls);

  app.use("/api/tls", router);
};
