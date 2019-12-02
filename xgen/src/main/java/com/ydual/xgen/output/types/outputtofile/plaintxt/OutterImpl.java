package com.ydual.xgen.output.types.outputtofile.plaintxt;

import com.ydual.xgen.output.types.outputtofile.Outter;
import com.ydual.xgen.util.file.FileHelper;
/**
 * 文件读写
 * @author l8989
 *
 */
public class OutterImpl implements Outter {

	public OutterImpl() {
	}

	public boolean writeContent(String outPathAndFileName, String content) {
		FileHelper.writeFile(outPathAndFileName, content);
		return true;
	}
}
