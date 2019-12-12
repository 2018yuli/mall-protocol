package com.ydual.mall.common.exception;

public class NewBeeMallException extends RuntimeException {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1852406788645244974L;

	public NewBeeMallException() {
    }

    public NewBeeMallException(String message) {
        super(message);
    }

    /**
     * 丢出一个异常
     *
     * @param message
     */
    public static void fail(String message) {
        throw new NewBeeMallException(message);
    }

}
