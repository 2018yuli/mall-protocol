package com.ydual.xgen.util.readxml;
/**
 * 临时保存持久化状态
 * @author l8989
 *
 */
public class ParseCaretaker {

	private static ParseCaretaker taker = new ParseCaretaker();
	private ParseMemento memento;

	private ParseCaretaker() {
		memento = null;
	}

	public static ParseCaretaker getInstance() {
		return taker;
	}

	public void saveMemento(ParseMemento memento) {
		this.memento = memento;
	}

	public ParseMemento retriveMemento() {
		return memento;
	}

}
