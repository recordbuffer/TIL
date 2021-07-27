package jpabook.jpashop;

import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class TestMemberRepository {

    @PersistenceContext
    private EntityManager em;

    public long save(TestMember member){    //Ctrl+shift+T : test단축키
        em.persist(member);
        return member.getId();
    }

    public TestMember find(Long id){
        return em.find(TestMember.class, id);
    }
}
