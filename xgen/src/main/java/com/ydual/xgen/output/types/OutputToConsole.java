package com.ydual.xgen.output.types;

import java.util.Observable;

import com.ydual.xgen.output.GenOutputEbi;

public class OutputToConsole implements GenOutputEbi {

	public OutputToConsole() {
	}

	public void update(Observable o, Object obj) {
		String content = (new StringBuilder()).append(obj).toString();
		System.out.println((new StringBuilder("now Content=")).append(content).toString());
	}
}
