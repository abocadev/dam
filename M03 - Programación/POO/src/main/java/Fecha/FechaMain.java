package Fecha;

public class FechaMain {
    public static void main(String[] args) {
        Fecha FechaClass = new Fecha();
        String Fecha = "28-03-2022"; // Este es el orden: Dia-Mes-Año
        if(Fecha.equals("")){
            FechaClass.DiaSiguiente();
            Fecha = FechaClass.toString();
            System.out.println("La fecha es: " + Fecha);
        }else{
            String[] fechaPartida = Fecha.split("-");
            boolean salir = false;
            while(!salir){
                if(fechaPartida[0].charAt(0) == '0'){
                    String aux = fechaPartida[0];
                    fechaPartida[0] = "";
                    for(int i = 1; i<aux.length(); i++){
                        fechaPartida[0] += aux.charAt(i);
                    }
                } else if(fechaPartida[1].charAt(0) == '0'){
                    String aux = fechaPartida[1];
                    fechaPartida[1] = "";
                    for(int i = 1; i<aux.length(); i++){
                        fechaPartida[1] += aux.charAt(i);
                    }
                } else if(fechaPartida[2].charAt(0) == '0'){
                    String aux = fechaPartida[2];
                    fechaPartida[2] = "";
                    for(int i = 1; i<aux.length(); i++){
                        fechaPartida[2] += aux.charAt(i);
                    }
                } else{
                   salir = true;
                }
            }
            
            if(fechaPartida.length != 3){
                System.out.println("Solo puedes introducir 3 valores Dia-Mes-Año: ");
            }else if(fechaPartida[0].length() != 1 && fechaPartida[0].length() != 2){
                System.out.println("Solo puedes introducir dos digitos, ya que es el dia del mes");
            } else if(fechaPartida[1].length() != 1 && fechaPartida[1].length() != 2){
                System.out.println("Solo puedes introducir dos digitos, ya que es el mes del año");
            }else{
                int day = Integer.parseInt(fechaPartida[0]);
                boolean correcto = true;
                if(day < 1 || day > 31){
                    System.out.println("Tienes que insertar un dia en forma de entero entre 1 y 31");
                    correcto = false;
                }
                int mes = Integer.parseInt(fechaPartida[1]);
                if(mes < 1 || mes > 12){
                    System.out.println("Tienes que insertar un mes en forma de entero entre 1 y 12");
                    correcto = false;
                }
                int year = Integer.parseInt(fechaPartida[2]);
                if(correcto){
                    FechaClass = new Fecha(day, mes, year);
                    boolean fechaCorrecta = FechaClass.ComprobarFecha();
                    if(!fechaCorrecta){
                        FechaClass.DiaSiguiente();
                        Fecha = FechaClass.toString();
                    }
                    System.out.println("La fecha es: " + Fecha);
                }
            }
        }
    }
}

