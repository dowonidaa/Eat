package com.project.eat.address;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddService {


    @Autowired
    private AddressDAO_JPA jpa;

    public List<AddressVO_JPA> selectAll_add() {
        return jpa.findAll();
        //return jpa.selectAll_JPQL();//JPQL
    }

    public AddressVO_JPA updateOK(AddressVO_JPA vo) {

        AddressVO_JPA existingAddress = jpa.findBymId(vo.getMId()); // 기존의 멤버 정보를 조회

        // 입력 받은 값과 기존 값 중에서 값이 존재하는 것을 우선적으로 선택
        existingAddress.setMId(vo.getMId() != null ? vo.getMId() : existingAddress.getMId());
        existingAddress.setAddress(vo.getAddress() != null ? vo.getAddress() : existingAddress.getAddress());


        // 기존의 멤버 정보를 저장하여 업데이트
        return jpa.save(existingAddress);
    }

    public AddressVO_JPA selectOneById(AddressVO_JPA vo) {
        return jpa.findBymId(vo.getMId());
    }

}