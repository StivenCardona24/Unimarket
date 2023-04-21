package co.edu.uniquindio.proyecto.Servicios.Interfaces;

import co.edu.uniquindio.proyecto.Modelo.DTO.*;
import co.edu.uniquindio.proyecto.Repositorios.TarjetaRepository;

import java.util.List;

public interface TarjetaServicio {

    int crearTarjeta(TarjetaDTO tarjetaDTO)throws Exception;

    TarjetaGetDto obtenerTarjeta(int codigoTarjeta) throws Exception;

    int eliminarTarjeta(int codigoTarjeta)throws Exception;

    TarjetaGetDto actualizarTarjeta(int codigoTarjeta, TarjetaDTO terjetaDTO) throws Exception;


    List<TarjetaGetDto> obtenerTarjetaUsuario(int codigoUsuario) throws Exception;
}
