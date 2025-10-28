package com.ngc.Ex20_Lec152.Repository;

import com.ngc.Ex20_Lec152.Model.Holiday;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HolidaysRepository extends CrudRepository<Holiday, String> {

}
