package com.theisland.windows;

import javax.swing.JFrame;

import com.theisland.enums.WindowNames;
// import com.theisland.main.EnvironmentVariables;
import com.theisland.misc.EnhancedLog;

public class TestWindow {


    // private EnvironmentVariables env;


	// public TestWindow(EnvironmentVariables env) {
	// 	this.env = env;
	// }


    public void setView(JFrame frame) {
        
        // Reset frame to make it empty
        WindowUtils.resetWindow(frame);

        // Frame Settings
        frame.setTitle(WindowNames.MAIN_MENU.getWindowName());
        frame.setSize(830, 850);


        /**
         * Code for the window
        */


        // Revalidate to refresh the updated page
		frame.revalidate();

        
        // Log
        EnhancedLog.eventLogger("Window \"" + WindowNames.DEFAULT.getWindowName() + "\" set !" , "INFO");
    }
}
