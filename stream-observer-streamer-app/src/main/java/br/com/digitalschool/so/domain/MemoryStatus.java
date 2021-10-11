package br.com.digitalschool.so.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MemoryStatus {
    private long id;
    private double usage;
    private double available;
}
