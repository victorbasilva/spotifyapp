package com.victor.spotifyapp.service;

import com.victor.spotifyapp.model.ArtistYearlyStreams;
import com.victor.spotifyapp.repository.ArtistYearlyStreamsRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ArtistYearlyStreamsService {

    private final ArtistYearlyStreamsRepository repository;

    public ArtistYearlyStreamsService(ArtistYearlyStreamsRepository repository) {
        this.repository = repository;
    }

    public List<ArtistYearlyStreams> findAll() {
        return repository.findAll();
    }

    public Optional<ArtistYearlyStreams> findById(String id) {
        return repository.findById(id);
    }

    public void save(ArtistYearlyStreams artistYearlyStreams) {
        repository.save(artistYearlyStreams);
    }

    public void deleteById(String id) {
        repository.deleteById(id);
    }
}

