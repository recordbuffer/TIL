package jpabook.jpashop.service;

import jpabook.jpashop.domain.Member;
import jpabook.jpashop.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)     //읽기 전용으로 성능 최적화됨
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;


    //회원가입
    @Transactional      //읽기전용 아님 명시 false
    public Long join(Member member){
        validateDuplicateMember(member);    //중복회원검증
        memberRepository.save(member);
        return member.getId();
    }

    //중복회원 있으면 예외처리
    private void validateDuplicateMember(Member member) {
        //EXCEPTION
        List<Member> findMembers = memberRepository.findByName(member.getName());
        if(!findMembers.isEmpty()){
            throw new IllegalStateException("이미 존재하는 회원입니다.");
        }
    }

    //회원 전체 조회
    private List<Member> findMembers(){
        return memberRepository.findAll();
    }

    //회원 한명 조회
    private Member findOne(Long memberId){
        return memberRepository.findOne(memberId);
    }
}
