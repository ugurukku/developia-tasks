package com.ugur.developia.businessLayer;

import com.ugur.developia.dataAccessLayer.SectorRepository;
import com.ugur.developia.entity.Sector;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class SectorService implements Operations<Sector> {

    private final SectorRepository sectorRepository;

    @Autowired
    public SectorService(SectorRepository sectorRepository) {
        this.sectorRepository = sectorRepository;
    }

    @Override
    public List<Sector> getAll() {
        return sectorRepository.findAll();
    }

    @Override
    public Sector getById(Integer id) {
        return sectorRepository.findById(id).get();
    }

    @Override
    public boolean removeById(Integer id) {
        sectorRepository.deleteById(id);
        return true;
    }

    @Override
    public boolean add(Sector sector) {
        sectorRepository.save(sector);
        return true;
    }

    @Override
    public boolean updateById(Sector entity, Integer id) {
        sectorRepository.save(entity);
        return true;
    }
}
