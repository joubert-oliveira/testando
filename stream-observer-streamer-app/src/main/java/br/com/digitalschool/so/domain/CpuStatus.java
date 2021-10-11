package br.com.digitalschool.so.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CpuStatus {
    private long id;
    private double usage;
    private double temperature;
}
