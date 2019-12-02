package com.ydual.xgen.output.types.outputtofile.plaintxt;

import com.ydual.xgen.output.types.outputtofile.AbstractFactory;
import com.ydual.xgen.output.types.outputtofile.GenOutPathPackages;
import com.ydual.xgen.output.types.outputtofile.Outter;
/**
 * 
 * @author l8989
 *
 */
public class PlainTxtFactory implements AbstractFactory {

	public PlainTxtFactory() {
	}

	public GenOutPathPackages createGenOutPathPackages() {
		return new GenOutPathPackageImpl();
	}

	public Outter createOutter() {
		return new OutterImpl();
	}
}
