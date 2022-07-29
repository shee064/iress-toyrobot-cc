package com.si.iress.toyrobot.trc.util;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
/**
 * CommandEnum - Contains the list of valid command acceptable by the robot
 * @author sheenai
 *
 */
public enum CommandEnum {

	PLACE ("PLACE"), 
	MOVE ("MOVE"), 
	LEFT ("LEFT"), 
	RIGHT ("RIGHT"), 
	REPORT ("REPORT");
	
	private String value;
	
	CommandEnum(String value){
		this.value = value;
	}
	public static List<String> getCommandEnumList(){
		return Stream.of(CommandEnum.values()).filter(c -> !c.getValue().equals("PLACE"))
				.map(CommandEnum::name)
				.collect(Collectors.toList());
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	
}
