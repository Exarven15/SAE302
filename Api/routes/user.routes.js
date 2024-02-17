module.exports = (app) => {
  const user = require("../controllers/user.controllers.js");

  let router = require("express").Router();

  router.post("/", user.createUser);

  //router.get("/", user.findAllUsers);

  app.use("/api/User", router);
};
