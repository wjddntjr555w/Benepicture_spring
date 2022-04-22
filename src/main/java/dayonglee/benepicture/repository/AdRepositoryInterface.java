package dayonglee.benepicture.repository;


import dayonglee.benepicture.domain.ad.Ad;

import java.util.List;

public interface AdRepositoryInterface {

    Ad save(Ad ad);

    List<Ad> findAll();
}
