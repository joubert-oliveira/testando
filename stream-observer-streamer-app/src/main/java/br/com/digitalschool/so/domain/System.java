package br.com.digitalschool.so.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class System {
    private long id;
    private String operationalSystem;
    private String manufacturer;
    private String architecture;
    private String permission;
    List<SystemStatus> systemStatuses = new ArrayList<>();
}
