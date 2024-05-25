package com.victor.spotifyapp.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection = "artist_yearly_streams")
public class ArtistYearlyStreams {

    @Id
    private String id;

    @NotBlank
    @Size(max = 255)
    private String artist;

    @NotNull
    private Integer year;

    @NotBlank
    @Size(max = 255)
    private String region;

    @Field("total_streams")
    @NotNull(message = "Total streams is required")
    private Integer totalStreams;

    // Getters and Setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public Integer getTotalStreams() {
        return totalStreams;
    }

    public void setTotalStreams(Integer totalStreams) {
        this.totalStreams = totalStreams;
    }
}


