package throwable;

public class InvalidArgumentsMapException extends Exception{
    @Override
    public String getMessage() {
        return super.getMessage()+"\n invalid content in map of arguments, wrong types or null";
    }
}
