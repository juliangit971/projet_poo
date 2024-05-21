package com.theisland.main;

import com.theisland.enums.WindowNames;

public class EnvironmentVariables {

    // To know if it's necessary to center the window 
    private Boolean resetWindowPosition;
    private WindowNames currentWindow;
    private Boolean refreshWindow;



    public void initVariables() {
        this.resetWindowPosition = true;
        this.currentWindow = WindowNames.INTRO;
        this.refreshWindow = true;
    }


    // Getters & Setters


    public Boolean getResetWindowPosition() {
        return resetWindowPosition;
    }
    public void setResetWindowPosition(Boolean resetWindowPosition) {
        this.resetWindowPosition = resetWindowPosition;
    }

    public WindowNames getCurrentWindow() {
        return currentWindow;
    }
    public void setCurrentWindow(WindowNames currentWindow) {
        this.currentWindow = currentWindow;
    }

    public Boolean getRefreshWindow() {
        return refreshWindow;
    }
    public void setRefreshWindow(Boolean refreshWindow) {
        this.refreshWindow = refreshWindow;
    }
}
