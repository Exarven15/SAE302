const { config } = require("dotenv");
config();

const SHA256 = process.env.SHA256;
const URI = process.env.URI;
const IP = process.env.IP;

module.exports = { SHA256, URI, IP }