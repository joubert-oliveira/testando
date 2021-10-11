package br.com.digitalschool.so.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Disk {
    private long id;
    private String name;
    private String model;
    private String serial;
    private long size;
    List<DiskStatus> diskStatuses = new ArrayList<>();
}
