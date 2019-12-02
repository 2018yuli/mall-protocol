package com.ydual.xgen.output.types;

import java.util.Observable;

import com.ydual.xgen.mediator.CoreMediator;
import com.ydual.xgen.output.GenOutputEbi;
import com.ydual.xgen.output.types.outputtofile.AbstractFactory;
import com.ydual.xgen.output.types.outputtofile.plaintxt.PlainTxtFactory;

/**
 * 
 * @author l8989
 *
 */
public class OutputToFile implements GenOutputEbi {

	public OutputToFile() {
	}

	public void update(Observable o, Object obj) {
		String content = (new StringBuilder()).append(obj).toString();
		AbstractFactory af = new PlainTxtFactory();
		af.createGenOutPathPackages().genPackages(CoreMediator.getInstance().getObserverModuleConf(o),
				CoreMediator.getInstance().getObserverGenTypeId(o));
		String outPathAndFileName = af.createGenOutPathPackages().getOutPathAndFileName(
				CoreMediator.getInstance().getObserverModuleConf(o),
				CoreMediator.getInstance().getObserverGenTypeId(o));
		af.createOutter().writeContent(outPathAndFileName, content);
	}
}
