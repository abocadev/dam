INSERT INTO Mesa(nombre) VALUES ('Mesa 1')
INSERT INTO Mesa(nombre) VALUES ('Mesa 2')

INSERT INTO TipoIva(Nombre, PorcentajeIva) VALUES ('Normal', 21)
INSERT INTO TipoIva(Nombre, PorcentajeIva) VALUES ('Reducido', 10)

INSERT INTO Articulo(Nombre, TipoIvaId, PrecioFinal, Ventas) VALUES ('Cafe', 1, 1.10, 0)
INSERT INTO Articulo(Nombre, TipoIvaId, PrecioFinal, Ventas) VALUES ('Cortado', 1, 1.20, 0)
INSERT INTO Articulo(Nombre, TipoIvaId, PrecioFinal, Ventas) VALUES ('Cafe con leche', 1, 1.50, 0)
INSERT INTO Articulo(Nombre, TipoIvaId, PrecioFinal, Ventas) VALUES ('Boca lomo bacon queso', 1, 10, 0)
INSERT INTO Articulo(Nombre, TipoIvaId, PrecioFinal, Ventas) VALUES ('Pechuga de pollo a la planza con arroz blanco', 1, 1000, 0)