package dayonglee.benepicture.service;


import dayonglee.benepicture.domain.ad.Ad;
import dayonglee.benepicture.domain.ad.AdRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
@RequiredArgsConstructor
public class AdService {

    private final AdRepository adRepository;

    @Transactional
    public Ad save(Ad ad){
        return adRepository.save(ad);
    }
}