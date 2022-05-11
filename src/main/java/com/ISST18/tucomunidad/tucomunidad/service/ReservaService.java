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

    public Boolean newReserva(Reserva reserva) {
        ArrayList<Reserva> reservas = getAllReserva();
        for (Reserva r : reservas) {
            if(reserva.getHoraInicio() == r.getHoraInicio() && reserva.getInstalacionId() == r.getInstalacionId()){
                return false;
            }
        }
        reservaRepository.save(reserva);
        return true;
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
