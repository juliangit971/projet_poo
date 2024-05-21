package com.theisland.windows;

import javax.swing.JFrame;

import com.theisland.enums.WindowNames;
import com.theisland.main.EnvironmentVariables;
import com.theisland.misc.EnhancedLog;

public class IntroWindow {


    private EnvironmentVariables env;


	public IntroWindow(EnvironmentVariables env) {
		this.env = env;
	}


    public void setView(JFrame frame) {
        
        // Reset frame to make it empty
        WindowUtils.resetWindow(frame);


        /**
         * Code for the window
        */


        // Revalidate to refresh the updated page
		frame.revalidate();

        
        // Log
        EnhancedLog.eventLogger("Window \"" + WindowNames.INTRO.getWindowName() + "\" set !" , "INFO");
    }
}
