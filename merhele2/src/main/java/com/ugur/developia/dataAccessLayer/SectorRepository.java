package com.ugur.developia.dataAccessLayer;

import com.ugur.developia.entity.Sector;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SectorRepository extends JpaRepository<Sector,Integer> {

}
