package com.sparta.week3.service;

import com.sparta.week3.domain.Memo;
import com.sparta.week3.domain.MemoRepository;
import com.sparta.week3.domain.MemoRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@RequiredArgsConstructor
@Service
public class MemoService {

    private final MemoRepository memoRepository;

    @Transactional
    public Long update(Long id, MemoRequestDto requestDto){
        Memo memo = memoRepository.findById(id).orElseThrow(
                () -> new NullPointerException("NO ID")
        );
        memo.update(requestDto);
        return id;
    }


}
