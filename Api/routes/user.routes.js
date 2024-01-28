const user = require("../controllers/user.controllers.js")

module.exports = app => {

    let router = require("express").Router();

    router.post("/", user.createUser);
}