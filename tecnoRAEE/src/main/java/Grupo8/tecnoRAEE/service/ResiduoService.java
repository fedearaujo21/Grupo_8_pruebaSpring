package Grupo8.tecnoRAEE.service;

import java.util.List;

import Grupo8.tecnoRAEE.dto.*;
import Grupo8.tecnoRAEE.model.*;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


@Service
@AllArgsConstructor
public class ResiduoService {
    
    private final ResiduoImp residuoImp;

    public ResponseEntity<List<ResiduoDTO>> listarResiduosValidos() {
        try{
            List<Residuo> residuosValidos = residuoImp.listarValidos();

            List<ResiduoDTO> res = residuosValidos.stream()
                    .map(r -> new ResiduoDTO(r.getNombre(), r.getCodigo()))
                    .toList();
            return ResponseEntity.ok(res);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
        }
    }

}
