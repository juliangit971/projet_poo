package com.theisland.windows;

import com.theisland.main.EnvironmentVariables;

public class WindowLibrary {

    private EnvironmentVariables env;
    private IntroWindow introWindow;


    public WindowLibrary(EnvironmentVariables env) {
        this.env = env;
        this.introWindow = new IntroWindow(this.env);
    }


    // Getters & Setters

    public void showIntroWindow(ProgramWindow programWindow) {
        introWindow.setView(programWindow.getFrame());
    }
}
