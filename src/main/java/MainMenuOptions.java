import lombok.Getter;

@Getter
public enum MainMenuOptions {
        OPTION_DATA_ENTRY("Data Entry"),
        OPTION_SCHOOL_MANAGEMENT("School Management");

        private final String description;

        MainMenuOptions(String description) {
            this.description = description;
        }

}

