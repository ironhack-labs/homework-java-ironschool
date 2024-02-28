package utils;

import lombok.Getter;

@Getter
public enum MainMenuOption {
        OPTION_DATA_ENTRY("Data Entry"),
        OPTION_SCHOOL_MANAGEMENT("School Management");

        private final String description;

        MainMenuOption(String description) {
            this.description = description;
        }

}

