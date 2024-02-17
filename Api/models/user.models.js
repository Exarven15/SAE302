module.exports = (mongoose) => {
  const User = mongoose.model(
    "users",
    mongoose.Schema(
      {
        login: { type: String, require: true, unique: true },
        password: { type: String, require: true },
      },
      { versionKey: false },
    ),
  );
  return User;
};
