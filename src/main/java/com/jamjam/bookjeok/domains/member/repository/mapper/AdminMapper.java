package com.jamjam.bookjeok.domains.member.repository.mapper;

import com.jamjam.bookjeok.domains.member.dto.request.PageRequest;
import com.jamjam.bookjeok.domains.member.dto.request.MemberSearchRequest;
import com.jamjam.bookjeok.domains.member.dto.MemberDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface AdminMapper {

    List<MemberDTO> findAllMember(PageRequest pageRequest);

    long countMembers();

}
