package com.timgapps.test.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.timgapps.test.Test;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.width = Test.V_WIDTH;
		config.height = Test.V_HEIGHT;
		new LwjglApplication(new Test(), config);
	}
}
