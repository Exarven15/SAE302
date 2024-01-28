const db = require("../models");
const User= db.user

// create a new login and password
exports.createUser = (req, res) => {
    if (!req.body.login || !req.body.password) {
      res.status(400).send({ message: "Need a login and password !"});
      return;
    }
  
    const user = new User({
      password: req.body.password,
      login: req.body.login
    });
  
    user
      .save(user)
      .then(data => {
        res.send(data);
      })
      .catch(err => {
        res.status(500).send({
          message:
            err.message || "Some error occurred while creating the new user."
        });
      });
  };