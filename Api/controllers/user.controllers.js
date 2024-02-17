const db = require("../models");
const User = db.user;
const bcrypt = require("bcrypt");

// create a new login and password
exports.createUser = async (req, res) => {
  const user = new User({
    password: req.body.password,
    login: req.body.login,
  });

  user.password = await bcrypt.hash(user.password, 10);

  try {
    const savedUser = await user.save();
    res.send(savedUser);
  } catch (err) {
    res.status(500).send({
      message: err.message || "Some error occurred while creating the Trame.",
    });
  }
};