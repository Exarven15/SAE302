module.exports = mongoose => {
    const Dns = mongoose.model(
      "dns",
      mongoose.Schema(
        {
            recherche: String,  //nom de la recherche
            reponse: String,  // réponse serveur 
            ipdns: Number,  // numero de la trame
        },
        { versionKey: false }
      )
    );
    return Dns;
};