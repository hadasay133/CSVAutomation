package org.pages.mainPage;

public enum HrefOfMainPage {


    STUDENT("Student"),
    TEACHING_ASSISTANT("Teaching Assistant"),
    INSTRUCTOR("Instructor");


    private final String href;

    HrefOfMainPage(String href) {
        this.href = href;
    }

    @Override
    public String toString() {
        return this.href;
    }
}
