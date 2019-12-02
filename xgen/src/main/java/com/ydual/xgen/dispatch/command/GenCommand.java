package com.ydual.xgen.dispatch.command;

/**
 * 命令接口
 * 如果调用的顺序比较复杂，或者是调用的过程本身并不是固定的
 * 或者调用的程序不只在本地，也有可能在远程
 * @author l8989
 *
 */
public interface GenCommand {

	public abstract void execute();
}
