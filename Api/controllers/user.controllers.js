const db = require("../models");
const User= db.user;
const jwt = require("jsonwebtoken");
const bcrypt = require("bcrypt")
const { SHA256 } = require("../utils")

// create a new login and password
exports.createUser = async (req, res) => {

    const user = new User({
      password: req.body.password,
      login: req.body.login
    });

    user.password = bcrypt()
  
    try {
      const savedTrame = await trame.save();
      res.send(savedTrame);
    } catch (err) {
      res.status(500).send({
        message: err.message || "Some error occurred while creating the Trame.",
      });
    }
  };

exports.login = async  (req, res) => {

  const user = new User({
    password: req.body.password,
    login: req.body.login
  });

  if (!password || !login){
    return(res.status(401).json({message : 'login et mot de passe requis'}))
  }

  try {
    const realuser = await User.findOne({ login })
    if (!realuser){
      return res.status(401).json({ message: 'login incorrect' });
    }

    const valid = await bcrypt.compare(user.password, realuser.password)
    if (!valid){
      return res.status(401).json({ message: 'mot de passe incorrect' });
    }

    const token = jwt.sign({ login }, SHA256, { expiresIn: '1d' });

    res.status(200).json({ message: 'gg wp', token});

  } catch (error) {
    console.error(error)
  }

}