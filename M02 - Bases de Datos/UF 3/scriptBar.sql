USE [master]
GO
drop database bar
go
/****** Object:  Database [Bar]    Script Date: 24/02/2022 10:52:20 ******/
CREATE DATABASE [Bar] ON  PRIMARY 
( NAME = N'Bar', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL10_50.SQLSERVER\MSSQL\DATA\Bar.mdf' , SIZE = 2304KB , MAXSIZE = UNLIMITED, FILEGROWTH = 1024KB )
 LOG ON 
( NAME = N'Bar_log', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL10_50.SQLSERVER\MSSQL\DATA\Bar_log.LDF' , SIZE = 576KB , MAXSIZE = 2048GB , FILEGROWTH = 10%)
GO
ALTER DATABASE [Bar] SET COMPATIBILITY_LEVEL = 100
GO
IF (1 = FULLTEXTSERVICEPROPERTY('IsFullTextInstalled'))
begin
EXEC [Bar].[dbo].[sp_fulltext_database] @action = 'enable'
end
GO
ALTER DATABASE [Bar] SET ANSI_NULL_DEFAULT OFF 
GO
ALTER DATABASE [Bar] SET ANSI_NULLS OFF 
GO
ALTER DATABASE [Bar] SET ANSI_PADDING OFF 
GO
ALTER DATABASE [Bar] SET ANSI_WARNINGS OFF 
GO
ALTER DATABASE [Bar] SET ARITHABORT OFF 
GO
ALTER DATABASE [Bar] SET AUTO_CLOSE ON 
GO
ALTER DATABASE [Bar] SET AUTO_SHRINK OFF 
GO
ALTER DATABASE [Bar] SET AUTO_UPDATE_STATISTICS ON 
GO
ALTER DATABASE [Bar] SET CURSOR_CLOSE_ON_COMMIT OFF 
GO
ALTER DATABASE [Bar] SET CURSOR_DEFAULT  GLOBAL 
GO
ALTER DATABASE [Bar] SET CONCAT_NULL_YIELDS_NULL OFF 
GO
ALTER DATABASE [Bar] SET NUMERIC_ROUNDABORT OFF 
GO
ALTER DATABASE [Bar] SET QUOTED_IDENTIFIER OFF 
GO
ALTER DATABASE [Bar] SET RECURSIVE_TRIGGERS OFF 
GO
ALTER DATABASE [Bar] SET  ENABLE_BROKER 
GO
ALTER DATABASE [Bar] SET AUTO_UPDATE_STATISTICS_ASYNC OFF 
GO
ALTER DATABASE [Bar] SET DATE_CORRELATION_OPTIMIZATION OFF 
GO
ALTER DATABASE [Bar] SET TRUSTWORTHY OFF 
GO
ALTER DATABASE [Bar] SET ALLOW_SNAPSHOT_ISOLATION OFF 
GO
ALTER DATABASE [Bar] SET PARAMETERIZATION SIMPLE 
GO
ALTER DATABASE [Bar] SET READ_COMMITTED_SNAPSHOT OFF 
GO
ALTER DATABASE [Bar] SET HONOR_BROKER_PRIORITY OFF 
GO
ALTER DATABASE [Bar] SET RECOVERY SIMPLE 
GO
ALTER DATABASE [Bar] SET  MULTI_USER 
GO
ALTER DATABASE [Bar] SET PAGE_VERIFY CHECKSUM  
GO
ALTER DATABASE [Bar] SET DB_CHAINING OFF 
GO
USE [Bar]
GO
/****** Object:  UserDefinedFunction [dbo].[ImporteIva]    Script Date: 24/02/2022 10:52:20 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO

create FUNCTION [dbo].[ImporteIva]
(
	@TicketId int
)
RETURNS decimal(18,2)
AS
BEGIN
	-- Declare the return variable here
	DECLARE @ret decimal(18,2)

	-- Add the T-SQL statements to compute the return value here
	SELECT @ret = sum(ImporteIva) from linea where TicketId = @TicketId

	-- Return the result of the function
	RETURN @ret

END
GO
/****** Object:  UserDefinedFunction [dbo].[ImporteSinIva]    Script Date: 24/02/2022 10:52:20 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO

create FUNCTION [dbo].[ImporteSinIva]
(
	@TicketId int
)
RETURNS decimal(18,2)
AS
BEGIN
	-- Declare the return variable here
	DECLARE @ret decimal(18,2)

	-- Add the T-SQL statements to compute the return value here
	SELECT @ret = sum(ImporteSinIva) from linea where TicketId = @TicketId

	-- Return the result of the function
	RETURN @ret

END
GO
/****** Object:  UserDefinedFunction [dbo].[PorcentajeIva]    Script Date: 24/02/2022 10:52:20 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO

-- =============================================
create FUNCTION [dbo].[PorcentajeIva] 
(
	@TipoIvaId int
)
RETURNS decimal(18,2)
AS
BEGIN
	-- Declare the return variable here
	DECLARE @ret decimal(18,2)

	-- Add the T-SQL statements to compute the return value here
	select @ret = PorcentajeIva from tipoIva where id = @TipoIvaId

	-- Return the result of the function
	RETURN @ret

END
GO
/****** Object:  UserDefinedFunction [dbo].[TicketAbierto]    Script Date: 24/02/2022 10:52:20 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO

-- =============================================
CREATE FUNCTION [dbo].[TicketAbierto] 
(
	@MesaId int
)
RETURNS bit
AS
BEGIN
	-- Declare the return variable here
	DECLARE @ret bit

	-- Add the T-SQL statements to compute the return value here
	select @ret = count(*) from Ticket where MesaId = @MesaId and FechaCierre is null 

	-- Return the result of the function
	RETURN @ret

END
GO
/****** Object:  UserDefinedFunction [dbo].[TotalTicket]    Script Date: 24/02/2022 10:52:20 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO

CREATE FUNCTION [dbo].[TotalTicket]
(
	@TicketId int
)
RETURNS decimal(18,2)
AS
BEGIN
	-- Declare the return variable here
	DECLARE @ret decimal(18,2)

	-- Add the T-SQL statements to compute the return value here
	SELECT @ret = sum(TotalLinea) from linea where TicketId = @TicketId

	-- Return the result of the function
	RETURN @ret

END
GO
/****** Object:  Table [dbo].[Articulo]    Script Date: 24/02/2022 10:52:20 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Articulo](
	[Id] [int] IDENTITY(1,1) NOT NULL,
	[Nombre] [nvarchar](50) NOT NULL,
	[TipoIvaId] [int] NOT NULL,
	[PrecioFinal] [decimal](18, 2) NOT NULL,
	[Ventas] [int] NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[Id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Linea]    Script Date: 24/02/2022 10:52:20 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Linea](
	[Id] [int] IDENTITY(1,1) NOT NULL,
	[TicketId] [int] NOT NULL,
	[ArticuloId] [int] NOT NULL,
	[Nombre] [nvarchar](50) NOT NULL,
	[TipoIvaId] [int] NOT NULL,
	[PrecioFinal] [decimal](18, 2) NOT NULL,
	[Unidades] [int] NOT NULL,
	[TotalLinea]  AS ([PrecioFinal]*[Unidades]),
	[PorcentajeIva]  AS ([dbo].[PorcentajeIva]([TipoIvaId])),
	[ImporteIva]  AS ([PrecioFinal]*[Unidades]-([PrecioFinal]*[Unidades])/((1)+[dbo].[PorcentajeIva]([TipoIvaId])/(100))),
	[ImporteSinIva]  AS (([PrecioFinal]*[Unidades])/((1)+[dbo].[PorcentajeIva]([TipoIvaId])/(100))),
PRIMARY KEY CLUSTERED 
(
	[Id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Mesa]    Script Date: 24/02/2022 10:52:20 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Mesa](
	[Id] [int] IDENTITY(1,1) NOT NULL,
	[Nombre] [nvarchar](50) NOT NULL,
	[TicketAbierto]  AS ([dbo].[TicketAbierto]([Id])),
PRIMARY KEY CLUSTERED 
(
	[Id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Ticket]    Script Date: 24/02/2022 10:52:20 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Ticket](
	[Id] [int] IDENTITY(1,1) NOT NULL,
	[MesaId] [int] NOT NULL,
	[FechaCreacion] [datetime] NULL,
	[FechaCierre] [datetime] NULL,
	[TotalTicket]  AS ([dbo].[TotalTicket]([Id])),
	[ImporteIva]  AS ([dbo].[ImporteIva]([Id])),
	[ImporteSinIva]  AS ([dbo].[ImporteSinIva]([Id])),
PRIMARY KEY CLUSTERED 
(
	[Id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[TipoIva]    Script Date: 24/02/2022 10:52:20 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[TipoIva](
	[Id] [int] IDENTITY(1,1) NOT NULL,
	[Nombre] [nvarchar](50) NOT NULL,
	[PorcentajeIva] [decimal](18, 2) NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[Id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Index [IX_Linea]    Script Date: 24/02/2022 10:52:21 ******/
CREATE NONCLUSTERED INDEX [IX_Linea] ON [dbo].[Linea]
(
	[ArticuloId] ASC,
	[TicketId] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, SORT_IN_TEMPDB = OFF, DROP_EXISTING = OFF, ONLINE = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
GO
/****** Object:  Index [IX_Ticket]    Script Date: 24/02/2022 10:52:21 ******/
CREATE NONCLUSTERED INDEX [IX_Ticket] ON [dbo].[Ticket]
(
	[MesaId] ASC,
	[FechaCierre] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, SORT_IN_TEMPDB = OFF, DROP_EXISTING = OFF, ONLINE = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
GO
ALTER TABLE [dbo].[Articulo] ADD  DEFAULT ((0)) FOR [Ventas]
GO
ALTER TABLE [dbo].[Linea] ADD  DEFAULT ((0)) FOR [Unidades]
GO
ALTER TABLE [dbo].[Ticket] ADD  DEFAULT (getdate()) FOR [FechaCreacion]
GO
ALTER TABLE [dbo].[Articulo]  WITH CHECK ADD  CONSTRAINT [FK_Articulo_TipoIva] FOREIGN KEY([TipoIvaId])
REFERENCES [dbo].[TipoIva] ([Id])
GO
ALTER TABLE [dbo].[Articulo] CHECK CONSTRAINT [FK_Articulo_TipoIva]
GO
ALTER TABLE [dbo].[Linea]  WITH CHECK ADD  CONSTRAINT [FK_Linea_Articulo] FOREIGN KEY([ArticuloId])
REFERENCES [dbo].[Articulo] ([Id])
GO
ALTER TABLE [dbo].[Linea] CHECK CONSTRAINT [FK_Linea_Articulo]
GO
ALTER TABLE [dbo].[Linea]  WITH CHECK ADD  CONSTRAINT [FK_Linea_Ticket] FOREIGN KEY([TicketId])
REFERENCES [dbo].[Ticket] ([Id])
GO
ALTER TABLE [dbo].[Linea] CHECK CONSTRAINT [FK_Linea_Ticket]
GO
ALTER TABLE [dbo].[Ticket]  WITH CHECK ADD  CONSTRAINT [FK_Ticket_Mesa] FOREIGN KEY([MesaId])
REFERENCES [dbo].[Mesa] ([Id])
GO
ALTER TABLE [dbo].[Ticket] CHECK CONSTRAINT [FK_Ticket_Mesa]
GO
/****** Object:  StoredProcedure [dbo].[PedirArticuloMesa]    Script Date: 24/02/2022 10:52:21 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO

CREATE PROCEDURE [dbo].[PedirArticuloMesa]
	@MesaId int,
	@ArticuloId int
AS
BEGIN
	
	declare @TicketId int

	if ((select count(*) from Ticket where MesaId = @MesaId and FechaCierre is null) = 0)
		begin
			select 'aquí ha entrado HDP'
			-- no hay ticket abierto
			insert into ticket (MesaId)
			values (@MesaId)

			set @TicketId = @@identity
			
		end
	else

		begin
			-- ya hay ticket abierto
			select @TicketId = Id from Ticket where MesaId = @MesaId and FechaCierre is null
		end

	
	if ((select count(*) from linea where ArticuloId = @ArticuloId and TicketId = @TicketId)=0)
		begin
			-- No existe el articulo en el ticket

			insert into Linea (TicketId,ArticuloId,Nombre,TipoIvaId,PrecioFinal,Unidades)
			select @TicketId, @ArticuloId , Nombre,TipoIvaId,PrecioFinal,1
			from Articulo where Id = @ArticuloId

		end
		else
		begin
				update Linea set Unidades = Unidades + 1
				where TicketId = @TicketId and ArticuloId  =  @ArticuloId  
		end
	




END
GO
USE [master]
GO
ALTER DATABASE [Bar] SET  READ_WRITE 
GO
