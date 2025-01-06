package org.pages.studentPage;

public enum OptionOfDisplayName {

    FIRST_SPACE_LAST("First name (Space) Last name (example: John Smith)"),
    LAST_SPACE_FIRST("Last name (Space) First name (example: Smith John)"),
    LAST_NOSPACE_FIRST("Last name(No space)First name (example: SmithJohn)");


    private final String option;

    OptionOfDisplayName(String option) {
        this.option = option;
    }

    @Override
    public String toString() {
        return this.option;
    }


}
