package org.nikita.vkpractisetask.controller;

import java.time.LocalDateTime;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.nikita.vkpractisetask.models.Album;
import org.nikita.vkpractisetask.models.Audit;
import org.nikita.vkpractisetask.services.AlbumService;
import org.nikita.vkpractisetask.services.AuditService;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/albums")
@RequiredArgsConstructor
@Slf4j
public class AlbumController {
    private final AlbumService albumService;
    private final AuditService auditService;
    @GetMapping
    public List<Album> findAllAlbums() {
        return albumService.findAllAlbums();
    }

    @GetMapping("/{id}")
    @Cacheable(cacheNames = "albums", key = "#id")
    public Album findAlbum(@PathVariable("id") int id) {
        return albumService.findAlbum(id);
    }

    @PostMapping
    @CachePut(cacheNames = "albums", key = "#album.id")
    public Album addAlbum(@RequestBody Album album) {
        return albumService.addAlbum(album);
    }

    @PutMapping("/{id}")
    @CachePut(cacheNames = "albums", key = "#album.id")
    public Album updateAlbum(@RequestBody Album album, @PathVariable("id") int id) {
        return albumService.updateAlbum(album, id);
    }

    @DeleteMapping("/{id}")
    @CacheEvict(cacheNames = "albums", key = "#id")
    public void deleteAlbum(@PathVariable("id") int id) {
        albumService.deleteAlbum(id);
    }
}
