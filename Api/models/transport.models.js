module.exports = mongoose => {
    const Transport = mongoose.model(
      "transports",
      mongoose.Schema(
        {
          psrc: String, //port source
          pdest: String, //port dest
          protocoletrans: String, //protocole UDP/TCP 
          paquetdns: [{type : mongoose.Schema.Types.ObjectId, ref: 'dns'}], // id du prochain paquet dns
          paquettls: [{type : mongoose.Schema.Types.ObjectId, ref: 'tls'}], // id du porchain paquet tls
        },
        { versionKey: false }
      )
    );
    return Transport;
  };