module.exports = mongoose => {
    const Udp = mongoose.model(
      "udps",
      mongoose.Schema(
        {
          ipsource: String,
          ipdest: String,
          frameNumber: Number
        },
        { versionKey: false }
      )
    );
    return Udp;
  };