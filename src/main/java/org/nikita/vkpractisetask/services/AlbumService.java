package org.nikita.vkpractisetask.services;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.nikita.vkpractisetask.client.TypiCodeClient;
import org.nikita.vkpractisetask.models.Album;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AlbumService {
    private final TypiCodeClient client;


    public List<Album> findAllAlbums() {
        return client.findAllAlbums();
    }

    public Album addAlbum(Album album) {
        return client.addAlbum(album);
    }

    public Album updateAlbum(Album album, int id) {
        return client.updateAlbum(album, id);
    }

    public void deleteAlbum(int id) {
        client.deleteAlbum(id);
    }

    public Album findAlbum(int id) {
        return client.findAlbum(id);
    }
}
