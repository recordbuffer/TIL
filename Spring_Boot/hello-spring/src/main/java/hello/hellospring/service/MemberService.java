package hello.hellospring.service;

import hello.hellospring.domain.Member;
import hello.hellospring.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

//@Service
@Transactional      //DB 데이터 저장 사용할 떄 필요 > JPA
public class MemberService {

    //MemberService & MemoryMemberRepository 다른 인스턴스 쓰고 있음
    //private final MemberRepository memberRepository = new MemoryMemberRepository();
    //같은 인스턴스 사용하도록 바꾸려면?
    private final MemberRepository memberRepository;

    //@Autowired
    public MemberService(MemberRepository memberRepository) {   //new에서 생성하는게 아니라 외부에서 넣어주도록함 > DI
        this.memberRepository = memberRepository;
    }


    //회원가입
    public Long join(Member member){

        //같은 이름 있는 중복회원 X
        //null 일 가능성이 잇으면 optional에 감싸 리턴
        //Optional<Member> result = memberRepository.findByName(member.getName());    //ctrl + alt + v 변수 리팩토링

        //extract method : ctrl + alt + m
        validateDuplicateMember(member);

        memberRepository.save(member);
        return member.getId();              //id 반환
    }

    private void validateDuplicateMember(Member member) {
        memberRepository.findByName(member.getName())
                .ifPresent(m -> {
            throw new IllegalStateException("이미 존재하는 회원입니다.");
        });
    }


    //전체 회원 조회
    public List<Member> findMembers(){
        return memberRepository.findAll();
    }


    //id로 회원 찾기기
    public Optional<Member> findOne(Long memberId){
        return memberRepository.findById(memberId);
    }


}
