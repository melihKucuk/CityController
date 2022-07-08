package com.staj.ilservice;

import com.staj.model.il;
import com.staj.repository.ilRepository;
import lombok.AllArgsConstructor;
import org.elasticsearch.repositories.FilterRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ilService {

    private final ilRepository ilRepository;

    public List<il> getiller() {

        return ilRepository.findAll();
    }

    public il createil(il newil) {
        return ilRepository.save(newil);
    }

    public void deleteil(String id) {
        ilRepository.deleteById(id);
    }

    public void getilById(String id) {
        ilRepository.findById(id);
    }
}
