module.exports = mongoose => {
    const Transport = mongoose.model(
      "transports",
      mongoose.Schema(
        {
          psrc: String, //port source
          pdest: String, //port dest
          protocole: String, //protocole UDP/TCP 
          paquet: String // id du prochain paquet
        },
        { versionKey: false }
      )
    );
    return Transport;
  };