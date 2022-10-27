package mainclass2;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        CommadS s = new CommadS();
        s.commadReadProcess();
        WriteTxt wr = new WriteTxt();
        wr.writeTxt();
    }
    
}
