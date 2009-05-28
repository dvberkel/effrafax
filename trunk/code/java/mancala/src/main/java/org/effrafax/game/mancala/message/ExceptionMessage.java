/**
 * 
 */
package org.effrafax.game.mancala.message;

/**
 * @author dwanrooy
 *
 */
public enum ExceptionMessage {
	
	NON_NULL("argument should be non null."),
	NON_NEGATIVE("argument should be non-negative."),
	NON_POSITIVE("argument should be greater then zero."),
	NON_NULL_NEGATIVE(NON_NULL, NON_NEGATIVE),
	TO_FEW_STONES("heap does not contain enough stones."),
	NO_SUCH_OBJECT_FOR_KALAHA("there is no such a thing for a kalaha."),
	BOWL_NULL("bowl should be non-null."),
	BOWL_ASSIGNED("bowl is already assigned."),
	OWNER_NULL("owner should be non-null."),
	OWNER_ASSIGNED("owner is already assigned."),
	NOT_PLAYABLE("the bowl is not playable.");

	private String message = "an exception has occured";
	private ExceptionMessage[] exceptionMessages = {};	
	private boolean messageGenerated = false;
	
	ExceptionMessage(String message) {
		
		this.message = message;
	}
	
	private ExceptionMessage(ExceptionMessage... exceptionMessages) {
		
		this.exceptionMessages = exceptionMessages;
	}

	/* (non-Javadoc)
	 * @see java.lang.Enum#toString()
	 */
	@Override
	public String toString() {
		
		if (exceptionMessages.length != 0 && !messageGenerated) {
			
			message = exceptionMessages[0].toString();
			for (int index = 1; index < exceptionMessages.length; index++) {
				
				message += " " + exceptionMessages[index].toString();
			}
			
			messageGenerated = true;
		}
		
		return message;
	}
}
