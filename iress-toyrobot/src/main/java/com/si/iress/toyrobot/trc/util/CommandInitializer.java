package com.si.iress.toyrobot.trc.util;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.si.iress.toyrobot.trc.model.TableArea;
/**
 * CommandInitializer - list all the valid commands to be executed.
 * @author sheenai
 *
 */
public class CommandInitializer {

	private final static Logger LOGGER = LogManager.getLogger(CommandInitializer.class);
	private List<String> validCommands = new ArrayList<>();
	private Stream<String> validStringCommands; 
	/**
	 * This will filter the valid commands from the file
	 * @param filePath
	 * @param tableArea
	 */
	public CommandInitializer(String filePath, TableArea tableArea) {
		try {
			File fileCmd = new File(filePath);
			if(fileCmd.exists()) {
				for(String command: Files.readAllLines(Paths.get(filePath))) {
					if(CommandValidator.validCommand(command, tableArea)) {
						validCommands.add(command);
					}
				}
				
				validCommands = CommandValidator.getValidCommandList(validCommands);
				if(validCommands!=null && !validCommands.isEmpty()) {
					validStringCommands=validCommands.stream();
				}else {
					LOGGER.info(MessageConstants.NO_VALID_COMMAND);
				}
			}else {
				LOGGER.info(MessageConstants.NO_VALID_COMMAND);
			}
		} catch (IOException e) {
			
			LOGGER.error(MessageConstants.NO_VALID_COMMAND);
		} 
	}

	public List<String> getValidCommands() {
		return validCommands;
	}

	public void setValidCommands(List<String> validCommands) {
		this.validCommands = validCommands;
	}

	public Stream<String> getValidStringCommands() {
		return validStringCommands;
	}

	public void setValidStringCommands(Stream<String> validStringCommands) {
		this.validStringCommands = validStringCommands;
	}
	
	
}
