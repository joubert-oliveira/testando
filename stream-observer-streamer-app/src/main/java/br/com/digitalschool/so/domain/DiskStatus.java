package br.com.digitalschool.so.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DiskStatus {
    private long id;
    private long readings;
    private long readBytes;
    private long written;
    private long writtenBytes;
    private long transferTime;
}
