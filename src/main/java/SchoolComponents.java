public enum SchoolComponents {

    TEACHERS ("teachers"),
    STUDENTS ("students"),
    COURSES ("courses");

    private String label;

    SchoolComponents(String label) {
        this.label = label;
    }

    @Override
    public String toString() {
        return label;
    }
}
