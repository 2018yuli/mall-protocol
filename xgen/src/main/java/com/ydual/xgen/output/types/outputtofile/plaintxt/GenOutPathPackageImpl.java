package com.ydual.xgen.output.types.outputtofile.plaintxt;

import com.ydual.xgen.genconf.constants.ExpressionEnum;
import com.ydual.xgen.genconf.vo.ExtendConfModel;
import com.ydual.xgen.genconf.vo.ModuleConfModel;
import com.ydual.xgen.mediator.CoreMediator;
import com.ydual.xgen.output.types.outputtofile.GenOutPathPackages;
import com.ydual.xgen.util.file.FileHelper;
/**
 * 文件路径确定
 * @author l8989
 *
 */
public class GenOutPathPackageImpl implements GenOutPathPackages {

    public GenOutPathPackageImpl()
    {
    }

    public boolean genPackages(ModuleConfModel moduleConf, String genTypeId)
    {
        FileHelper.genDir(getDirPath(moduleConf, genTypeId));
        return true;
    }

    private String getDirPath(ModuleConfModel moduleConf, String genTypeId)
    {
        String codeOutPath = ((ExtendConfModel)moduleConf.getMapExtends().get("codeOutPath")).getValue();
        String relativePath = (String)CoreMediator.getInstance().getGenTypeParams(moduleConf, genTypeId).get("relativePath");
        String packagePath = ((ExtendConfModel)moduleConf.getMapExtends().get("modulePackge")).getValue();
        String dirPackages = (new StringBuilder(String.valueOf(codeOutPath))).append(ExpressionEnum.dot.getExpr()).append(packagePath).append(ExpressionEnum.dot.getExpr()).append(relativePath).toString();
        String packages = dirPackages.replace(ExpressionEnum.dot.getExpr(), ExpressionEnum.separator.getExpr());
        return packages;
    }

    public String getOutPathAndFileName(ModuleConfModel moduleConf, String genTypeId)
    {
        String preName = (String)CoreMediator.getInstance().getGenTypeParams(moduleConf, genTypeId).get("preGenFileName");
        String afterName = (String)CoreMediator.getInstance().getGenTypeParams(moduleConf, genTypeId).get("afterGenFileName");
        String moduleNameSuperCase = ((ExtendConfModel)moduleConf.getMapExtends().get("moduleNameSuperCase")).getValue();
        String retName = (new StringBuilder(String.valueOf(getDirPath(moduleConf, genTypeId)))).append(ExpressionEnum.separator.getExpr()).toString();
        if(preName.equalsIgnoreCase("use-after"))
            retName = (new StringBuilder(String.valueOf(retName))).append(afterName).toString();
        else
            retName = (new StringBuilder(String.valueOf(retName))).append(preName).append(moduleNameSuperCase).append(afterName).toString();
        return retName;
    }
}
