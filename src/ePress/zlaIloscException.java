package ePress;

public class zlaIloscException extends Exception{

    private int n;
    public zlaIloscException(String komunikat, int n){
        super(komunikat);
        this.n = n;
    }
}
