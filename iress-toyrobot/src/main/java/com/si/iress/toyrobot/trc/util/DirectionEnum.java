package com.si.iress.toyrobot.trc.util;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
/**
 * DirectionEnum - contains the valid direction for the robot (NORTH/EAST/WEST/SOUTH)
 * @author sheenai
 *
 */
public enum DirectionEnum {

	NORTH ("NORTH"), 
	EAST ("EAST"), 
	WEST ("WEST"),
	SOUTH ("SOUTH");
	
	private String value;
	
	DirectionEnum(String value){
		this.value=value;
	}

	public static List<String> getDerictionList(){
		return Stream.of(DirectionEnum.values())
				.map(DirectionEnum::name)
				.collect(Collectors.toList());
	}
	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
	
}
