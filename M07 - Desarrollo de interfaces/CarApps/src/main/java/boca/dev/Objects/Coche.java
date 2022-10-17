package boca.dev.Objects;

public class Coche{
    String ModeloCoche;
    String TipoGasolina;
    int VelocidadMaxima;
    String ColorCoche;
    int YearCoche;
    String TipoMotor;
    int NumeroPuertas;
    String TipoMarchas;
    String DescripcionVehiculo;
    String RutaImagenCocheFuera;
    String RutaImagenCocheDentro;

    public Coche(String modeloCoche, String tipoGasolina, int velocidadMaxima, String colorCoche, int yearCoche, String tipoMotor, int numeroPuertas, String tipoMarchas, String descripcionVehiculo, String rutaImagenCocheFuera, String rutaImagenCocheDentro) {
        ModeloCoche = modeloCoche;
        TipoGasolina = tipoGasolina;
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

    public String getModeloCoche() {
        return ModeloCoche;
    }

    public void setModeloCoche(String modeloCoche) {
        ModeloCoche = modeloCoche;
    }

    public String getTipoGasolina() {
        return TipoGasolina;
    }

    public void setTipoGasolina(String tipoGasolina) {
        TipoGasolina = tipoGasolina;
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