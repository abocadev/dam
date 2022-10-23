package boca.dev.Objects;

public class CocheObject{
    String MarcaCoche;
    String ModeloCoche;
    int VelocidadMaxima;
    String ColorCoche;
    int YearCoche;
    String TipoMotor;
    int NumeroPuertas;
    String TipoMarchas;
    String DescripcionVehiculo;
    String RutaImagenCocheFuera;
    String RutaImagenCocheDentro;

    public CocheObject(String marcaCoche, String modeloCoche, int velocidadMaxima, String colorCoche, int yearCoche, String tipoMotor, int numeroPuertas, String tipoMarchas, String descripcionVehiculo, String rutaImagenCocheFuera, String rutaImagenCocheDentro) {
        MarcaCoche = marcaCoche;
        ModeloCoche = modeloCoche;
        VelocidadMaxima = velocidadMaxima;
        ColorCoche = colorCoche;
        YearCoche = yearCoche;
        TipoMotor = tipoMotor;
        NumeroPuertas = numeroPuertas;
        TipoMarchas = tipoMarchas;
        DescripcionVehiculo = descripcionVehiculo;
        RutaImagenCocheFuera = rutaImagenCocheFuera;
        RutaImagenCocheDentro = rutaImagenCocheDentro;
    }

    public String getMarcaCoche(){
        return MarcaCoche;
    }
    
    public void setMarcaCoche(String marca){
        this.MarcaCoche = marca;
    }
    public String getModeloCoche() {
        return ModeloCoche;
    }

    public void setModeloCoche(String modeloCoche) {
        ModeloCoche = modeloCoche;
    }
    
    public int getVelocidadMaxima() {
        return VelocidadMaxima;
    }

    public void setVelocidadMaxima(int velocidadMaxima) {
        VelocidadMaxima = velocidadMaxima;
    }

    public String getColorCoche() {
        return ColorCoche;
    }

    public void setColorCoche(String colorCoche) {
        ColorCoche = colorCoche;
    }

    public int getYearCoche() {
        return YearCoche;
    }

    public void setYearCoche(int yearCoche) {
        YearCoche = yearCoche;
    }

    public String getTipoMotor() {
        return TipoMotor;
    }

    public void setTipoMotor(String tipoMotor) {
        TipoMotor = tipoMotor;
    }

    public int getNumeroPuertas() {
        return NumeroPuertas;
    }

    public void setNumeroPuertas(int numeroPuertas) {
        NumeroPuertas = numeroPuertas;
    }

    public String getTipoMarchas() {
        return TipoMarchas;
    }

    public void setTipoMarchas(String tipoMarchas) {
        TipoMarchas = tipoMarchas;
    }

    public String getDescripcionVehiculo() {
        return DescripcionVehiculo;
    }

    public void setDescripcionVehiculo(String descripcionVehiculo) {
        DescripcionVehiculo = descripcionVehiculo;
    }

    public String getRutaImagenCocheFuera() {
        return RutaImagenCocheFuera;
    }

    public void setRutaImagenCocheFuera(String rutaImagenCocheFuera) {
        RutaImagenCocheFuera = rutaImagenCocheFuera;
    }

    public String getRutaImagenCocheDentro() {
        return RutaImagenCocheDentro;
    }

    public void setRutaImagenCocheDentro(String rutaImagenCocheDentro) {
        RutaImagenCocheDentro = rutaImagenCocheDentro;
    }
}