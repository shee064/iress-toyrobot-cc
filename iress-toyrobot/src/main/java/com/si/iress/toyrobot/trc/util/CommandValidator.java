package com.si.iress.toyrobot.trc.util;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.si.iress.toyrobot.trc.model.TableArea;
/**
 * CommandValidator - validates the command being issued to the robot
 * @author sheenai
 *
 */
public class CommandValidator {

	private static final Pattern placePattern =  Pattern.compile("PLACE (\\d+),(\\d+),([A-Z]+)$");
	private static final List<String> commandEnumList = CommandEnum.getCommandEnumList(); 
	private static final List<String> directionEnumList = DirectionEnum.getDerictionList();
	private static Matcher placeCommandMatcher;
	/**
	 * This method checks the command if in valid format or if the position specified is within the range of table area
	 * @param command
	 * @param tableArea
	 * @return
	 */
	public static boolean validCommand(String command, TableArea tableArea) {
		placeCommandMatcher = placePattern.matcher(command);
		if ((placeCommandMatcher.matches() && validateIfWithinTableRange(tableArea, Integer.valueOf(placeCommandMatcher.group(1)), 
						Integer.valueOf(placeCommandMatcher.group(2))) && validateDirection(placeCommandMatcher.group(3))) ||
				commandEnumList.contains(command)) {
			return true;
		}	
		return false;
		
	}
	/**
	 * This method removes the command until valid place command was read
	 * @param commandList
	 * @return
	 */
	public static List<String> getValidCommandList(List<String> commandList){
		int firstCommand = 0;
		while(!commandList.isEmpty()) {
			if(!(commandList.get(firstCommand).contains(CommandEnum.PLACE.getValue()))){
				commandList.remove(firstCommand);			
				
			}else {
				placeCommandMatcher = placePattern.matcher(commandList.get(firstCommand));
				if(placeCommandMatcher.matches() && validateDirection(placeCommandMatcher.group(3))) {
					return commandList;
				}else {
					commandList.remove(firstCommand);
					
				}
			}
		};
		
		
		return null;
	}
	
	/**
	 * This method validates the position if valid against the table area defined.
	 * @param tableArea
	 * @param xPosition
	 * @param yPosition
	 * @return
	 */
	public static boolean validateIfWithinTableRange(TableArea tableArea,int xPosition, int yPosition) {
		
		if((xPosition >= 0 && xPosition <= tableArea.getUnitL()) && 
				(yPosition >=0 && yPosition <= tableArea.getUnitW())) {
			return true;
		}
		return false;
	}

	/**
	 * This method checks if the direction provided on the command is valid
	 * @param direction
	 * @return
	 */
	public static boolean validateDirection(String direction) {
		return directionEnumList.contains(direction);
	}
	
	/**
	 * This returns the correct pattern for PLACE command
	 * @return
	 */
	public static Pattern getPlacePattern() {
		return placePattern;
	}

}
