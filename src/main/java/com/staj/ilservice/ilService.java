package com.staj.ilservice;

import com.staj.model.il;
import com.staj.repository.ilRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ilService {

    private final ilRepository ilRepository;

    public List<il> getiller(String name) {

        return ilRepository.findAll();
    }

    public il createil(il newil) {
        return ilRepository.save(newil);
    }

    public void deleteil(String id) {
        ilRepository.deleteById(id);
    }

    public il getilById(String id) {
        Optional<il>byId=ilRepository.findById(id);
        if (byId.isEmpty()){
            throw new RuntimeException("İl bulunamadı.");
        }
        return byId.get();

    }

    public void updateil(String id, il newil) {
        il oldil=getilById(id);
        oldil.setName(newil.getName());
        ilRepository.save(oldil);
    }
}
