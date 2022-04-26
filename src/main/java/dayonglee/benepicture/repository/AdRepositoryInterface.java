package dayonglee.benepicture.repository;


import dayonglee.benepicture.model.Ad;

import java.util.List;

public interface AdRepositoryInterface {

    Ad save(Ad ad);

    List<Ad> findAll();
}
