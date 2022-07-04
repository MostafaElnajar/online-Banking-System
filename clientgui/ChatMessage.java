/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clientgui;

/**
 *
 * @author wessa
 */
import java.io.*;

public class ChatMessage implements Serializable {

	protected static final long serialVersionUID = 1L;

	static final int  MESSAGE = 1, LOGOUT = 2;
	private int type;
	private String message;
	

	ChatMessage(int type, String message) {
		this.type = type;
		this.message = message;
	}
	

	int getType() {
		return type;
	}
	String getMessage() {
		return message;
	}
}

