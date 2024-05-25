package com.theisland.windows;

import com.theisland.main.EnvironmentVariables;

public class WindowLibrary {

    private EnvironmentVariables env;
    // private TestWindow testWindow;
    private MainMenuWindow mainMenuWindow;


    public WindowLibrary(EnvironmentVariables env) {
        this.env = env;
        //this.introWindow = new TestWindow(this.env);
        this.mainMenuWindow = new MainMenuWindow(this.env);
    }


    // Getters & Setters

    public void showMainMenuWindow(ProgramWindow programWindow) {
        mainMenuWindow.setView(programWindow.getFrame());
    }
}
