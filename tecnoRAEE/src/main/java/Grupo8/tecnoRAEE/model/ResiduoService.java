package grupo8.tecnoRAEE.model;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class ResiduoService {
    
    private final ResiduoImp residuoImp;

    public ResiduoService(ResiduoImp residuoImp){
        this.residuoImp=residuoImp;
    }

    public ResponseEntity<List<ResiduoDTO>> listarResiduosValidos() {
        List<Residuo> residuosValidos = residuoImp.getResiduos();

        List<ResiduoDTO> res = residuosValidos.stream()
                .map(r -> new ResiduoDTO(r.getNombre(), r.getCodigo()))
                .toList();
        return new ResponseEntity<>(res, HttpStatus.OK);
    }

}
