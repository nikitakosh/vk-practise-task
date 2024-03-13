package org.nikita.vkpractisetask.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Post {
    private Integer id;
    private Integer userId;
    private String title;
    private String body;
}
