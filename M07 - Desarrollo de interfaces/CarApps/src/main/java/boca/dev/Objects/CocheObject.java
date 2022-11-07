package boca.dev.Objects;

public class CocheObject{
    
    // Objeto de coche
    String MarcaCoche, ModeloCoche, ColorCoche, TipoMotor, TipoMarchas, DescripcionVehiculo, RutaImagenCocheFuera, RutaImagenCocheDentro;
    int VelocidadMaxima, YearCoche, NumeroPuertas;

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

    public String getMarcaCoche(){return MarcaCoche;}
    public String getModeloCoche() { return ModeloCoche; }
    public String getColorCoche() { return ColorCoche; }
    public String getTipoMotor() { return TipoMotor; }
    public String getTipoMarchas() { return TipoMarchas; }
    public String getDescripcionVehiculo() { return DescripcionVehiculo; }
    public String getRutaImagenCocheFuera() { return RutaImagenCocheFuera; }
    public String getRutaImagenCocheDentro() { return RutaImagenCocheDentro; }
    public void setMarcaCoche(String marca){ this.MarcaCoche = marca; }
    public void setModeloCoche(String modeloCoche) { ModeloCoche = modeloCoche;}
    public void setVelocidadMaxima(int velocidadMaxima) { VelocidadMaxima = velocidadMaxima; }
    public void setColorCoche(String colorCoche) { ColorCoche = colorCoche; }
    public void setYearCoche(int yearCoche) { YearCoche = yearCoche; }
    public void setTipoMotor(String tipoMotor) { TipoMotor = tipoMotor; }
    public void setNumeroPuertas(int numeroPuertas) { NumeroPuertas = numeroPuertas; }
    public void setTipoMarchas(String tipoMarchas) { TipoMarchas = tipoMarchas; }
    public void setDescripcionVehiculo(String descripcionVehiculo) { DescripcionVehiculo = descripcionVehiculo; }
    public void setRutaImagenCocheFuera(String rutaImagenCocheFuera) { RutaImagenCocheFuera = rutaImagenCocheFuera; }
    public void setRutaImagenCocheDentro(String rutaImagenCocheDentro) { RutaImagenCocheDentro = rutaImagenCocheDentro; }
    public int getVelocidadMaxima() { return VelocidadMaxima; }
    public int getYearCoche() { return YearCoche; }
    public int getNumeroPuertas() { return NumeroPuertas; }
}