package Mixed.enumtest;

public enum Level {

    HIGH(1){
        @Override
        public String normalize() {
            return HIGH.toString().toLowerCase();
        }
    },
    MEDIUM(2){
        public String normalize() {
            return MEDIUM.toString().toLowerCase() + MEDIUM.toString().toUpperCase();
        }
    },
    LOW(3){
        @Override
        public String normalize() {
            return LOW.toString().toUpperCase() + LOW.toString().toLowerCase();
        }
    };

    private int intValue;

    private Level(int intValue) {
        this.intValue = intValue;
    }

    public int getLevel() {
        return this.intValue;
    }

    public abstract String normalize();

}
