public enum Colors {
    GREEN("зелёное"),
    RED("красное"),
    YELLOW("жёлтое"),
    WHITE("белое");

    private String name;

    Colors(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}
