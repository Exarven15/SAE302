const { config } = require("dotenv");
config();

const SHA256 = process.env.SHA256;

module.exports = { SHA256 }