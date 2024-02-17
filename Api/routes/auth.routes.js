module.exports = (app) => {
    const auth = require("../controllers/auth.controllers.js");
  
    let router = require("express").Router();
  
    router.post("/", auth.login);
  
    //router.get("/", user.findAllUsers);
  
    app.use("/api/auth", router);
  };
  