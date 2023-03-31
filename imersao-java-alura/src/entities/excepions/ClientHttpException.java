package entities.excepions;

public class ClientHttpException extends RuntimeException{

    public ClientHttpException(String msg){
        super(msg);
    }
}
