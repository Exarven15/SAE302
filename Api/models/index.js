const { URI } = require("../utils");

const mongoose = require("mongoose");
mongoose.Promise = global.Promise;
mongoose.set("strictQuery", false);

const db = {};
db.mongoose = mongoose;
db.url = URI;
db.transport = require("./transport.models.js")(mongoose);
db.user = require("./user.models.js")(mongoose);
db.trame = require("./trame.models.js")(mongoose);
db.dns = require("./dns.models.js")(mongoose);
db.icmp = require("./icmp.models.js")(mongoose);
db.tls = require("./tls.models.js")(mongoose);

module.exports = db;
