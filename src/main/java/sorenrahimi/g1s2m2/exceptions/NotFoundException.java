package sorenrahimi.g1s2m2.exceptions;

public class NotFoundException extends RuntimeException {
    public NotFoundException(int id){
        super("Elemento con id " + id + " non trovato!");
    }
}
