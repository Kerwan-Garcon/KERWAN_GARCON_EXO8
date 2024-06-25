package com.exo2.Exercice2.service;

import com.exo2.Exercice2.dto.AdresseDto;
import com.exo2.Exercice2.mapper.AdresseMapper;
import com.exo2.Exercice2.repository.AdresseRepository;
import lombok.AllArgsConstructor;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class AdresseService {
    private AdresseRepository adresseRepository;
    private AdresseMapper adresseMapper;

    @Cacheable(value = "adresses", key = "#pageable.pageNumber + '-' + #pageable.pageSize")
    public Page<AdresseDto> findAll(Pageable pageable) {
        return adresseRepository.findAll(pageable).map(adresse -> adresseMapper.toDto(adresse));
    }

    @Cacheable(value = "adresses", key = "#id")
    public AdresseDto findById(Long id) {
        return adresseMapper.toDto(adresseRepository.findById(id).get());
    }

    @Cacheable(value = "adresses", key = "#ville")
    public List<AdresseDto> findByVille(String ville) {
        return adresseMapper.toDtos(adresseRepository.findAdresseByVille(ville));
    }
}
