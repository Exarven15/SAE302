module.exports = mongoose => {
    const Transport = mongoose.model(
      "transports",
      mongoose.Schema(
        {
          psrc: String, //port source
          pdest: String, //port dest
          protocoletrans: String, //protocole UDP/TCP 
          source: String,  //Tls ou dns 
          paquet: {
            type: mongoose.Schema.Types.ObjectId,
            ref: function() {
              switch (this.source) {
                case 'tls':
                  return 'tls';
                case 'dns':
                  return 'dns';
                default:
                  return null;
              }
            }
          }, // id du prochain paquet dns ou tls 
        },
        { versionKey: false }
      )
    );
    return Transport;
  };