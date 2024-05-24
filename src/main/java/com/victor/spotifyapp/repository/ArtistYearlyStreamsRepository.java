package com.victor.spotifyapp.repository;

import com.victor.spotifyapp.model.ArtistYearlyStreams;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ArtistYearlyStreamsRepository extends MongoRepository<ArtistYearlyStreams, String> {


    // Método para buscar os 15 primeiros artistas
    //List<ArtistYearlyStreams> findTop15ByOrderByArtistAsc();
    // Métodos para operações básicas no banco de dados
    List<ArtistYearlyStreams> findByArtist(String artist);
    List<ArtistYearlyStreams> findByYear(int year);
    List<ArtistYearlyStreams> findByRegion(String region);
    List<ArtistYearlyStreams> findByTotalStreamsGreaterThan(int totalStreams);
    List<ArtistYearlyStreams> findByTotalStreamsLessThan(int totalStreams);
    List<ArtistYearlyStreams> findByTotalStreamsBetween(int minTotalStreams, int maxTotalStreams);
}

