package example.estructurada;
public final class PrimaEmpleat {
    public static void main(String[] args) {
        String nom = "Elvira";
        String directiu = "S";
        int antiguitat = 11;
        int p = 0;
        final int[] prima = {600, 150, 400, 100};
        if(antiguitat >= 0 && antiguitat<1000){
            if(antiguitat > 12){
                if(directiu == "S"){
                    p = prima[0];
                }else if(directiu == "N"){
                    p = prima[1];
                }else{
                    System.out.println("El carrec ha de ser 'S' o 'N'");
                }
            }else{
                if (directiu == "S") {
                    p = prima[2];
                } else if (directiu == "N") {
                    p = prima[3];
                } else {
                    System.out.println("El carrec ha de ser 'S' o 'N'");
                }
            }
            if(p!=0){
                System.out.println("La prima que li correspon a " + nom + " es de " + p + " Euros");
            }
        }else{
            System.out.println("La antiguitat ha de  un nombre entre 0 i 999");
        }
    }
}