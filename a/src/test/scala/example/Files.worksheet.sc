os.proc("git", "ls-files").call().out.string

val readme = os.pwd / "readme.md"
os.pwd
os.walk(os.pwd)
  .filter(_.ext == "md")
  .map(p => p -> os.read(p))
  .toMap
