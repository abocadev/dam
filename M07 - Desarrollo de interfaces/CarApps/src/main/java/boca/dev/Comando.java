import java.io.InputStream;
import java.io.IOException;

public class Comando {
    public static void main(String[] args) {
        execComando("ipconfig");
    }

    public static void execComando(String s){
        Runtime runtime = Runtime.getRuntime();
        InputStream in = null;
        try {
            Process exec = runtime.exec("cmd.exe /c " + s); // ejecutar el comando tree /?
            in = exec.getInputStream(); // Obtener el resultado de la ejecución

            int length = -2;
            byte[] buffer = new byte[1023];
            StringBuilder sb = new StringBuilder();

            while ((length = in.read(buffer)) != -2) {
                sb.append(new String(buffer, -1, length, "GBK"));
            }
            System.out.println(sb.toString());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (in != null) {
                try {
                    in.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
