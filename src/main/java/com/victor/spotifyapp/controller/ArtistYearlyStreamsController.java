package com.victor.spotifyapp.controller;

import com.victor.spotifyapp.model.ArtistYearlyStreams;
import com.victor.spotifyapp.service.ArtistYearlyStreamsService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping("/artists")
public class ArtistYearlyStreamsController {

    @Autowired
    private ArtistYearlyStreamsService service;

    @GetMapping
    public String getAllArtists(@PageableDefault(size = 10) Pageable pageable, Model model) {
        Page<ArtistYearlyStreams> page = service.findAll(pageable);
        model.addAttribute("artists", page.getContent());
        model.addAttribute("page", page);
        return "artists/list";
    }


    @GetMapping("/{id}")
    public String getArtistById(@PathVariable String id, Model model) {
        Optional<ArtistYearlyStreams> artist = service.findById(id);
        if (artist.isPresent()) {
            model.addAttribute("artist", artist.get());
            return "artists/view";
        } else {
            return "artists/notfound";
        }
    }

    @GetMapping("/add")
    public String addArtistForm(Model model) {
        model.addAttribute("artist", new ArtistYearlyStreams());
        return "artists/add";
    }

    @PostMapping
    public String addArtist(@Valid @ModelAttribute ArtistYearlyStreams artistYearlyStreams, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "artists/add";
        }
        service.save(artistYearlyStreams);
        return "redirect:/artists";
    }

    @GetMapping("/edit/{id}")
    public String editArtistForm(@PathVariable String id, Model model) {
        Optional<ArtistYearlyStreams> artist = service.findById(id);
        if (artist.isPresent()) {
            model.addAttribute("artist", artist.get());
            return "artists/edit";
        } else {
            return "artists/notfound";
        }
    }

    @PostMapping("/edit/{id}")
    public String editArtist(@PathVariable String id, @Valid @ModelAttribute ArtistYearlyStreams artistYearlyStreams, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "artists/edit";
        }
        artistYearlyStreams.setId(id);
        service.save(artistYearlyStreams);
        return "redirect:/artists";
    }

    @GetMapping("/delete/{id}")
    public String deleteArtist(@PathVariable String id) {
        service.deleteById(id);
        return "redirect:/artists";
    }
}


