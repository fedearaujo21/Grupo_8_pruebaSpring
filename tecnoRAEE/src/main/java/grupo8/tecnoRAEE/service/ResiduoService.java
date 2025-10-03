package grupo8.tecnoRAEE.service;

import java.util.List;

import grupo8.tecnoRAEE.dao.ResiduoDao;
import grupo8.tecnoRAEE.dto.ResiduoDTO;
import grupo8.tecnoRAEE.model.Residuo;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ResiduoService {

    private final ResiduoDao residuoDao;

    public ResponseEntity<List<ResiduoDTO>> listarResiduosValidos() {
        try {
            List<Residuo> residuosValidos = residuoDao.listarValidos();

            List<ResiduoDTO> res = residuosValidos.stream()
                    .map(r -> new ResiduoDTO(r.getNombre(), r.getCodigo()))
                    .toList();
            return ResponseEntity.ok(res);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }
}
