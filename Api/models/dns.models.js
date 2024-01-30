module.exports = mongoose => {
    const Dns = mongoose.model(
      "dns",
      mongoose.Schema(
        {
            recherche: String,  //nom de la recherche
            reponse: String,  // réponse serveur
        },
        { versionKey: false }
      )
    );
    return Dns;
};