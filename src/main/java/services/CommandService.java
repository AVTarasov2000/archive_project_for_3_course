package services;

import annotations.Command;
import interfaces.ArchiveAccessCommand;
import interfaces.Output;
import org.reflections8.Reflections;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class CommandService {

    private Map<String,ArchiveAccessCommand> commandMap = new HashMap<>();
    private Map <String, Object> arguments;


    public CommandService(ArchiveService archiveService, Output outputService, Map <String, Object> arguments) {
        this.arguments = arguments;
        Reflections reflections = new Reflections();
        Set<Class<?>> annotated = reflections.getTypesAnnotatedWith(Command.class);

        for(Class cls: annotated) {
            Command target = (Command) cls.getAnnotation(Command.class);
            try {
                ArchiveAccessCommand aac = (ArchiveAccessCommand) cls.newInstance();
                aac.setArchiveService(archiveService);
                aac.setArguments(arguments);
                aac.setOutputService(outputService);
                commandMap.put(target.name(), aac);
            } catch (InstantiationException | IllegalAccessException e) {
                e.printStackTrace();
            }
        }
    }

    public void setArgument(String name, Object arg){
        arguments.put(name, arg);
    }

//    public void setArguments(Pair <String, Object>... args) {
//        for (Pair<String, Object> p :
//                args) {
//            arguments.put(p.getLeft(), p.getRight());
//        }
//    }

    public void executeCommand(String name){
        commandMap.get(name).execute();
    }



}
