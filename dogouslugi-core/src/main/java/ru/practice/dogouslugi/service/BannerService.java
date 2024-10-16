package ru.practice.dogouslugi.service;

import org.springframework.stereotype.Service;
import ru.practice.dogouslugi.dao.BannerRepository;
import ru.practice.dogouslugi.model.Banner;

import java.util.LinkedList;
import java.util.List;

@Service
public class BannerService {
    private final BannerRepository bannerRepository;

  public BannerService(BannerRepository bannerRepository) {
    this.bannerRepository = bannerRepository;
  }

  public List<Banner> listBanner() {
        List<Banner> list = new LinkedList<>();
        Iterable<Banner> all = bannerRepository.findAll();
        all.forEach(list::add);
        return list;
    }
}
