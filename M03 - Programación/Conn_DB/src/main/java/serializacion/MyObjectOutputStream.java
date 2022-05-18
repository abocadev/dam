package serializacion;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;

public class MyObjectOutputStream extends ObjectOutputStream {
    // sobreescribir el metodo que crea la cabecera
    @Override
    protected void writeStreamHeader() throws IOException{
        // nada, no queremos que se escriba ninguna cabecera
    }

    // constructores
    public MyObjectOutputStream(OutputStream out) throws IOException {
        super(out);
    }

    public MyObjectOutputStream() throws IOException, SecurityException {
    }
    
    
}
