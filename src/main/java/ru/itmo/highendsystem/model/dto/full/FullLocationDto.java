package ru.itmo.highendsystem.model.dto.full;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Полное дто локации
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class FullLocationDto {
    private Long id;
    private String country;
    private String city;
    private String airport;

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj.getClass() != this.getClass()) {
            return false;
        }

        final FullLocationDto other = (FullLocationDto) obj;

        return other.getCity().equals(this.city) &&
                other.getCountry().equals(this.country) &&
                other.getAirport().equals(this.airport);
    }
}
