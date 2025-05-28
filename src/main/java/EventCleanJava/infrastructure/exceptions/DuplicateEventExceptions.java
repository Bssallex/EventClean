package EventCleanJava.infrastructure.exceptions;

public class DuplicateEventExceptions extends RuntimeException{

    public DuplicateEventExceptions(String message){
        super(message);
    }
}
