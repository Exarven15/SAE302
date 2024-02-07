const jwt = require("jsonwebtoken");
const bcrypt = require("bcrypt");
const { SHA256 } = require("../utils");
const User = db.user;

exports.login = async (req, res) => {

    const { login, password } = req.body;
  
    if (!password || !login) {
      return res.status(401).json({ message: "login et mot de passe requis" });
    }
  
    try {
      console.log(login)
      const realuser = await User.findOne({ login : login }).lean().exec();
      if (!realuser) {
        return res.status(401).json({ message: "login incorrect" });
      }
  
      const valid = await bcrypt.compare(password, realuser.password);
      if (!valid) {
        return res.status(401).json({ message: "mot de passe incorrect" });
      }
  
      const token = jwt.sign({ login }, SHA256, { expiresIn: "1d" });
  
      res.status(200).json({ message: "gg wp", token });
    } catch (error) {
      console.error(error);
    }
  };
  
exports.check = async (token) => {
    const token = token 

    const decode = jwt.verify(token, SHA256);
    const user = await User.findOne({ pseudo: decode.login }).lean().exec();

    if (!user){
      return false
    } else {
      return true 
    } 
}