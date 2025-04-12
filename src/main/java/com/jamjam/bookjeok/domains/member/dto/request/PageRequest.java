package com.jamjam.bookjeok.domains.member.dto.request;

import jakarta.validation.constraints.Min;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PageRequest {

    @Min(value = 1)
    private Integer page = 1;

    @Min(value = 1)
    private Integer size = 10;

    public int getOffset(){
        return (page-1) * size;
    }

    public int getLimit(){
        return size;
    }
}
