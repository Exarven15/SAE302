module.exports = mongoose => {
    const Icmp = mongoose.model(
      "icmp",
      mongoose.Schema(
        {
            numseq: String,  //Numéro de la séquence de ping
            reponse: String,  // Temps de réponse
        },
        { versionKey: false }
      )
    );
    return Icmp;
};