package com.ISST18.tucomunidad.tucomunidad.service;

import java.util.ArrayList;

import com.ISST18.tucomunidad.tucomunidad.model.Reserva;
import com.ISST18.tucomunidad.tucomunidad.repository.ReservaRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReservaService {
    @Autowired
    ReservaRepository reservaRepository;

    public ArrayList<Reserva> getAllReserva() {
        ArrayList<Reserva> reservas = new ArrayList<Reserva>();
        reservaRepository.findAll().forEach(reserva -> reservas.add(reserva));
        return reservas;
    }

    public Reserva getReservaById(Long id) {
        return reservaRepository.findById(id).get();
    }

    public String newReserva(Reserva reserva) {
        ArrayList<Reserva> reservas = getAllReserva();
        for (Reserva r : reservas) {
            if(reserva.getHoraInicio() == r.getHoraInicio() && reserva.getInstalacionId() == r.getInstalacionId()){
                return "La hora de inicio ya esta reservada";
            }
        }
        reservaRepository.save(reserva);
        return "Reserva realizada";
    }

    public Reserva getReservaByHoraInicio(int horaInicio, int instalacionId) {
        ArrayList<Reserva> reservas = getAllReserva();
        for (Reserva r : reservas) {
            if(r.getHoraInicio() == horaInicio && r.getInstalacionId() == instalacionId){
                return r;
            }
        }
        return null;
    }

    public void delete(Long id) {
        reservaRepository.deleteById(id);
    }
}
