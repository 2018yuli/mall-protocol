package com.ydual.xgen.dispatch.command;

public class CmdInvoker {

	private GenCommand cmd;

    public CmdInvoker()
    {
        cmd = null;
    }

    public void setCmd(GenCommand cmd)
    {
        this.cmd = cmd;
    }

    public void doCommand()
    {
        cmd.execute();
    }

    

}
