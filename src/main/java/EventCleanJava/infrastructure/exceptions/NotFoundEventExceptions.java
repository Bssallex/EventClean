package EventCleanJava.infrastructure.exceptions;

public class NotFoundEventExceptions extends RuntimeException{

    public NotFoundEventExceptions(String message){
        super(message);
    }
}
