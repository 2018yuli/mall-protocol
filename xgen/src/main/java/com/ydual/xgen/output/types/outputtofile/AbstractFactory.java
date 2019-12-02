package com.ydual.xgen.output.types.outputtofile;
/**
 * 输出抽象工厂
 * @author l8989
 *
 */
public interface AbstractFactory {

	/**
	 * 输出路径组件（做作）
	 * @return
	 */
	public abstract GenOutPathPackages createGenOutPathPackages();

	/**
	 * 输出组件
	 * @return
	 */
	public abstract Outter createOutter();

}
