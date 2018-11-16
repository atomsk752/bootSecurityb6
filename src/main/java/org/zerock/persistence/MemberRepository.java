package org.zerock.persistence;

import org.springframework.data.repository.CrudRepository;
import org.zerock.domain.Member;
import org.zerock.domain.MemberAuth;

public interface MemberRepository extends CrudRepository<Member, String> {

}
