package dayonglee.benepicture.web;


import dayonglee.benepicture.model.Ad;
import dayonglee.benepicture.service.AdService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.Random;
import java.util.UUID;

@Slf4j
@Controller
@RequestMapping("/ad")
@RequiredArgsConstructor
public class AdController {

    private final AdService adService;

    @GetMapping("/addAd")
    public String addAdPage(){
        return "/ad/addAdForm";
    }

    @PostMapping("/addAd")
    public String addAd(@RequestParam(required = false) MultipartFile adImage,@ModelAttribute Ad ad) throws IOException {

        log.info("ad = {}",ad);
        log.info("adImage = {}",adImage);

        Random random = new Random();
        int adId = random.nextInt();
        ad.setAdId(adId);


        String storeFileName = "";
        if(!adImage.isEmpty()){
            String fildDir = "/Users/jeong-useog/Desktop/spring/adImage/"; // 로컬에 파일을 저장하도록 설정
            String originalFileName = adImage.getOriginalFilename();
            storeFileName = createStoreFileName(originalFileName);

            String fullPath = fildDir+storeFileName;
            adImage.transferTo(new File(fullPath));

        }
        ad.setAdImageURI(storeFileName);


        adService.save(ad);

        return "redirect:/";
    }

    private String createStoreFileName(String originalFileName) {
        String ext = extractExt(originalFileName);

        String uuid = UUID.randomUUID().toString();
        return uuid+"."+ext;
    }

    private String extractExt(String originalFileName) {
        int pos = originalFileName.lastIndexOf(".");
        return originalFileName.substring(pos+1);
    }
}
