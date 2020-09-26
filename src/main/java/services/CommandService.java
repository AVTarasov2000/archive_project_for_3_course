package services;

import annotations.Command;
import interfaces.ArchiveAccessCommand;
import interfaces.Output;
import org.reflections8.Reflections;
import org.reflections8.scanners.TypeAnnotationsScanner;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class CommandService {

    private Map<String,ArchiveAccessCommand> commandMap = new HashMap <String, ArchiveAccessCommand>();
    private Map <String, Object> arguments;


    public CommandService(ArchiveService archiveService, Output outputService, Map <String, Object> arguments) {
        this.arguments = arguments;
        Reflections reflections = new Reflections();
        Set<Class<?>> annotated = reflections.getTypesAnnotatedWith(Command.class);

        for(Class cls: annotated) {
            Command target = (Command) cls.getAnnotation(Command.class);
            System.out.println(cls);
//            commandMap.put(target.name(), cls.getConstructor(archiveService,outputService,arguments ));
        }

    }




}
