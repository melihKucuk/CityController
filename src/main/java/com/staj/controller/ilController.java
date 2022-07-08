package com.staj.controller;

import com.staj.ilservice.ilService;
import com.staj.model.il;
import lombok.AllArgsConstructor;
import org.apache.http.HttpStatus;
import org.elasticsearch.snapshots.SnapshotMissingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.xml.namespace.QName;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@RequestMapping("/iller")
@RestController
@AllArgsConstructor


public class ilController{

    private final ilService ilService;

    @GetMapping
    public ResponseEntity<List<il>> getiller(String name){
        return new  ResponseEntity<>(ilService.getiller(name), org.springframework.http.HttpStatus.valueOf(HttpStatus.SC_OK));
    }
        @GetMapping("/{id}")
    public ResponseEntity<il> getil(@PathVariable String id) {
        return new ResponseEntity<>(getilById(id), org.springframework.http.HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<il> createil(@RequestBody il newil){
        return new ResponseEntity<>(ilService.createil(newil), org.springframework.http.HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<Void>getil(@PathVariable String id,@RequestBody il newil){
        il oldil=getilById(id);
        oldil.setName(newil.getName());
        oldil.setCreatedate(new Date());

        ilService.updateil(id,newil);

        return new ResponseEntity<>(org.springframework.http.HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void>deleteil(@PathVariable String id){
        ilService.deleteil(id);
        return new ResponseEntity<>(org.springframework.http.HttpStatus.OK);

    }


    public il getilById(String id){
        ilService.getilById(id);

        return null;
    }

}
