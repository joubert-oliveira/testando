package br.com.digitalschool.so.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Streamer {
    private long id;
    private String username;
    private String password;
    private List<Machine> machines;
}
