package com.example.to_do_list.dto;

import com.example.to_do_list.validation.ValidDescription;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Detail {
    @NotBlank
    private String title;

    @ValidDescription
    private String description;
}
