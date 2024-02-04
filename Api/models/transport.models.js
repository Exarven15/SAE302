module.exports = mongoose => {
    const Transport = mongoose.model(
      "transports",
      mongoose.Schema(
        {
          psrc: String, //port source
          pdest: String, //port dest
          protocoletrans: String, //protocole UDP/TCP 
          sources: String,  //Tls ou dns 
          paquet: {} // id du prochain paquet dns ou tls 
        },
        { versionKey: false }
      )
    );
    return Transport;
  };