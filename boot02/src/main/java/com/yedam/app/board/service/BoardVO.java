package com.yedam.app.board.service;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
public class BoardVO {
    private Integer bno;     //번호
    private String title;    //제목
    private String contents; //내용
    private String writer;   //작성자
    @DateTimeFormat(pattern ="yyyy-MM-dd")
    private Date regDate;    //작성일
    private Date updateDate; //수정일
    private String image;    //첨부이미지
}