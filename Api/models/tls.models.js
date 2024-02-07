module.exports = (mongoose) => {
  const Tls = mongoose.model(
    "tls",
    mongoose.Schema(
      {
        taille: String, //Longueur données
        type: String, // type (handeshake ou contenu)
        content: String, // contenu de la réponse dependant du type
      },
      { versionKey: false },
    ),
  );
  return Tls;
};
