module.exports = (app) => {
  const transport = require("../controllers/transport.controllers.js");

  let router = require("express").Router();

  router.post("/", transport.createTransport);

  //router.get("/", transport.findAllTransport);

  //router.delete("/", transport.deleteAllUdp);

  app.use("/api/tcp", router);
};
