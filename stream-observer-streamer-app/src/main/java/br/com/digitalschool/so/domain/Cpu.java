package br.com.digitalschool.so.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Cpu {
    private long id;
    private String name;
    private String modelIdentifier;
    private String microArchitecture;
    private long frequency;
    private int physicalPackages;
    private int physicalCpus;
    private int logicalCpus;
    private List<CpuStatus> cpuStatuses = new ArrayList<>();
}
