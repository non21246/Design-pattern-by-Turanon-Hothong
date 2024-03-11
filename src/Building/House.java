package Building;

//Building
public class House {
    private String foundation;
    private String structure;
    private String roof;
    private boolean furnished;

    private House(Builder builder) {
        this.foundation = builder.foundation;
        this.structure = builder.structure;
        this.roof = builder.roof;
        this.furnished = builder.furnished;
    }

    public static class Builder {
        private String foundation;
        private String structure;
        private String roof;
        private boolean furnished;

        public Builder foundation(String foundation) {
            this.foundation = foundation;
            return this;
        }

        public Builder structure(String structure) {
            this.structure = structure;
            return this;
        }

        public Builder roof(String roof) {
            this.roof = roof;
            return this;
        }

        public Builder furnished(boolean furnished) {
            this.furnished = furnished;
            return this;
        }

        public House build() {
            return new House(this);
        }
    }

    public String getFoundation() {
        return foundation;
    }

    public String getStructure() {
        return structure;
    }

    public String getRoof() {
        return roof;
    }

    public boolean isFurnished() {
        return furnished;
    }
}
