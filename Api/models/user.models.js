module.exports = mongoose => {
    const User = mongoose.model(
      "users",
      mongoose.Schema(
        {
          login: String,
          password: String
        },
        { versionKey: false }
      )
    );
    return User;
  };